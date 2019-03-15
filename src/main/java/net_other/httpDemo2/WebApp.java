package net_other.httpDemo2;

import java.util.Map;

/**
 * 负责给ServletContext中添加数据
 */
public class WebApp {
   private static ServletContext servletContext;
   static {
       servletContext=ServletContext.getInstance();
       Map<String,String> pathAlias=servletContext.getPathAlias();
       Map<String,Servlet>  aliasServert=servletContext.getAliasServert();
       pathAlias.put("/log", "login");
       pathAlias.put("/login", "login");
       aliasServert.put("login", new LoginServlet());

       pathAlias.put("/reg", "register");
       pathAlias.put("/register", "register");
       aliasServert.put("register", new RegisterServlet());
   }

    /**
     * @param url /login
     * @return
     */
   public static Servlet getServlet(String url){
       if(url==null||url.equals("")){
           return null;
       }
       String alias=servletContext.getPathAlias().get(url);
       return servletContext.getAliasServert().get(alias);
   }
}
