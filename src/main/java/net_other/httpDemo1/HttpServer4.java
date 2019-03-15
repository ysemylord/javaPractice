package net_other.httpDemo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * RequestPackage 请求报文的解析
 * ResponsePackage 构造响应报文
 */
public class HttpServer4 {


    public static void main(String[] args) throws IOException, InterruptedException {
        start();
    }

    /**
     * 开启
     *
     * @throws IOException
     */
    private static void start() throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(8888);


        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        RequestPackage requestMessage=new RequestPackage(inputStream);

        String responcontent = "<html><head><meta http-equiv=content-type content=text/html;charset=utf-8></head>" +
                "<body>你好"+requestMessage.getQueryParams().get("uname")+"</body></html>";
        ResponsePackage response=new ResponsePackage(outputStream);

        response.buildContent(responcontent)
                .pushToClient(200);




    }
}
