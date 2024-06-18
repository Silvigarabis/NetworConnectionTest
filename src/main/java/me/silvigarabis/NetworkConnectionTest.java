package me.silvigarabis;

import java.net.*;
import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class NetworkConnectionTest {
    private static final Logger LOGGER = Logger.getLogger("NCT");
    public static void main(String[] args) {
        // ipv6.test-ipv6.com
        String host = "2001:470:1:18::115";
        int port = 80;

        String propHost = System.getProperty("testHost");
        if (propHost != null){
           host = propHost;
        }
        String propPort = System.getProperty("testPort");
        try {
           port = Integer.parseInt(propPort);
        } catch (NumberFormatException ignored){
        }

        if (args.length >= 1){
           host = args[0];
        }
        if (args.length >= 2){
           port = Integer.parseInt(args[1]);
        }

        sleep(20);

        InetSocketAddress socketAddress = new InetSocketAddress(host, port);
        if (socketAddress.isUnresolved()){
           LOGGER.severe("无法解析指定的地址" + socketAddress.toString());
           System.exit(2);
           return;
        }

        LOGGER.info("尝试连接到 " + socketAddress.toString());
        int exitCode = 0;
        try {
           Socket socket = new Socket(socketAddress.getAddress(), socketAddress.getPort());
           if (socket.isConnected()){
              LOGGER.info("连接成功");
              exitCode = 0;
           } else {
              LOGGER.info("连接失败");
              exitCode = 0;
           }
           socket.close();
        } catch (IOException ex){
           LOGGER.log(Level.SEVERE, "I/O 错误", ex);
           exitCode = 255;
        }

        sleep(20);
        System.exit(exitCode);
    }
    private static void sleep(int timeSeconds){
       try {
          Thread.sleep(timeSeconds * 1000);
       } catch (InterruptedException ex){
          System.exit(130);
       }
    }
}
