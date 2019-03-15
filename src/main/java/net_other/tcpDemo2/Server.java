package net_other.tcpDemo2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 *
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8888);
        Socket socket=serverSocket.accept();
        InputStream inputStream=socket.getInputStream();
        OutputStream outputStream=socket.getOutputStream();
        System.out.println("服务端收到请求");
        DataInputStream dataInputStream=new DataInputStream(inputStream);
        DataOutputStream dataOutputStream=new DataOutputStream(outputStream);


        while(true) {
            System.out.println("服务收到的数据为：" + dataInputStream.readUTF());
            dataOutputStream.writeUTF("我收到你的数据了");
        }
    }
}
