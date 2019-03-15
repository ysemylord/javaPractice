package net_other.tcpDemo4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 *
 */
public class Server {
    private List<Channel> channelList = new ArrayList<Channel>();

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server();
        server.start();
    }

    private void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(5555);
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket socket = serverSocket.accept();
            Channel channel = new Channel(socket);
            channelList.add(channel);
            executorService.execute(channel);
        }
    }

    class Channel implements Runnable {
        private Socket mSocket;
        private DataInputStream dataInputStream;
        private DataOutputStream dataOutputStream;
        private boolean isRunning = true;

        public Channel(Socket socket) {
            this.mSocket = socket;

            InputStream inputStream = null;
            try {
                inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                dataInputStream = new DataInputStream(inputStream);
                dataOutputStream = new DataOutputStream(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
                Util.closeAll(dataInputStream, dataOutputStream);
                isRunning = false;
                channelList.remove(this);
            }
        }

        /**
         * 写入数据
         */
        private void send(String msg) {
            try {
                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
                Util.closeAll(dataInputStream, dataOutputStream);
                isRunning = false;
                channelList.remove(this);
            }
        }

        /**
         * 读取数据
         */

        private String receive() {
            try {
                String info = dataInputStream.readUTF();
                return info;
            } catch (IOException e) {
                e.printStackTrace();
                Util.closeAll(dataInputStream, dataOutputStream);
                isRunning = false;
                channelList.remove(this);
            }
            return null;
        }

        /**
         * 将数据写入其他管道
         */

        private void sendOthers() {
            String info = receive();
            if (info != null) {
                for (Channel channel : channelList) {
                    if (channel != this) {
                        channel.send(info);
                    }
                }
            }
        }

        @Override
        public void run() {
            while (isRunning) {
                sendOthers();
            }
        }
    }
}
