package net_other.httpDemo1;

import java.io.*;
import java.net.Socket;

/**

 */
public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",8888);
        OutputStream outputStream=socket.getOutputStream();
        InputStream inputStream= socket.getInputStream();
        String msg="1222\n"+"\n"+"3233";
        outputStream.write(msg.getBytes());
        outputStream.flush();
        socket.shutdownOutput();
        byte[] bytes = new byte[1024];
        int length=inputStream.read(bytes);
        System.out.println(new String(bytes,0,length));
        outputStream.close();
    }
}
