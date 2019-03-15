package net_other.httpDemo1;

/**
 * 将RequestPackage与ResponsePackage整合到一个类中
 */
public class Servlet {

    public void service(RequestPackage request,ResponsePackage response){
        String responcontent = "<html><head><meta http-equiv=content-type content=text/html;charset=utf-8></head>" +
                "<body>你好"+request.getQueryParams().get("uname")+"</body></html>";
        response.buildContent(responcontent);
    }
}
