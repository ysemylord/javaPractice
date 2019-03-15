package net_other.httpDemo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer5 {


    public static void main(String[] args) throws IOException, InterruptedException {
        start();
    }

    /**
     * 开启
     *
     * @throws IOException
     */
    private static void start() throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8888);


        boolean serverShutdown=false;
        while(!serverShutdown) {
            Socket socket = serverSocket.accept();
            executorService.execute(new Dispatcher(socket));
        }



    }
}
