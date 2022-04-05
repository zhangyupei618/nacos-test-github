package com.abc.servlet.config;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * org.apache.catalina.core.StandardWrapperFacade 这个类实现了ServletConfig接口  tomcat实现了这个接口
 * 一个servlet对应一个servletConfig
 */
public class TestServletConfig extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter writer = res.getWriter();
        ServletConfig servletConfig = this.getServletConfig();
        System.out.println(servletConfig);
        writer.print(servletConfig);
        String servletName = servletConfig.getServletName();
        writer.print("<br>"+servletName);
    }
}
