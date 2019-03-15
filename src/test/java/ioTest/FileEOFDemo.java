package ioTest;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileEOFDemo {
    /**
     * 通过字节输入流读取文件内容，
     * 达到文件末尾时，FileInputStream.read()==-1。
     *
     * @throws Exception
     */
    @Test
    public void readFileByByte() throws Exception {
        File file = new File("testFile/UTF8ToChar.txt");
        System.out.println("path is " + file.getAbsolutePath());
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
            System.out.println("文件不存在，创建文件");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buffer = new byte[10];
        int length = 0;
        while ((length = fileInputStream.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, length));
        }
    }

    /**
     * 通过字节输入流读取文件内容，
     * 达到文件末尾时，InputStreamReader.read()==-1。
     *
     * @throws Exception
     */
    @Test
    public void readFileByChar() throws Exception {
        File file = new File("testFile/UTF8ToChar.txt");
        System.out.println("path is " + file.getAbsolutePath());
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
            System.out.println("文件不存在，创建文件");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        char[] buffer = new char[10];
        int length = 0;
        while ((length = inputStreamReader.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, length));
        }
    }

    /**
     * 演示错误情况
     * 达到文件末尾时，继续读取。
     * 并不会抛出EOF异常，而是read()一直返回-1。
     *
     * @throws Exception
     */
    @Test
    public void readFileByByteError() throws Exception {
        File file = new File("testFile/UTF8ToChar.txt");
        System.out.println("path is " + file.getAbsolutePath());
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
            System.out.println("文件不存在，创建文件");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buffer = new byte[10];
        int length = 0;
        while (true) {
            length = fileInputStream.read(buffer);
            System.out.println(length);
        }
    }

    @Test
    public void readByArrayInput() throws Exception {
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream("大家好".getBytes());
        while(true){
            System.out.println(byteArrayInputStream.read());
        }
    }
}
