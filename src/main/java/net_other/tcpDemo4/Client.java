package net_other.tcpDemo4;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *

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
