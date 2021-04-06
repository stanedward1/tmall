package com.tmall.servlet;

import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2020/5/2 10:21
 * @Created by Edward-dell
 */
@WebServlet(name = "ServletTest")
public class ServletTest extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Logger logger = Logger.getLogger(ResolverUtil.Test.class.getName());

        System.out.println("================97987==============");
        logger.info("Log message on!");
        logger.info("End of log message!");
    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        this.doGet(request, response);
    }

}
