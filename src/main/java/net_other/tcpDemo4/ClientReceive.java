package net_other.tcpDemo4;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketException;

public class ClientReceive implements Runnable {
    private  DataInputStream mDataInputStream;
    private Socket mSocket;
    private boolean run=true;

    public ClientReceive(Socket socket) {
        this.mSocket = socket;
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            mDataInputStream = new DataInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            Util.closeAll(mDataInputStream);
        }

    }

    @Override
    public void run() {
        try {
            while(run){
                 String info=mDataInputStream.readUTF();
                 System.out.println("客户端收到"+info);
             }
        }catch (SocketException socket){
            socket.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            Util.closeAll(mDataInputStream);
        }
        System.out.println("客户端接收结束");

    }
}
