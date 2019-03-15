package io_m;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class CharsetDemo {
    public static void main(String[] args) throws IOException {


        // 获取JVM默认字符集
        System.out.println("defaultCharset:" + Charset.defaultCharset());


        inputAndOutFile();

    }


    /**
     * 以正确的编码方式从字节数组中读取
     * @param str
     * @throws IOException
     */
    private static void sorceIsByteArray(String str) throws IOException {
        byte[] srcBytes = str.getBytes("utf-8");
        System.out.println("字节数组是由字符串用utf-8字符集编码得到的");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(srcBytes);
        byte[] datas1 = new byte[1024];
        int length1 = byteArrayInputStream.read(datas1);
        System.out.println(new String(datas1, 0, length1));
        System.out.println("使用默认的字符集解码 " + new String(datas1, 0, length1));
        System.out.println("使用gbk解码 " + new String(datas1, 0, length1, "gbk"));
        System.out.println("使用utf-8解码 " + new String(datas1, 0, length1, "utf-8"));
    }

    /**
     * 以正确的编码方式从文件中读取
     * @throws IOException
     */
    private static void sourceIsFile() throws IOException {
        byte[] datas1 = new byte[1024];
        String gbkCharsetFile = "/Users/xuyabo/Documents/java/thinkingInJavaPractice/src/main/java/io_m/gbkCharset";
        FileInputStream fileInputStream = new FileInputStream(gbkCharsetFile);
        int length1 = fileInputStream.read(datas1);

        byte[] datas2 = new byte[1024];
        String utf8CharsetFile = "/Users/xuyabo/Documents/java/thinkingInJavaPractice/src/main/java/io_m/utf-8";
        FileInputStream fileInputStream2 = new FileInputStream(utf8CharsetFile);
        int length2 = fileInputStream2.read(datas2);

        //使用对应的字符集解码才不会乱码（如果没有指明使用的字符集则使用平台默认的字符集）
        System.out.println("使用默认的字符集解码 " + new String(datas1, 0, length1));
        System.out.println("使用gbk解码 " + new String(datas1, 0, length1, "gbk"));
        System.out.println("使用utf-8解码 " + new String(datas2, 0, length2, "utf-8"));
    }

    /**
     * 字节流读写
     * @throws IOException
     */
    private static void inputAndOutFile() throws IOException {
        String gbkCharsetFile = "/Users/xuyabo/Documents/java/thinkingInJavaPractice/src/main/java/io_m/gbkCharset";

        FileOutputStream fileOutputStream = new FileOutputStream(gbkCharsetFile);
        String content="中文";
        byte[] writeDatas = content.getBytes("GBK");
        fileOutputStream.write(writeDatas);
        fileOutputStream.flush();
        fileOutputStream.close();
        System.out.println("向文件中以GBK编码写入字符串:"+content);

        byte[] datas1 = new byte[1024];
        FileInputStream fileInputStream = new FileInputStream(gbkCharsetFile);
        int length1 = fileInputStream.read(datas1);
        System.out.println("从gbk编码的文件中读取的内容为:" + new String(datas1, 0, length1, "GBK"));
        fileInputStream.close();
    }


    /**
     * 字符流读写
     * @throws IOException
     */
    private static void inputAndOutFile2() throws IOException {
        String gbkCharsetFile = "/Users/xuyabo/Documents/java/thinkingInJavaPractice/src/main/java/io_m/gbkCharset";

        FileOutputStream fileOutputStream = new FileOutputStream(gbkCharsetFile);
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(fileOutputStream,"gbk"));
        String content="中文";
        bufferedWriter.write("中文");
        bufferedWriter.flush();
        bufferedWriter.close();
        System.out.println("向文件中以GBK编码写入字符串:"+content);


        FileInputStream fileInputStream = new FileInputStream(gbkCharsetFile);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream,"gbk"));
        String readStr=bufferedReader.readLine();
        System.out.println("从gbk编码的文件中读取的内容为:" + readStr);
        fileInputStream.close();
    }
}
