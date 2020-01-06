package com.jarvis;

import org.apache.commons.net.ftp.FTPClient;

public class FTPClientFactory {

    public static volatile FTPClient client;

    public static FTPClient getInstance() {
        if (client == null) {
            synchronized (FTPClient.class) {
                if (client == null) {
                    client = new FTPClient();
                }
            }
        }
        return client;
    }
}
