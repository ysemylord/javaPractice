package net_other.tcpDemo5PrivateChat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ClientSend implements Runnable {
    private Socket mSocket;
    BufferedReader mBufferedReader;
    DataOutputStream mDataOutputStream;
    private boolean run=true;
    private String mName;

    public ClientSend() {
        mBufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public ClientSend(Socket socket) {
        this();
        this.mSocket = socket;
        try {
            mDataOutputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("请输入您的名字");
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
            String name=bufferedReader.readLine();
            mName=name;
            mDataOutputStream.writeUTF(name);
            mDataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            Util.closeAll(mBufferedReader, mDataOutputStream);
        }
    }

    @Override
    public void run() {
        String info = null;
        while(run) {
            try {
                while (!(info = mBufferedReader.readLine()).equals("finish")) {
                    mDataOutputStream.writeUTF(info);
                    mDataOutputStream.flush();
                }
                mSocket.close();
                run=false;
            } catch (IOException e) {
                e.printStackTrace();
                Util.closeAll(mBufferedReader, mDataOutputStream);
            }finally {
            }
        }
        Util.closeAll(mBufferedReader, mDataOutputStream);
        System.out.println("客户端发送结束");

    }
}
