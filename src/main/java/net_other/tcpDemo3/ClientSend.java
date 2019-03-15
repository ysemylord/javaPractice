package net_other.tcpDemo3;

import java.io.*;
import java.net.Socket;


public class ClientSend implements Runnable {
    private Socket mSocket;
    BufferedReader mBufferedReader;
    DataOutputStream mDataOutputStream;
    private boolean run=true;

    public ClientSend() {
        mBufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public ClientSend(Socket socket) {
        this();
        this.mSocket = socket;
        try {
            mDataOutputStream = new DataOutputStream(socket.getOutputStream());
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
