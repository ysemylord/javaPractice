package io_m;

import net.mindview.util.CountingGenerator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

public class GsonEncodeTest {
    public static void main(String[] args) throws IOException {
        String string="1a";
        byte[] bytes=string.getBytes(Charset.forName("ASCII"));
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

    }
}
