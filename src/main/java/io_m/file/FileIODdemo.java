package io_m.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIODdemo {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 1000; i++) {
            CacheData.getInstanece().write(i+"");
        }


    }


}
