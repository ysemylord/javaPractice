package net_other;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        try {
            URL url=new URL("https://www.baidu.com/");
            InputStream inputStream=url.openStream();
            InputStreamReader bufferedInputStream=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(bufferedInputStream);
            String line=null;

            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/java/net_other/index.html")));
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
