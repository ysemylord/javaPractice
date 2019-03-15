package net_other.tcpDemo;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.创建服务端套接字
 * 2.获取Socket,以及输入流
 * 3.获取数据
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            int data;
            while((data=inputStream.read())!=-1) {//当客户端的输入流关闭时，此时收到-1
                System.out.println("收到的数据为：" + data);
            }
            System.out.println("data 为"+data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
