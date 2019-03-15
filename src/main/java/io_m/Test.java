package io_m;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        String string="123a";
        System.out.println(Arrays.toString(string.getBytes()));
        InputStream inputStream=new  ByteArrayInputStream(string.getBytes());
        int b;
        while((b=inputStream.read())!=-1){
            System.out.print(b+",");
        }
    }
}
