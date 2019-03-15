package net_other;


import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import static java.net.InetAddress.*;

/**
 * InetAddress代表IP地址
 * 包含两个信息
 * 主机名
 * IP地址
 * 注意：创建InetAddress时，如果传入了IP地址，不会做IP地址的逆向解析（通过ip地址查域名）。
 */
public class InetAddressDemo {
    public static void main(String[] args) {
        //getHostAddress();
        try {
            System.out.println("通过主机名创建InetAddress对象");
            InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress.getHostName());
            System.out.println(inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("通过ip地址的字符串形式创建InetAddress");
            InetAddress inetAddress = InetAddress.getByName("180.97.33.108");
            System.out.println(inetAddress.getHostName());
            System.out.println(inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


        try {
            String host = "www.baidu.com";
            System.out.println("查询"+host+"的所有IP地址");
            InetAddress[] inetAddresses = InetAddress.getAllByName(host);
            for (int i = 0; i < inetAddresses.length; i++) {
                System.out.println(inetAddresses[i].getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        getHostAddress();

    }

    /**
     * 返回本地主机名和ID地址
     */
    private static void getHostAddress() {
        try {
            System.out.println("获取本地主机名和ip地址");
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress.getHostName());
            System.out.println(inetAddress.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
