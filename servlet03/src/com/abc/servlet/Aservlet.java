package com.abc.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Aservlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        ServletConfig servletConfig = super.getServletConfig();
        ServletContext servletContext = servletConfig.getServletContext();
        writer.print(servletContext+"<br>");

        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            String initParameter = servletContext.getInitParameter(s);
            writer.print(s+"="+initParameter+"<br>");
        }
    }
}
