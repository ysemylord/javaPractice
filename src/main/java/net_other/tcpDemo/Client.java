package net_other.tcpDemo;

import javax.net.SocketFactory;
import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 1.创建客户端套接字
 * 2.获取输出流
 * 3.写入数据
 * <p>
 * 思考：
 * 1.Socket的API设计是有道理的
 * tcp是面向连接的
 * 所以在创建Socket的时候要指定服务器的ip的地址和端口，用于连接
 * 于此同时，创建SeverSocket也要指定自己的端口用户让Socket连接
 * 相比之下，客户端的端口就显得不那么重要，所以由系统随机分配
 * <p>
 * 2.Socket要理解为客户端与服务端的通道
 */
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        method2();
    }

    private static void method1() throws IOException {
        Socket socket = new Socket("localhost", 8888);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String inputMsg = bufferedReader.readLine();
            if(inputMsg.equals("end")){
                break;
            }
            outputStream.write(inputMsg.getBytes());
            outputStream.flush();
            System.out.println("write");
        }
        outputStream.close();
    }

    /**
     * okhttp使用如下的方法建立连接
     * @throws IOException
     */
    private static void method2() throws IOException {
        Socket socket = SocketFactory.getDefault().createSocket();
        InetAddress inetAddress=InetAddress.getByName("localhost");
        InetSocketAddress inetSocketAddress=new InetSocketAddress(inetAddress, 8888);
        socket.connect(inetSocketAddress,6000);

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String inputMsg = bufferedReader.readLine();
            if(inputMsg.equals("end")){
                break;
            }
            outputStream.write(inputMsg.getBytes());
            outputStream.flush();
            System.out.println("write");
        }
        outputStream.close();
    }
}
