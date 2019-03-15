package net_other.tcpDemoProxy.tcpDemo2;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;

/**
 *
 * SOCKS代理
 */
public class Client {
    public static void main(String[] args) throws IOException {
        InetSocketAddress proxyInetSocketAddress=new InetSocketAddress("localhost",8888);
        Proxy proxy=new Proxy(Proxy.Type.SOCKS,proxyInetSocketAddress);
        Socket socket=new Socket(proxy);

        //这里是验证代理服务器，所以目标服务器随便写了一个
        InetSocketAddress originInetSocketAddress=new InetSocketAddress("localhost",888);

        //如果proxyInetSocketAddress指定的服务器（就是这里的Server）收到连接请求，说明代理设置成功了。
        socket.connect(originInetSocketAddress);

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream=socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        DataOutputStream dataOutputStream=new DataOutputStream(outputStream);
        DataInputStream dataInputStream=new DataInputStream(inputStream);
        String info=null;
        while(!(info=bufferedReader.readLine()).equals("finish")) {

            dataOutputStream.writeUTF(info);

            String receive=dataInputStream.readUTF();
            System.out.println(receive);

        }
        dataOutputStream.flush();
        dataOutputStream.close();
        socket.close();
    }
}
