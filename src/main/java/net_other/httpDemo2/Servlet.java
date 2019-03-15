package net_other.httpDemo2;

/**
 * 1. 将RequestPackage与ResponsePackage整合到一个类中
 * 2. 将Servlet抽象为一个抽象类，对应不同的请求有不同的Servlert子类处理
 */
public abstract class Servlet {

    public void service(RequestPackage request, ResponsePackage response){
        if(request.getMethod().equalsIgnoreCase("next")){
            doGet(request,response);
        }else{
            doPost(request,response);
        }
    }

    protected abstract void doGet(RequestPackage requestPackage, ResponsePackage responsePackage);
    protected abstract void doPost(RequestPackage requestPackage, ResponsePackage responsePackage);
}
