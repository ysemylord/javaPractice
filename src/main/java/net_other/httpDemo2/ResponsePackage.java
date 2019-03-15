package net_other.httpDemo2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

/**
 * 1.ResponsePackage包含响应报文的信息
 * 2.按照http响应报文的格式将数据写入Socket输出流中
 */
public class ResponsePackage {
    public static final String CRLF = "\r\n";
    public static final String SPACE = " ";
    private String charset = "utf-8";
    private int contentLength = 0;
    private StringBuilder mHeaderInfo;
    private StringBuilder mContent;
    private OutputStream outputStream;

    public ResponsePackage(OutputStream outputStream) {
        this.mHeaderInfo =new StringBuilder();
        this.mContent = new StringBuilder();
        this.outputStream = outputStream;
    }

    /**
     * 构建一个简单的响应报文首部，只有code可变
     *设置为私有，不向外部提供
     * @param code
     * @return
     */
    private StringBuilder buildHeaderInfo(int code) {
        String codeDes = "OK";
        switch (code) {
            case 200:
                codeDes = "OK";
                break;
            case 404:
                codeDes = "NOT FOUND";
                break;
            case 500:
                codeDes = "Server Inner Error";
                break;
        }
        mHeaderInfo.append("http/1.1").append(SPACE).append(code).append(SPACE).append(codeDes).append(CRLF)
                .append("Server:xyb/1.00").append(CRLF)
                .append("Date:" + new Date()).append(CRLF)
                //如果为text/plain,浏览器会按照纯文本解析返回的内容，
                //如果为text/html,浏览器会按照html解析返回的内容
                .append("Content-type:" + "text/html" + "," + "charset=" + charset).append(CRLF)
                .append("Content-length:" + contentLength).append(CRLF)
                .append(CRLF);
        return mHeaderInfo;
    }

    /**
     * 构建响应报文主体
     * 这样子设计有个问题:必须先调用buildContent再调用buildHeaderInfo，不然头部中的ContentLength的值是错误的
     * @param info
     * @return
     */
    public ResponsePackage buildContent(String info){
        mContent.append(info).append(CRLF);
        contentLength=info.length()+CRLF.length();
        return this;
    }

    public void pushToClient(int code) throws IOException {
        BufferedWriter bufferedReader=new BufferedWriter(new OutputStreamWriter(outputStream));
        StringBuilder headerInfo=buildHeaderInfo(code);
        bufferedReader.write(headerInfo.toString());
        bufferedReader.write(mContent.toString());
        bufferedReader.flush();
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public void close() throws IOException {
        outputStream.close();
    }


}
