package test.json.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import test.json.business.AppointOrderVo;
import test.json.business.PatientVo;

import java.util.Date;

/**
 * Created by maguoqiang on 2016/4/11.
 *
 */
@Data
public class RequestCreateVo<T> extends RequestBaseVo {
    private T data;


    public static void main(String[] args){
        PatientVo patientVo =new PatientVo();
        patientVo.setBirth(new Date());
        patientVo.setBlh("123");
        patientVo.setCardid("12341234");
        patientVo.setCardtype(1);
        patientVo.setPhone("18221811952");
        patientVo.setRemark("测试测试");
        patientVo.setName("测试");

        AppointOrderVo appointOrderVo =new AppointOrderVo();
        appointOrderVo.setPatient(patientVo);
        appointOrderVo.setRemark("预约单测试");
        appointOrderVo.setAppointState(2);
        appointOrderVo.setAppointTime(new Date());
        appointOrderVo.setAppointType(3);
        appointOrderVo.setTreatmentProjects("检查;查件");
        appointOrderVo.setDoctorName("张三");

        RequestCreateVo requestCreateVo =new RequestCreateVo();
        requestCreateVo.setData(appointOrderVo);
        requestCreateVo.setSign("234123412");
        requestCreateVo.setTimestamp(12343124);
        RequestCreateVo<AppointOrderVo> ddd=new RequestCreateVo<>();
        System.out.println(JSON.toJSON(requestCreateVo));
        ddd=JSONObject.parseObject(JSON.toJSONString(requestCreateVo), ddd.getClass());
        System.out.println(ddd);
        System.out.println(ddd.getData());
    }
}
