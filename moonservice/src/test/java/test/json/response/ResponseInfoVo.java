package test.json.response;

import lombok.Data;

/**
 * Created by maguoqiang on 2016/4/11.
 *
 */
@Data
public class ResponseInfoVo<T> extends ResponseUnionVo {

    private T data;

}
