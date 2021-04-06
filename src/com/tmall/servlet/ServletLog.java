package com.tmall.servlet;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(name = "ServletLog")
public class ServletLog extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    public void destroy() {
        super.destroy();
    }

    public ServletLog() {
        super();
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    @Override
    public void init() throws ServletException {
        String file =this.getInitParameter("log4j");//从web.xml配置读取，名字一定要和web.xml配置一致
        if(file != null){
            PropertyConfigurator.configure(file);
        }
    }

}
