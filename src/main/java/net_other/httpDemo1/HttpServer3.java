package net_other.httpDemo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class HttpServer3 {
    public static final String CRLF = "\n";
    public static final String SPACE = " ";

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
        String charset="utf-8";
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,charset));
        byte[] datas = new byte[1024];
        StringBuilder responseStringBuilder = new StringBuilder();


        int length = inputStream.read(datas);
        String request = new String(datas, 0, length);
        System.out.println("http请求报文为:\n" + request);

        String responseContent1 = "<html><head><meta http-equiv=content-type content=text/html;charset=utf-8></head>" +
                "<body>你好</body></html>";
        String responseContent2 = "你好";
        //responseContent1 text/html
        //responseContent2 application/json （如果使用text/plain 会乱码）
        //使用浏览器请求，浏览器显示乱码，使用自己的Client请求，请求未乱码
        //这有涉及到编码的知识
        String responcontent = responseContent2;
        responseStringBuilder.append("http/1.1").append(SPACE).append("200").append(SPACE).append("OK").append(CRLF)
                .append("Server:xyb/1.00").append(CRLF)
                .append("Date:" + new Date()).append(CRLF)
                //如果为text/plain,浏览器会按照纯文本解析返回的内容，
                //如果为text/html,浏览器会按照html解析返回的内容
                .append("Content-type:" + "application/json"+","+"charset="+charset).append(CRLF)
                .append("Content-length:"+responcontent.getBytes().length).append(CRLF)
                .append(CRLF)
                .append(responcontent);
        String responseString = responseStringBuilder.toString();
        bufferedWriter.write(responseString, 0, responseString.length());

        bufferedWriter.flush();

        bufferedWriter.close();

    }
}
