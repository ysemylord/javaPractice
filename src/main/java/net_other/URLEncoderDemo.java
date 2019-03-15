package net_other;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

public class URLEncoderDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String text="你好";

        byte[] utf8Bytes=text.getBytes("utf-8");

        System.out.println("\""+text+"\""+" 使用utf-8转化为字节数组后的16进制形式");
        for (int i = 0; i < utf8Bytes.length; i++) {
            System.out.println(Integer.toHexString(utf8Bytes[i]));
        }

        System.out.println();
        System.out.println(" 使用utf-8对"+"\""+text+"\""+"进行URLEncoder进行编码");
        String encodeStr = URLEncoder.encode(text, "utf-8");
        System.out.println(encodeStr);

        System.out.println();
        System.out.println("使用utf-8对"+"\""+encodeStr+"\"" +"进行URLDecoder进行解码");
        System.out.println(URLDecoder.decode(encodeStr,"utf-8"));




    }
}
