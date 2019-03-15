package net_other.httpDemo2;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 分发器
 * 将不同的请求交给不同的Servlet处理
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

            String url = requestMessage.getUrl();
            Servlet servlet = WebApp.getServlet(url);
            if(servlet==null){
               code=404;
            }else {
                servlet.service(requestMessage, responseMessage);
            }
            responseMessage.pushToClient(200);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
