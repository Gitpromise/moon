package test.json.response;

import lombok.Data;

/**
 * Created by maguoqiang on 2016/4/11.
 */
@Data
public class ResponseUnionVo extends ResponseBaseVo {

    private String sign;

    private long timestamp;
}
