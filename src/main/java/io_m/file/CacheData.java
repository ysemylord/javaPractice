package io_m.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheData {

    /**
     * 1.这里使用单线程线程池，如果线程正在执行任务，那么新加入的任务会放入等待队列
     *
     * 2.使用饿汉模式实现单例模式
     */

    private static CacheData cacheData = new CacheData();

    public static CacheData getInstanece() {
        return cacheData;
    }

    private CacheData(){

    }

    private ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
    private List<String> infoList = new ArrayList(21);
    private File file = new File("testFile/test.txt");


    public void write(String info) {
        singleThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                if (infoList.size() >= 20) {
                    for (int m = 0; m < infoList.size(); m++)
                        try {
                            appenContentToFile(infoList.get(m) + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    infoList.clear();
                } else {
                    infoList.add(info);
                }
            }
        });

    }

    private void appenContentToFile(String info) throws IOException {
        System.out.println("path is " + file.getAbsolutePath());
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
            System.out.println("文件不存在，创建文件");
        }
        BufferedWriter bufw = new BufferedWriter(new FileWriter(file, true));
        bufw.write(info);

        bufw.flush();
        bufw.close();
    }
}
