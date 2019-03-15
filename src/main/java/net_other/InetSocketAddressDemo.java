package net_other;

import javax.net.SocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * InetSocketAddress
 */
public class InetSocketAddressDemo {
    public static void main(String[] args) {
        try {
            Socket socket = SocketFactory.getDefault().createSocket();
            String hostName = "wxtest.kuaijiankang.com";
            InetAddress inetAddress = InetAddress.getByName(hostName);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress, 80);
            socket.connect(inetSocketAddress, 6000);

            OutputStream outputStream1= socket.getOutputStream();
            outputStream1.write("12".getBytes());

            OutputStream outputStream2= socket.getOutputStream();
            outputStream2.write("12".getBytes());

            InetSocketAddress inetSocketAddress1= InetSocketAddress.createUnresolved("www.baidu.com",80);



        }catch (IOException e){
            System.out.println("连接出错"+e.getLocalizedMessage());
        }
    }

    /**
     * okhttp通过以下的方式创建Socket
     * @throws IOException
     */
    public static void method() throws IOException {
        Socket socket = SocketFactory.getDefault().createSocket();
        String hostName = "localhost";
        InetAddress inetAddress=InetAddress.getByName(hostName);
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
