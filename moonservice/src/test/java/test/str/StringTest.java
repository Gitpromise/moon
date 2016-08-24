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

    @Test
    public void test02(){
        int a=1;
        int b=3;
        long c=a*b;
    }

    public long count(long a,long b)throws Exception{
        return a*b;
    }

    public static void main(String[] args) {
        try {
            new StringTest().count(1,3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
