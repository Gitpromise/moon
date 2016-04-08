package test.bat;

/**
 * Created by maguoqiang on 2016/3/23.
 */
public class StartOrKillBat {

    public static void main(String[] args)throws Exception{
        //启动bat
        String command = "C:\\Users\\maguoqiang\\Desktop\\新建文本文档.bat";
        //Process p = Runtime.getRuntime().exec(command);

        //Runtime.getRuntime().exec("taskkill /f /im SQLyog.exe");
        Runtime.getRuntime().exec("cmd.exe /c start E:\\kkk\\bat\\startcopy.bat");
        /*String path="E:\\kkk\\";
        String cmd = "copy /y "+"\""+path+"forupdate\\*.properties"+"\" "+"\""+path+"conf\\"+"\"";
        System.out.println(cmd);
        Runtime.getRuntime().exec(cmd);
        */
    }
}
