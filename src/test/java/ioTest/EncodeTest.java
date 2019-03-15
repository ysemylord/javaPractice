package ioTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.mindview.atunit.Test;

import java.io.IOException;
import java.nio.charset.Charset;

public class EncodeTest {
    @org.junit.Test
    public void ASCII() throws IOException {
        String string = "a";
        byte[] bytes = string.getBytes(Charset.forName("ASCII"));
        for (int i = 0; i < bytes.length; i++) {
            System.out.println("0x" + Integer.toHexString(bytes[i]));
        }
    }

    /**
     * 证明UTF8兼容ASCII
     * @throws Exception
     */
    @org.junit.Test
    public void UTF8兼容ASCII() throws Exception {
        String string2 = "a";
        byte[] bytes2 = string2.getBytes(Charset.forName("UTF-8"));
        System.out.println("a的UTF-8编码");
        for (int i = 0; i < bytes2.length; i++) {
            System.out.println("0x" + Integer.toHexString(bytes2[i]));
        }
    }

    /**
     * 将汉字转化为utf8编码
     * @throws IOException
     */
    @org.junit.Test
    public void UTF8() throws IOException {
        String string = "严";
        byte[] bytes = string.getBytes(Charset.forName("UTF-8"));
        System.out.println("严的UTF-8编码");
        for (int i = 0; i < bytes.length; i++) {
            System.out.println("0x" + Integer.toHexString(bytes[i]));
        }
    }

    /**
     * 将utf8编码转化为汉字
     * @throws Exception
     */
    @org.junit.Test
    public void UTF8ToChar() throws Exception {
        String n1 = "e4";
        String n2 = "b8";
        String n3 = "a5";
        byte num1= (byte) Integer.parseInt(n1,16);
        byte num2= (byte) Integer.parseInt(n2,16);
        byte num3= (byte) Integer.parseInt(n3,16);
       // byte[] bytes
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(new String(new byte[]{num1,num2,num3}));
    }


    @org.junit.Test
    public void tesNum(){
        float sum=0;
        for (float num = 10; num <=36.5 ; ) {

            sum+=num;
            num=num+0.1f;
            num=(Math.round(num*10)/10f);
            System.out.println(num);
        }
        System.out.println(sum);
    }


}
