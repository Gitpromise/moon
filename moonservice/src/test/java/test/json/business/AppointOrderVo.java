package test.json.business;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by maguoqiang on 2016/4/11.
 * AppointOrderVo
 */
@Data
public class AppointOrderVo implements Serializable {

    private PatientVo patient;

    @JSONField(name = "doctor_name")
    private String doctorName;
    @JSONField(name = "appoint_state")
    private int appointState;//预约单状态（8-未确认；1-未就诊；5-已就诊；7-已取消）【必填】【加签】
    @JSONField(name = "appoint_time")
    private Date appointTime;//预约时间,yyyy-MM-dd HH:mm:ss【必填】【加签】
    @JSONField(name = "appoint_type")
    private int appointType;//预约单类型（0-无卡；1-有卡；2-保险）【必填】
    @JSONField(name = "treatment_projects")
    private String treatmentProjects;//治疗项目(多项用‘；’分割)
    private String remark;

    private String resourceid;
}
