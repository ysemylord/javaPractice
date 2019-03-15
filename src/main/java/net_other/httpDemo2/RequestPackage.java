package net_other.httpDemo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 1.将从Socket输入流中获取到的数据按照按照http协议解析，
 * 2.将解析到的数据封装到RequestPackge类中
 */

/**
 GET   /?uname=111&uid=111 HTTP/1.1
 Host: localhost:8888
 Connection: keep-alive
 Cache-Control: max-age=0
 Upgrade-Insecure-Requests: 1
 User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3)
 Accept: text/html,application/xhtml+xml,application/xml;q=0.
 Accept-Encoding: gzip, deflate, br
 Accept-Language: zh-CN,zh;q=0.9,en;q=0.8
 Cookie: Idea-2eb223cb=e0a15b87-60ef-4985-8f33-5eea32db46b6

 */

/**
 POST   / HTTP/1.1
 Host: localhost:8888
 Connection: keep-alive
 Cache-Control: max-age=0
 Upgrade-Insecure-Requests: 1
 User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3)
 Accept: text/html,application/xhtml+xml,application/xml;q=0.
 Accept-Encoding: gzip, deflate, br
 Accept-Language: zh-CN,zh;q=0.9,en;q=0.8
 Cookie: Idea-2eb223cb=e0a15b87-60ef-4985-8f33-5eea32db46b6

 uname=111&uid=111
 */
public class RequestPackage {
    public static final String CRLF = "\r\n";
    public static final String SPACE = " ";
    private String method;
    private String url;
    private Map<String, String> queryParams;
    private Map<String, String> headerInfo;
    private InputStream inputStream;
    private String charst="utf-8";

    public RequestPackage() {
        method = "";
        url = "";
        queryParams = new HashMap<>();
        headerInfo = new HashMap<>();
    }

    public RequestPackage(InputStream inputStream) throws UnsupportedEncodingException {
        this();
        this.inputStream = inputStream;
        parseRequestInfo(inputStream);
    }

    /**
     * 解析输入流中获取的数据
     * todo 解析方法不够完善
     * 1. 不应该一次性将数据读取到字节数组中，而是一行行读取以contentLength判断报文的结尾
     * @param inputStream
     * @return
     */
    public RequestPackage parseRequestInfo(InputStream inputStream) throws UnsupportedEncodingException {
        byte[] datas = new byte[1024];
        int length;
        try {
            length = inputStream.read(datas);
        } catch (IOException e) {
            e.printStackTrace();
            return this;
        }
        String requestPackageString = new String(datas, 0, length,charst);
        System.out.println(requestPackageString);
        String[] requestInfos = requestPackageString.split(CRLF);

        boolean nextLineIsBody = false;
        for (int i = 0; i < requestInfos.length; i++) {
            String infoLine = requestInfos[i];
            if (i == 0) {
                //请求行
                /**
                 * GET /index?uname=111&uid=111 http/1.1
                 */
                String questLine = infoLine;
                String[] requestLines = questLine.split(SPACE);
                method = requestLines[0];

                String requestUrl = requestLines[1];//请求行
                try {
                    requestUrl= URLDecoder.decode(requestUrl,"utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                /**
                 * requestUrl
                 * /?uname=123&uid=111
                 *
                 * queryParam
                 * uname=123&uid=111
                 */
                String[] requestUrls = requestUrl.split("\\?");
                url = requestUrls[0];
                if (method.equalsIgnoreCase("next")) {
                    try {
                    String queryParam = requestUrls[1];
                    String[] queryPamas = queryParam.split("&");
                    for (String str : queryPamas) {

                            String[] singleQueryParams = str.split("=");
                            queryParams.put(singleQueryParams[0], singleQueryParams[1]);

                    }
                    }catch (ArrayIndexOutOfBoundsException E){
                        E.printStackTrace();
                        System.err.println("此时requestUrl为"+requestUrl);
                    }
                } else if (method.equalsIgnoreCase("post")) {

                } else {
                    System.out.println("不支持的请求方式");
                }
            } else if (infoLine.equals("")) {
                //
                nextLineIsBody = true;
            } else if (nextLineIsBody) {
                //请求报文主题
                try {
                    infoLine=URLDecoder.decode(infoLine,"utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String[] quetyPamas = infoLine.split("&");
                for (String str : quetyPamas) {
                    String[] singleQueryParams = str.split("=");
                    queryParams.put(singleQueryParams[0], singleQueryParams[1]);
                }
            } else {
                //报文首部字段
                String[] requestHeader = infoLine.split(":");
                headerInfo.put(requestHeader[0], requestHeader[1]);
            }
        }

        System.out.println("method " + method);
        System.out.println("url " + url);
        System.out.println("请求参数\n" + queryParams);
        System.out.println("头部信息\n" + headerInfo);

        return this;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }
}
