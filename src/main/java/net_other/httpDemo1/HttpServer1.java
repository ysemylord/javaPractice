package net_other.httpDemo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer1 {
    public static void main(String[] args) throws IOException {
        start();
    }

    /**
     * 开启
     * @throws IOException
     */
    private static void start() throws IOException {
        ServerSocket serverSocket=new ServerSocket(8888);
        Socket socket= serverSocket.accept();
        InputStream inputStream= socket.getInputStream();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        String info=null;
        /**
         *
         * 客户端必须调用OutputStream.close（）或者socket.shutdownOutput(),不然这里的输入流无法收到流到达末尾的标志
         *
         */
        while((info=bufferedReader.readLine())!=null){
            System.out.println(info);
        }
        socket.getOutputStream().write("结束".getBytes());
        System.out.println("响应结束结束");
    }
}
