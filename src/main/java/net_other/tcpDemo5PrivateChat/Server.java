package net_other.tcpDemo5PrivateChat;

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
        private String mName;

        public Channel(Socket socket) {
            this.mSocket = socket;

            InputStream inputStream = null;
            try {
                inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                dataInputStream = new DataInputStream(inputStream);
                dataOutputStream = new DataOutputStream(outputStream);
                String name = dataInputStream.readUTF();
                mName = name;
                send("欢迎来到聊天室");
                sendOthers(mName + "进入聊天室");
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

        private void sendOthers(String info) {
            if (info != null) {
                if (info.startsWith("@")) {//发送给某一个人
                    //@test:你好
                    String name = info.substring(1,info.indexOf(":"));
                    String content=info.substring(info.indexOf(":")+1);
                    for (Channel channel : channelList) {
                        if (channel != this&&channel.mName.equals(name)) {
                            channel.send(this.mName+":"+content);
                        }
                    }
                } else {
                    for (Channel channel : channelList) {
                        if (channel != this) {
                            channel.send(this.mName+":"+info);
                        }
                    }
                }
            }
        }

        @Override
        public void run() {
            while (isRunning) {
                String info = receive();
                sendOthers(info);
            }
        }
    }
}
