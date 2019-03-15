package net_other.httpDemo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 实现多线程，一个Socket通道对一个一个客户端即一个线程
 */
public class Dispatcher implements Runnable {


    private  RequestPackage requestMessage;
    private  ResponsePackage responseMessage;
    private Socket socket;
    private int code = 200;

    public Dispatcher(Socket socket) {
        this.socket = socket;
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            requestMessage = new RequestPackage(inputStream);
            responseMessage = new ResponsePackage(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
            code=500;
        }

    }

    @Override
    public void run() {
        try {

            Servlet servlet = new Servlet();
            servlet.service(requestMessage, responseMessage);
            responseMessage.pushToClient(200);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
