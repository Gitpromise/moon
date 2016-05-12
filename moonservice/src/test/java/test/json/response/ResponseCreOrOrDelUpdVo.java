package test.json.response;

import lombok.Data;

/**
 * Created by maguoqiang on 2016/4/11.
 *
 */
@Data
public class ResponseCreOrOrDelUpdVo extends ResponseUnionVo {

    private Data data;

    @lombok.Data
    public static class Data{
        private String resourceid;

        private String request;
    }
}
