package net_other.httpDemo2;

public class RegisterServlet extends Servlet {
    @Override
    protected void doGet(RequestPackage requestPackage, ResponsePackage responsePackage) {
        String responcontent = "<html><head><meta http-equiv=content-type content=text/html;charset=utf-8></head>" +
                "<body>你好"+requestPackage.getQueryParams().get("uname")+"regisger success</body></html>";
        responsePackage.buildContent(responcontent);
    }

    @Override
    protected void doPost(RequestPackage requestPackage, ResponsePackage responsePackage) {

    }
}
