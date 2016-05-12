package test.json.request;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by maguoqiang on 2016/4/11.
 *
 */
@Data
public class RequestBaseVo implements Serializable {
    private String sign;

    private long timestamp;
}
