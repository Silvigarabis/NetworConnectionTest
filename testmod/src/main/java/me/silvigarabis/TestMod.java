package me.silvigarabis;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.*;
import java.io.*;

public class TestMod implements ModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("testmod");

    @Override
    public void onInitialize() {
        LOGGER.info("connection test starting...sleep for 20s");
        sleep(20);
        LOGGER.info("runTest()");
        int testResult = runTest();
        LOGGER.info("test completed! code: " + testResult);
        sleep(5);
        System.exit(testResult);
    }

    private static int runTest() {
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

        sleep(1);

        InetSocketAddress socketAddress = new InetSocketAddress(host, port);
        if (socketAddress.isUnresolved()){
           LOGGER.error("无法解析指定的地址" + socketAddress.toString());
           return 2;
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
           LOGGER.error("I/O 错误", ex);
           exitCode = 255;
        }

        return exitCode;
    }
    private static void sleep(int timeSeconds){
       try {
          Thread.sleep(timeSeconds * 1000);
       } catch (InterruptedException ex){
          System.exit(130);
       }
    }
}
