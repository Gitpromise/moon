package com.ly.sdk.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class LeyaFtpClientUtils {

    private static Log log = LogFactory.getLog(LeyaFtpClientUtils.class);
    private static Properties prop = new Properties();

    private static ThreadLocal<FTPClient> ftpClientThreadLocal = new ThreadLocal<FTPClient>();

    private static String ftpServer;

    private static String ftpPort;

    private static String ftpUsername;

    private static String ftpPassword;

    private static String imageServer;

    private static String imageBaseDir;

    static {
        InputStream in = null;

        try {
            in = new FileInputStream("/data/env/ftp_config.properties");
            if (in != null) {
                prop.load(in);
                getConstant();
            }
        } catch (Exception var9) {
            throw new RuntimeException("init appConfig properties error :" + var9.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException var8) {
                in = null;
            }

        }

    }

    public static FTPClient getFTPClient() {
        FTPClient client = ftpClientThreadLocal.get();
        if (client != null && client.isConnected()) {
            return client;
        }
        ftpClientThreadLocal.remove();
        FTPClient ftpClient = new FTPClient(); //创建ftpClient
        ftpClient.setControlEncoding("UTF-8"); //设置字符编码
        Boolean isConnect = connectFtp(ftpClient);

        ftpClient.enterLocalPassiveMode();
        try {
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.setSoTimeout(1000 * 30);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 得到返回答复码
        int reply = ftpClient.getReplyCode();

        if (!FTPReply.isPositiveCompletion(reply)) {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            ftpClientThreadLocal.set(ftpClient);
        }
        return ftpClient;

    }

    public static Boolean connectFtp(FTPClient ftpClient) {
        Boolean isConnect = Boolean.FALSE;
        try {
            ftpClient.connect(ftpServer, Integer.parseInt(ftpPort));
            // 连接后检测返回码来校验连接是否成功
            int reply = ftpClient.getReplyCode();
            if (FTPReply.isPositiveCompletion(reply)) {
                //登陆到ftp服务器
                if (ftpClient.login(ftpUsername, ftpPassword)) {
                    ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                    return true;
                }
            } else {
                ftpClient.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return isConnect;

    }

    private static void ftpCreateDirectoryTree(FTPClient client, String dirTree) throws IOException {

        boolean dirExists = true;

        // tokenize the string and attempt to change into each directory level.
        // If you cannot, then start creating.
        String[] directories = dirTree.split("/");
        for (String dir : directories) {
            if (!dir.isEmpty()) {
                if (dirExists) {
                    dirExists = client.changeWorkingDirectory(dir);
                }
                if (!dirExists) {
                    if (!client.makeDirectory(dir)) {
                        throw new IOException("Unable to create remote directory '" + dir + "'.  error='"
                                + client.getReplyString() + "'");
                    }
                    if (!client.changeWorkingDirectory(dir)) {
                        throw new IOException("Unable to change into newly created remote directory '" + dir
                                + "'.  error='" + client.getReplyString() + "'");
                    }
                }
            }
        }
    }

    /**
     * @param path ex:/upload/2023
     * @param filename xxx.jpg
     * @param input 输入流
     * @return
     */
    public static boolean uploadFile(String path, String filename, InputStream input) {
        boolean success = false;
        FTPClient ftpClient = null;
        try {
            ftpClient = getFTPClient();
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {

                return success;
            }
            //使用二进制上传
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpCreateDirectoryTree(ftpClient, path);
            success = ftpClient.storeFile(filename, input);
            input.close();
            ftpClient.logout();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != ftpClient && ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    /**
     * @param remotePath 远程文件路径ַ ex：/upload/2012/xxxx.jpg
     * @param out 文件输出流
     * @return
     */
    public static boolean downFile(String remotePath, OutputStream out) {
        Boolean flag = Boolean.FALSE;
        //得到文件名 ex: xxxx.jpg
        String fileName = getLastName(remotePath);
        //得到文件存储路径 ex：/upload/2012
        String remoteStorePath = getFilePath(remotePath);
        FTPClient ftpClient = null;
        try {
            ftpClient = getFTPClient();
            // 得到返回答复码
            int reply = ftpClient.getReplyCode();

            if (!FTPReply.isPositiveCompletion(reply)) {
                try {
                    ftpClient.disconnect();
                    return flag;
                } catch (IOException e) {
                    e.printStackTrace();
                    return flag;
                }

            }

            ftpClient.changeWorkingDirectory(remoteStorePath);

            // ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//

            FTPFile[] fs = ftpClient.listFiles();
            for (FTPFile file : fs) {
                if (fileName.equalsIgnoreCase(file.getName())) {
                    flag = ftpClient.retrieveFile(fileName, out);

                    break;
                }
            }
            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (null != ftpClient && ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                }
            }
        }

        return flag;
    }
    /**
     * 取出文件名
     * @param fileName
     * @return
     */
    private static String getLastName(String fileName) {
            int pos = fileName.lastIndexOf("\\");
            if (pos > -1) {
                fileName = fileName.substring(pos + 1);
            }
            pos = fileName.lastIndexOf("/");
            if (pos > -1) {
                fileName = fileName.substring(pos + 1);
            }
            return fileName;
    }

    /**
     * 
     * <p>Description:得到文件路径 </p>
     * @param path
     * @return
     */
    private static String getFilePath(String path) {
        if (StringUtils.isNotBlank(path)) {
            int index = path.lastIndexOf("/");
            return path.substring(0, index);
        }
        return "";
    }

    /**
     * @param ftpClient
     * @param allowFileTypes
     * @return
     */
    public static void listFiles(FTPClient ftpClient, List<String> filePath, Set<String> allowFileTypes,
            String changeToPath, Boolean isFirst) {
        try {
            if (!isFirst) {
                Boolean flag = ftpClient.changeWorkingDirectory(changeToPath);
                if (!flag) {
                    return;
                }
            }

            FTPFile[] files = ftpClient.listFiles();
            if (null != files && files.length > 0) {
                for (FTPFile file : files) {
                    String name = file.getName();
                    if (file.isDirectory()) {
                        listFiles(ftpClient, filePath, allowFileTypes, changeToPath + "/" + name, Boolean.FALSE);
                    } else if (file.isFile()) {
                        String extAttr = getExt(name);
                        if (allowFileTypes.contains(extAttr)) {
                            filePath.add(getAfterUploadUrl(changeToPath + "/", name));
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void disConnectFtp(FTPClient ftpClient) {
        try {
            ftpClient.disconnect();
        } catch (IOException e) {
            log.info("关闭连接失败！", e);
            e.printStackTrace();

        }
    }

    /**
     * @param filePath 文件的完整存储路径 ex:/upload/photo_image/xxxx.jpg
     * @return
     */
    public static Boolean delFtpFile(String filePath) {
        Boolean success = Boolean.FALSE;
        FTPClient ftpClient = getFTPClient();
        int reply = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            return success;
        }
        try {
            success = ftpClient.deleteFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return success;
    }

    private static void getConstant() {
        ftpServer = get("ftp.server");
        ftpPort = get("ftp.port");
        ftpUsername = CipherUtility.AES.decrypt(get("ftp.username"));
        ftpPassword = CipherUtility.AES.decrypt(get("ftp.password"));
        imageServer = get("image.server");
        imageBaseDir = get("image.baseDir");
    }

    /**
     * @param filePath 路径 ex:/upload/image/
     * @param fileName 文件名称 ex:img_20150608.jpg
     * @return 得到返回到页面的URL
     *         http://s.f.leya920.com/jck51/upload/image/img_20150608.jpg
     */
    private static String getAfterUploadUrl(String filePath, String fileName) {
        String url = getFtpBasePath() + filePath + fileName;
        return url;
    }

    public static String get(String key) {
        return (String) prop.get(key);
    }

    /**
     * 获得ftp上传路径 ex: http://s.f.leyatest.com/jck51;
     *
     * @return
     */
    public static String getFtpBasePath() {
        return "http://" + imageServer + imageBaseDir;
    }

    /**
     * 获得给定文件的后缀名
     * 
     * @param tempName
     * @return
     */
    private static String getExt(String tempName) {
        if (StringUtils.isNotBlank(tempName)) {
            return tempName.substring(tempName.lastIndexOf(".") + 1, tempName.length());
        }
        return null;
    }
}
