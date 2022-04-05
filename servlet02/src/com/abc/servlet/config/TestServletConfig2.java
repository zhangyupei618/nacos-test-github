package com.abc.servlet.config;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class TestServletConfig2 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse res) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();
        res.setContentType("text/html");
        PrintWriter writer = res.getWriter();
        writer.print(servletConfig);
    }
}
