package test.json.response;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by maguoqiang on 2016/4/11.
 */
@Data
public class ResponseBaseVo implements Serializable{

    private Integer errno;

    private String errormsg;
}
