package io_m;

import java.io.*;

/**
 * 如果一个页面的流畅度有一个时刻小于50，
 * 则将这个页面的所有信息打印出来
 */
public class SmoothFileAnalyse {
    public static void main(String[] args)  {
        File file = new File("testFile/smooth.txt");
        String lastPage="";
        String lastChildPage="";
        StringBuilder badPage=new StringBuilder();//记录所有的不流畅的页面
        StringBuilder tempLines=new StringBuilder();//记录的是一个页面的所有数据，在需要时将其打印出来。
        boolean badSmooth=false;
        try {
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            while((line=bufferedReader.readLine())!=null) {//没有读取完毕

                //剔除脏数据
                if(line.equals("flush")){
                    continue;
                }
                String[] datas = line.split("\\|");
                if(datas.length<3){
                    System.out.println("bad data:"+line);
                    continue;
                }

                String page = datas[0];
                String childPage = datas[1];

                //下一页的统计数据
                if(!page.equals(lastPage)||!childPage.equals(lastChildPage)){
                    if(badSmooth){//上一个页面有不流畅的时刻
                        badSmooth=false;
                        badPage.append(lastPage+"|"+lastChildPage+"\n");
                        System.out.println(tempLines);
                        System.out.println("-------------------");
                    }
                    tempLines.delete(0,tempLines.length());
                }
                tempLines.append(line+"\n");

                lastPage=page;
                lastChildPage=childPage;

                String[] timeArr = datas[2].split(" ");
                String smooth = timeArr[timeArr.length - 1];
                Integer smoothValue = Integer.valueOf(smooth);

                if (smoothValue <= 50) {
                    badSmooth=true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("bad page is\n"+badPage);

    }
}
