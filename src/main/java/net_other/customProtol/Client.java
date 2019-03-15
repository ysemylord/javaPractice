package net_other.customProtol;

import java.io.*;
import java.net.Socket;

/**
 *
 * 1.从控制台读取数据
 * 2.向服务器写入数据
 * 3.从服务器读取数据
 *
 * 实现的功能为客户端可以向服务端发送数据，也可以从服务端读取数据
 * 但是有一个缺陷：
 * 客户端必须向服务端发送了数据后才能从服务端读取数据
 * 为了实现能同时发送数据和读取数据，
 * 发送数据和读取数据应该在两个线程里
 *
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String info = null;


        dataOutputStream.flush();
        dataOutputStream.close();
        socket.close();
    }

}
