CREATE DEFINER = 'utest'@'%'
PROCEDURE qxyybak.SYNC_DATA_QSYY2LEYA_PRO(in appointOrderId varchar(40),OUT resultVal VARCHAR(2))
  BEGIN
    DECLARE SQL_ERROR_FLAG INTEGER DEFAULT 0;
    DECLARE autocommit INTEGER DEFAULT 0;
    DECLARE ROLE_CODE varchar(30);
    DECLARE LOGIN_MOBILE_TEMP varchar(30);
    DECLARE APPOINT_ORDER_COUNT  INT DEFAULT 0;
    DECLARE MEMBER_COUNT INT DEFAULT 0;
    DECLARE PATIENT_COUNT INT DEFAULT 0;
    DECLARE MOBILE_COUNT INT DEFAULT 0;
    DECLARE ADDRESS_COUNT INT DEFAULT 0;
    DECLARE LEYA_LOGINUSER_MASTER_ID CHAR(32);
    DECLARE LEYA_CUSTOMER_ID CHAR(32);
    DECLARE LEYA_CERT_TYPE VARCHAR (10);
    DECLARE INSTITUTION_MARK VARCHAR(3) DEFAULT 'no';
    DECLARE MEMBER_MARK INT DEFAULT 9;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET SQL_ERROR_FLAG = 1;
    SET autocommit = 0;

    SELECT
      rt.ROLE_CODE
    INTO ROLE_CODE FROM
      `newzhuce`.role_type rt
    WHERE
      rt.ROLE_VALUE = 'MEMBER';
    SELECT
      lti.LOGIN_TYPE_CODE
    INTO LOGIN_MOBILE_TEMP FROM
      `newzhuce`.login_type_item lti
    WHERE
      lti.LOGIN_TYPE_VALUE = 'MOBILE';
    -- 查询机构的标记（YES潜在，NO非潜在）
    SELECT qs.is_LATENT
    INTO INSTITUTION_MARK
    FROM
      mem_appoint_order_bak maob,
      qsyy_register qr,
      qsyy_switch qs
    WHERE
      maob.C_INSTITUTION_ID = qr.CLIENT_ID
      AND qr.ID = qs.QSYY_REGISTER_ID
      AND maob.ID = appointOrderId;

    SELECT
      @ORDER_ID:=ID,
      @A_C_CREATE_DATE:=C_CREATE_DATE,
      @A_C_DELETE_FLAG:=C_DELETE_FLAG,
      @A_C_ORDER_NO:=C_ORDER_NO,
      @A_C_MEMBER_ID:=C_MEMBER_ID,
      @A_C_PATIENT_ID:=C_PATIENT_ID,
      @A_C_INSTITUTION_ID:=C_INSTITUTION_ID,
      @A_C_APPOINT_DATE:=C_APPOINT_DATE,
      @A_C_APPOINT_HOUR_RANGE:=C_APPOINT_HOUR_RANGE,
      @A_C_APPOINT_STATUS:=C_APPOINT_STATUS,
      @A_C_IS_HOLD_CARD:=C_IS_HOLD_CARD,
      @A_C_COMPLAINT:=C_COMPLAINT,
      @A_C_CLOSING_STATUS:=C_CLOSING_STATUS,
      @A_C_IS_HAS_REMIND:=C_IS_HAS_REMIND
    FROM
      `mem_appoint_order_bak` OBAK
    WHERE
      OBAK.id = appointOrderId
      AND OBAK.`SYNC` = 0
      AND OBAK.`DATATYPE` = 0;
    IF(ISNULL(@ORDER_ID) <> 1 && LENGTH(@ORDER_ID)>=1 && @ORDER_ID <> 'null') THEN
      SELECT @P_PATIENT_ID:=ID,@P_C_CREATE_DATE:=C_CREATE_DATE,@P_C_DELETE_FLAG:=C_DELETE_FLAG,@P_C_NAME:=C_NAME,@P_C_SEX:=C_SEX,@P_C_BIRTHDATE:=C_BIRTHDATE,@P_C_ID_CARD:=C_ID_CARD,@P_C_MOBILE:=C_MOBILE,@P_C_ADDRESS:=C_ADDRESS,@P_C_MEMBER_ID:=C_MEMBER_ID
      FROM mem_patient_bak WHERE ID=@A_C_PATIENT_ID;
      IF(ISNULL(@P_PATIENT_ID) <> 1 && LENGTH(@P_PATIENT_ID)>=1 && @P_PATIENT_ID <> 'null')THEN
        SELECT COUNT(ID) INTO APPOINT_ORDER_COUNT FROM `newzhuce`.mem_appoint_order WHERE ID = @ORDER_ID;
        IF APPOINT_ORDER_COUNT <> 0 THEN
          UPDATE `newzhuce`.mem_appoint_order SET C_APPOINT_DATE=@A_C_APPOINT_DATE ,
            C_APPOINT_HOUR_RANGE=@A_C_APPOINT_HOUR_RANGE,C_COMPLAINT=@A_C_COMPLAINT WHERE ID=@ORDER_ID ;
        ELSE
          INSERT INTO `newzhuce`.mem_appoint_order(ID,C_CREATE_DATE,C_DELETE_FLAG,C_ORDER_NO,C_MEMBER_ID,C_PATIENT_ID,C_INSTITUTION_ID,C_APPOINT_DATE,C_APPOINT_HOUR_RANGE,C_APPOINT_STATUS,C_IS_HOLD_CARD,C_COMPLAINT,C_CLOSING_STATUS,C_IS_HAS_REMIND,C_SOURCE,C_CLOSING_AMOUNT)
          VALUES (@ORDER_ID,@A_C_CREATE_DATE,@A_C_DELETE_FLAG,@A_C_ORDER_NO,@A_C_MEMBER_ID,@A_C_PATIENT_ID,@A_C_INSTITUTION_ID,@A_C_APPOINT_DATE,@A_C_APPOINT_HOUR_RANGE,@A_C_APPOINT_STATUS,@A_C_IS_HOLD_CARD,@A_C_COMPLAINT,@A_C_CLOSING_STATUS,@A_C_IS_HAS_REMIND,1,0);
        END IF;

        SELECT
          COUNT(ID)
        INTO MEMBER_COUNT FROM
          `newzhuce`.mem_member
        WHERE
          ID = @A_C_MEMBER_ID;

        SELECT
          @MEMBER_ID:=ID,
          @C_CREATE_DATE:=C_CREATE_DATE,
          @C_DELETE_FLAG:=C_DELETE_FLAG,
          @C_ACCOUNT:=C_ACCOUNT,
          @C_PASSWORD:=C_PASSWORD,
          @C_ADDRESS:=C_ADDRESS,
          @C_LEVEL:=C_LEVEL,
          @C_STATUS:=C_STATUS,
          @M_MOBILE:=C_MOBILE,
          @M_SEX:=C_SEX,
          @M_BIRTHDAY:=C_BIRTHDATE,
          @M_IDCARD:=C_ID_CARD,
          @M_C_NAME:=`C_NAME`,
          @M_C_MEMBER_ID:=C_MEMBER_ID,
          @M_C_PROVINCE_ID:=C_PROVINCE_ID,
          @M_C_CITY_ID:=C_CITY_ID,
          @C_DISTRICT_ID:=C_DISTRICT_ID
        FROM
          mem_member_bak
        WHERE
          id = @A_C_MEMBER_ID;

        IF MEMBER_COUNT = 0 THEN
          -- 不存在会员
          SELECT c.ID INTO LEYA_CUSTOMER_ID FROM `newzhuce`.customer c WHERE c.NAME = @M_C_NAME AND c.CERT_TYPE = '1' AND c.CERT_NO = @M_IDCARD AND c.SEX = @M_SEX AND c.BIRTHDAY = @M_BIRTHDAY;
          IF(ISNULL(@M_IDCARD) <> 1 && LENGTH(@M_IDCARD )>=1 && @M_IDCARD  <> 'null') THEN
            SET  LEYA_CERT_TYPE='1';
          END IF;
          IF(ISNULL(LEYA_CUSTOMER_ID) = 1 || LENGTH(LEYA_CUSTOMER_ID) = 0 ||  LEYA_CUSTOMER_ID = 'null') THEN
            SET LEYA_CUSTOMER_ID = sys_guid();
            INSERT INTO `newzhuce`.customer (ID,`NAME`,CERT_TYPE,CERT_NO,SEX,BIRTHDAY,CREATE_DATE,UPDATE_DATE) VALUES (LEYA_CUSTOMER_ID,@M_C_NAME,LEYA_CERT_TYPE,@M_IDCARD,
                                                                                                                       @M_SEX,
                                                                                                                       @M_BIRTHDAY,
                                                                                                                       @C_CREATE_DATE,
                                                                                                                       @C_CREATE_DATE
            );
          END IF;

          SELECT
            ID
          INTO LEYA_LOGINUSER_MASTER_ID FROM
            `newzhuce`.login_user_master
          WHERE
            CUSTOMER_ID = LEYA_CUSTOMER_ID
          LIMIT 1;
          IF(LENGTH(LEYA_LOGINUSER_MASTER_ID) = 0 || ISNULL(LEYA_LOGINUSER_MASTER_ID) = 1) THEN
            SET LEYA_LOGINUSER_MASTER_ID=sys_guid();
            -- 添加---
            IF(LCASE(INSTITUTION_MARK)='yes') THEN
              SET MEMBER_MARK=0;
            ELSE
              IF(ISNULL(@M_MOBILE) <> 1 && LENGTH(@M_MOBILE)>=1 && @M_MOBILE  <> 'null') THEN
                SELECT @QIANZAIKEHU:=lum.qianzaikehu,@OLDMASTERID:=lum.id FROM `newzhuce`.login_user_expand ex,newzhuce.`login_user_master` lum WHERE ex.`LOGIN_USER_MASTER_ID`=lum.`ID` AND ex.EXPAND_VALUE=@M_MOBILE AND e.EXPAND_STATUS = 0 AND ex.LOGIN_TYPE_CODE = LOGIN_MOBILE_TEMP limit 1;
                IF (ISNULL(@QIANZAIKEHU)<>1 && LENGTH(@QIANZAIKEHU)>=1 &&@QIANZAIKEHU<>'null')THEN
                  IF(@QIANZAIKEHU=0)THEN
                    SET MEMBER_MARK=1;
                  ELSE
                    SET MEMBER_MARK=0;
                    INSERT INTO error_message(APPOINT_ORDER_ID,ERROR_MESSAGE)VALUES (appointOrderId,'存在用户id:'+@OLDMASTERID+'新建用户id:'+LEYA_LOGINUSER_MASTER_ID);
                  END IF ;
                ELSE
                  SET MEMBER_MARK=1;
                END IF ;
              END IF;
            END IF;
            IF(MEMBER_MARK<>9)THEN
              INSERT INTO `newzhuce`.login_user_master (
                ID,
                LOGIN_ACCOUNT,
                LOGIN_PASSWORD,
                LOGIN_STATUS,
                LOGIN_LAST_TIME,
                LOGIN_COUNT,
                SOURCE_IDENTITY,
                CUSTOMER_ID,
                QIANZAIKEHU,
                TONGDAOLAIYUAN,
                SHUJULAIYUAN
              ) VALUES (
                LEYA_LOGINUSER_MASTER_ID,
                @C_ACCOUNT,
                @C_PASSWORD,
                0,
                @C_CREATE_DATE,
                0,
                'QSYY',
                LEYA_CUSTOMER_ID,
                MEMBER_MARK,
                'LYWBJK',
                'QSYY'
              );
            END IF;
            -- 添加结束
            Insert INTO `newzhuce`.MEM_SUOSHU_MENZHENG (ID,LOGUSER_MASTER_ID,INSTITUTION_ID) VALUES (sys_guid(),LEYA_LOGINUSER_MASTER_ID,@A_C_INSTITUTION_ID);
            Insert INTO `newzhuce`.USER_RELATION_ROLE (ID,LOGIN_USER_MASTER_ID,ROLE_CODE,ROLE_STATUS) VALUES (sys_guid(),LEYA_LOGINUSER_MASTER_ID,ROLE_CODE,0);
          END IF;
          IF(ISNULL(@M_MOBILE) <> 1 && LENGTH(@M_MOBILE)>=1 && @M_MOBILE  <> 'null') THEN
            SELECT COUNT(ex.ID) into MOBILE_COUNT FROM `newzhuce`.login_user_expand ex
            WHERE ex.LOGIN_USER_MASTER_ID =LEYA_LOGINUSER_MASTER_ID AND ex.EXPAND_STATUS = 0 AND ex.LOGIN_TYPE_CODE = LOGIN_MOBILE_TEMP;
            IF MOBILE_COUNT <> 0 THEN
              UPDATE `newzhuce`.login_user_expand SET EXPAND_VALUE=@M_MOBILE WHERE LOGIN_USER_MASTER_ID=LEYA_LOGINUSER_MASTER_ID;
              UPDATE `newzhuce`.customer_contact_telphone
              SET
                PHONE_NUMBER = @M_MOBILE
              WHERE
                CUSTOMER_ID = LEYA_CUSTOMER_ID
                AND PHONE_TYPE = 9;
            ELSE
              INSERT INTO `newzhuce`.login_user_expand (ID,LOGIN_USER_MASTER_ID,LOGIN_TYPE_CODE,EXPAND_VALUE,EXPAND_STATUS,EXPAND_SORT) VALUES (sys_guid(),LEYA_LOGINUSER_MASTER_ID,LOGIN_MOBILE_TEMP,@M_MOBILE,0,1);
              INSERT INTO `newzhuce`.customer_contact_telphone (ID,CUSTOMER_ID,PHONE_NUMBER,PHONE_STATUS,PHONE_TYPE) VALUES (sys_guid(),LEYA_CUSTOMER_ID,@M_MOBILE,0,9);
            END IF;
          END IF;
          IF(ISNULL(@C_ADDRESS) <> 1 && LENGTH(@C_ADDRESS)>=1 && @C_ADDRESS  <> 'null') THEN
            SELECT COUNT(CA.ID) into ADDRESS_COUNT FROM `newzhuce`.customer_address CA WHERE  CA.ADDRESS_TYPE =9 AND CA.CUSTOMER_ID=LEYA_CUSTOMER_ID;
            IF ADDRESS_COUNT <> 0 THEN
              UPDATE `newzhuce`.customer_address SET ADDRESS_DETAIL=@C_ADDRESS WHERE CUSTOMER_ID=LEYA_CUSTOMER_ID;
            ELSE
              INSERT INTO `newzhuce`.customer_address (ID,CUSTOMER_ID,ADDRESS_TYPE,ADDRESS_STATUS,ADDRESS_DETAIL) VALUES (sys_guid(),LEYA_CUSTOMER_ID,9,0,@C_ADDRESS);
            END IF;
          END IF;
          -- 更新bak
          SELECT @M_MEMBER_ID:=id FROM `newzhuce`.mem_member WHERE CUSTOMER_ID=LEYA_CUSTOMER_ID;
          IF(ISNULL(@M_MEMBER_ID)<>1 && LENGTH(@M_MEMBER_ID)>=0 && @M_MEMBER_ID<>'null')THEN
            IF(@M_MEMBER_ID<>@MEMBER_ID)THEN
              SELECT @OLD_MEMBER_ID:=id FROM mem_member_bak WHERE id=@M_MEMBER_ID;
              -- 更新
              IF(ISNULL(@OLD_MEMBER_ID)<>1 && LENGTH(@OLD_MEMBER_ID)>=0 && @OLD_MEMBER_ID<>'null')THEN
                UPDATE `newzhuce`.mem_patient SET C_MEMBER_ID=@OLD_MEMBER_ID WHERE ID=@A_C_PATIENT_ID;
                UPDATE qsyy_blh SET MEMBER_ID=@OLD_MEMBER_ID WHERE INSTITUTION_ID=@A_C_INSTITUTION_ID AND MEMBER_ID=@A_C_MEMBER_ID AND PATIENT_ID=@A_C_PATIENT_ID;
                set @A_C_MEMBER_ID=@OLD_MEMBER_ID;
              ELSE
                UPDATE `newzhuce`.mem_patient SET C_MEMBER_ID=@M_MEMBER_ID WHERE ID=@A_C_PATIENT_ID ;
                UPDATE qsyy_blh SET MEMBER_ID=@M_MEMBER_ID WHERE INSTITUTION_ID=@A_C_INSTITUTION_ID AND MEMBER_ID=@A_C_MEMBER_ID AND PATIENT_ID=@A_C_PATIENT_ID;
                UPDATE mem_member_bak SET id=@M_MEMBER_ID WHERE ID = @A_C_MEMBER_ID;
                set @A_C_MEMBER_ID=@M_MEMBER_ID;
              END IF;
              UPDATE mem_appoint_order_bak SET C_MEMBER_ID=@A_C_MEMBER_ID  WHERE ID = @ORDER_ID;
            END IF;
          ELSE
            Insert INTO `newzhuce`.mem_member(ID,C_CREATE_DATE,C_DELETE_FLAG,C_ADDRESS,C_LEVEL,C_STATUS,C_MEMBER_ID,CUSTOMER_ID) values(@MEMBER_ID,@C_CREATE_DATE,@C_DELETE_FLAG,@C_ADDRESS,@C_LEVEL,@C_STATUS,@M_C_MEMBER_ID,LEYA_CUSTOMER_ID);
          END IF;
        END IF;
        SELECT
          COUNT(ID)
        INTO PATIENT_COUNT FROM
          `newzhuce`.mem_patient
        WHERE
          ID = @A_C_PATIENT_ID;
        IF PATIENT_COUNT <> 0 THEN
          IF(ISNULL(@P_C_MOBILE) <> 1 && LENGTH(@P_C_MOBILE)>=1 && @P_C_MOBILE  <> 'null') THEN
            UPDATE `newzhuce`.mem_patient SET C_MOBILE=@P_C_MOBILE WHERE ID=@A_C_PATIENT_ID;
          END IF;
          UPDATE `newzhuce`.mem_patient
          SET
            C_NAME = @P_C_NAME,
            C_SEX = @P_C_SEX,
            C_BIRTHDATE = @P_C_BIRTHDATE,
            C_ID_CARD = @P_C_ID_CARD,
            C_ADDRESS = @P_C_ADDRESS
          WHERE
            ID = @A_C_PATIENT_ID;
        ELSE
          INSERT INTO `newzhuce`.mem_patient(ID,C_CREATE_DATE,C_DELETE_FLAG,C_NAME,C_SEX,C_BIRTHDATE,C_ID_CARD,C_MOBILE,C_ADDRESS,C_MEMBER_ID)
          VALUES (@P_PATIENT_ID,@P_C_CREATE_DATE,@P_C_DELETE_FLAG,@P_C_NAME,@P_C_SEX,@P_C_BIRTHDATE,@P_C_ID_CARD,@P_C_MOBILE,@P_C_ADDRESS,@A_C_MEMBER_ID);
        END IF;
      END IF;
    ELSE
      SET SQL_ERROR_FLAG=1;
      UPDATE mem_appoint_order_bak
      SET
        `SYNC` = 2,
        `SYNCTIME` = NOW()
      WHERE
        ID = @ORDER_ID;
      UPDATE mem_member_bak
      SET
        `SYNC` = 2,
        `SYNCTIME` = NOW()
      WHERE
        ID = @A_C_MEMBER_ID;
    END IF;

    IF(SQL_ERROR_FLAG <> 1) then
      IF(ISNULL(@ORDER_ID) <> 1 && LENGTH(@ORDER_ID)>=1 && @ORDER_ID <> 'null') THEN
        UPDATE mem_appoint_order_bak SET `SYNC`=1 ,`SYNCTIME`=NOW() WHERE ID=@ORDER_ID;
        UPDATE mem_member_bak
        SET
          `SYNC` = 1,
          `SYNCTIME` = NOW()
        WHERE
          ID = @A_C_MEMBER_ID;
        UPDATE mem_patient_bak
        SET
          `SYNC` = 1,
          `SYNCTIME` = NOW()
        WHERE
          ID = @A_C_PATIENT_ID;
      END IF;
      SET resultVal = '0';
      COMMIT;
    ELSE
      SET resultVal = '1';
      ROLLBACK;
      IF(ISNULL(@ORDER_ID) <> 1 && LENGTH(@ORDER_ID)>=1 && @ORDER_ID <> 'null') THEN
        UPDATE mem_appoint_order_bak SET `SYNC`=2 ,`SYNCTIME`=NOW() WHERE ID=@ORDER_ID;
        UPDATE mem_member_bak
        SET
          `SYNC` = 2,
          `SYNCTIME` = NOW()
        WHERE
          ID = @A_C_MEMBER_ID;
        UPDATE mem_patient_bak
        SET
          `SYNC` = 2,
          `SYNCTIME` = NOW()
        WHERE
          ID = @A_C_PATIENT_ID;
        commit;
      END IF;
    END IF;
  END
