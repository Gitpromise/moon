package test.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by maguoqiang on 2016/5/6.
 * NIO测试
 */
public class NioDemo {

    @Test
    public void testNioOne()throws IOException{
        FileInputStream fin=new FileInputStream("E:\\data\\env\\env.properties");//源文件
        FileOutputStream fos=new FileOutputStream("E:\\data\\test.properties");
        FileChannel fc=fin.getChannel();
        FileChannel fi=fos.getChannel();
        //要从channel中读取数据，必须使用buffer
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        while (true){
            byteBuffer.clear();
            int len=fc.read(byteBuffer);
            if (len==-1){
                break;
            }
            byteBuffer.flip();
            fi.write(byteBuffer);
        }
        fc.close();
        fi.close();
    }
}
