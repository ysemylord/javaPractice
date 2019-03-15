package io_m.eofDemo.tcpDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
            OutputStream outputStream=socket.getOutputStream();
            int length;
            byte[] datas=new byte[100];
            while((length=inputStream.read(datas))!=-1) {//当客户端的输入流关闭时，此时收到-1
                System.out.println("收到的数据为：" + new String(datas,0,length));
                socket.close();
                //outputStream.write("收到数据啦".getBytes());
            }
            System.out.println("length 为"+length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
