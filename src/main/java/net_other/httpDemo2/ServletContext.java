package net_other.httpDemo2;

import java.util.HashMap;
import java.util.Map;

/**
 * Servlet容器，
 * 存放Servlet及其别名与路径
 */
public class ServletContext {
    //因为可能有多个路径指向同一个资源
    //所以设计成
    //路径对应别名，别名对应Servlet
    //如
    /**
     * pathAlias
     * /log-->login
     * /login-->login
     * <p>
     * register-->register
     * reg-->register
     * <p>
     * aliasServert
     * login->LoginServlet
     * register->RegisterSerblet
     */
    private Map<String, String> pathAlias = new HashMap<>();
    private Map<String, Servlet> aliasServert = new HashMap<>();
    private static ServletContext servletContext = new ServletContext();


    private ServletContext() {
        pathAlias = new HashMap<>();
        aliasServert = new HashMap<>();
    }

    public static ServletContext getInstance() {
        return servletContext;
    }

    public Map<String, String> getPathAlias() {
        return pathAlias;
    }

    public void setPathAlias(Map<String, String> pathAlias) {
        this.pathAlias = pathAlias;
    }

    public Map<String, Servlet> getAliasServert() {
        return aliasServert;
    }

    public void setAliasServert(Map<String, Servlet> aliasServert) {
        this.aliasServert = aliasServert;
    }
}
