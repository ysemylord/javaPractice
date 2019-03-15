package net_other.udpDemo;

import java.io.IOException;
import java.net.*;

/**
 * 1.创建udp客户端
 * 2.将数据封装成数据包
 * 3.发送数据
 * 4.关闭
 */
public class Client {
    public static void main(String[] args) throws UnknownHostException {
        DatagramSocket datagramSocket= null;
        try {
            datagramSocket = new DatagramSocket(4300);

            byte[] datas = "helloe 你好".getBytes();
            InetAddress inetAddress = InetAddress.getByName("127.0.01");
            DatagramPacket datagramPacket = new DatagramPacket(datas, datas.length, inetAddress, 8600);
            datagramSocket.send(datagramPacket);
        }
        catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            datagramSocket.close();

        }
    }
}
