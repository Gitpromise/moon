package test.json.business;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by maguoqiang on 2016/4/11.
 * patient
 */
@Data
public class PatientVo implements Serializable {
    private String blh;

    private String name;

    private int sex;//0-女  1-男

    private Date birth;//出生日期 yyyy-MM-dd

    private int cardtype;//证件类型

    private String cardid;

    private String phone;

    private String remark;

    private String resourceid;
}
