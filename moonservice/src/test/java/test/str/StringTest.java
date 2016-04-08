package test.str;

import org.junit.Test;

/**
 * Created by maguoqiang on 2016/3/29.
 */
public class StringTest {
    @Test
    public void test01(){
        String s="ftp/部署/update/lib/com/bsoft/update/FTPClientUtil.class";
        int i=s.indexOf("/");
        s=s.substring(i+1);
        System.out.println(i);
        System.out.println(s);
    }
}
