package net_other.udpDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 1.创建udp服务端
 * 2.将数据解析为udp数据包
 * 3.获取udp数据部分
 * 4.关闭
 */
public class Server {
    public static void main(String[] args) {
        DatagramSocket datagramSocket=null;
        try {
            datagramSocket=new DatagramSocket(8600);
            byte[] buf = new byte[1024];
            DatagramPacket datagramPacket=new DatagramPacket(buf,buf.length);
            datagramSocket.receive(datagramPacket);
            byte[] datas= datagramPacket.getData();
            int length = datagramPacket.getLength();
            //注意这里的length不能为datas.length.因为datas.length为整个buf的大小，但是真正的数据可能没有这么多，所以需要使用
            //datagramPacket.getLength()获取真正的数据大小
            System.out.println(new String(datas,0, length));
            datagramSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            datagramSocket.close();
        }
    }
}
