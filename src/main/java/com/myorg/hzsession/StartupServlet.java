package com.myorg.hzsession;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class StartupServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.getenv().forEach((k,v) -> {
           System.setProperty(k,v);
        });
    }
}
