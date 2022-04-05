package com.abc.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Bservlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        ServletConfig servletConfig = this.getServletConfig();
        ServletContext servletContext = servletConfig.getServletContext();
        writer.print(servletContext+"<br>");
        Enumeration<String> initParameterNames1 = servletConfig.getInitParameterNames();
        while(initParameterNames1.hasMoreElements()){
            String s = initParameterNames1.nextElement();
            String initParameter = servletConfig.getInitParameter(s);
            writer.print(s+"="+initParameter+"<br>");
        }

        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            String initParameter = servletContext.getInitParameter(s);
            writer.print(s+"="+initParameter+"<br>");
        }

        String contextPath = servletContext.getContextPath();
        writer.print("contextPath="+contextPath+"<br>");

        //加上/是从项目的根开始找 获取index。jsp的绝对路径
        String realPath = servletContext.getRealPath("/index.jsp");
        writer.print("realpath="+realPath+"<br>");
        //不加/也是默认从项目的根开始找
        String realPath2 = servletContext.getRealPath("index.jsp");
        writer.print("realpath="+realPath2+"<br>");
        String realPath3 = servletContext.getRealPath("/common/index.jsp");
        writer.print("realpath="+realPath3+"<br>");
    }
}
