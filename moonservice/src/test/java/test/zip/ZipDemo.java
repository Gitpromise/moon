package test.zip;

import java.nio.charset.Charset;
import java.util.zip.ZipFile;

/**
 * Created by maguoqiang on 2016/4/13.
 *
 */
public class ZipDemo {

    public static void main(String[] args)throws Exception{

        ZipFile zf = new ZipFile("",Charset.forName("UTF-8"));//支持中文
    }
}
