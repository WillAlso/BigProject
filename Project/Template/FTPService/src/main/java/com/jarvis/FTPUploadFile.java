package com.jarvis;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

public class FTPUploadFile {
    private FTPClient client = null;

    public FTPUploadFile() {
        client = FTPClientFactory.getInstance();
        client.setControlEncoding("utf-8");
    }

    public boolean loginIn() {
        try {
            client.connect(ServerConstains.DEFAULT_FTP_ADDRESS, ServerConstains.DEFAULT_FTP_PORT);
            client.login(ServerConstains.DEFAULT_FTP_USER, ServerConstains.DEFAULT_FTP_PASSWORD);
            int replyCode = client.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Login in failed!");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean loginIn(String username, String password) {
        try {
            client.connect(ServerConstains.DEFAULT_FTP_ADDRESS, ServerConstains.DEFAULT_FTP_PORT);
            client.login(username, password);
            int replyCode = client.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Login in failed!");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean uploadFile(String pathname, String filename, String originfilename) {
        boolean flag = false;
        try (InputStream inputStream = new FileInputStream(new File(originfilename))) {
            if (!loginIn()) {
                flag= false;
            }
            client.setFileType(client.BINARY_FILE_TYPE);
            client.makeDirectory(pathname);
            client.changeWorkingDirectory(pathname);
            client.storeFile(filename, inputStream);
            client.logout();
            flag= true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            flag= false;
        } catch (IOException e) {
            e.printStackTrace();
            flag= false;
        } finally {
            disconnectClient();
        }
        return flag;
    }

    public boolean existFile(String path) throws IOException {
        boolean flag = false;
        FTPFile[] ftpFiles = client.listFiles(path);
        if (ftpFiles.length > 0) {
            flag = true;
        }
        return flag;
    }

    public boolean deleteFile(String pathname, String filename) {
        boolean flag = false;
        try {
            loginIn();
            client.changeWorkingDirectory(pathname);
            flag = client.deleteFile(filename);
            client.logout();
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
        } finally {
            disconnectClient();
        }
        return flag;
    }

    public void disconnectClient() {
        if (client.isConnected()) {
            try {
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void destoryClient() {
        if (client != null) {
            client = null;
        }
    }

    public static void main(String[] args) {
    }
}
