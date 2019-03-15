package io_m;

import java.io.File;
import java.io.IOException;

public class filePahtTest {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        System.out.println(file.getAbsolutePath());
        File file2 = new File("/test2.txt");
        System.out.println(file2.getAbsolutePath());

    }
}
