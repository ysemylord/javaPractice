package net_other.tcpDemo5PrivateChat;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *思路
 * 1.客户端与服务端刚开始建立连接时 将自己的名字发送给服务端
 * 2.客户端与服务端刚开始建立连接时 记录下客户端发送来的名字，标志客户端
 *
 */
public class Client {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Socket socket = new Socket("127.0.0.1", 5555);


        executorService.execute(new ClientSend(socket));
        executorService.execute(new ClientReceive(socket));





    }
}
