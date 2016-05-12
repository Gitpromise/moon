package test.json.response;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by maguoqiang on 2016/4/11.
 */
@Data
public class ResponseGetTokenVo extends ResponseBaseVo {

    private Data data;

    @lombok.Data
    public static class Data implements Serializable{

        private String token;
        private String request;
    }

}
