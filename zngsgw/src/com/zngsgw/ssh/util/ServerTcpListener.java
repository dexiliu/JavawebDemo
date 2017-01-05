package com.zngsgw.ssh.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTcpListener implements Runnable {

    @Override
    public void run() {

    }

    public void server() {
    	try {
            final ServerSocket server = new ServerSocket(33456);
            Thread th = new Thread(new Runnable() {

                @Override
                public void run() {
                    while (true) {
                        try {
                           System.out.println("开始监听。。。");
                           //一直在监听客户端的连接请求
                           Socket socket = server.accept();
                           System.out.println("有链接");
                           //接收客户端传过来的文件
                           receiveFile(socket);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }

            });
            th.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void receiveFile(Socket socket) throws IOException {
        DataInputStream din = null;
        try {
        	//获取socket的输入流，准备接收输入流里的数据
            din = new DataInputStream(socket.getInputStream());
            String flag=din.readUTF();
            System.out.println(flag);
            System.out.println("完成接收");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (din != null)
                din.close();
            if (socket != null)
                socket.close();
        }
    }


}
