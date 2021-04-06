package com.tmall.servlet;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmall.dao.CategoryDAO;
import com.tmall.dao.OrderDAO;
import com.tmall.dao.OrderItemDAO;
import com.tmall.dao.ProductDAO;
import com.tmall.dao.ProductImageDAO;
import com.tmall.dao.PropertyDAO;
import com.tmall.dao.PropertyValueDAO;
import com.tmall.dao.ReviewDAO;
import com.tmall.dao.UserDAO;
import com.tmall.util.Page;

public class BaseForeServlet extends HttpServlet{
	
	protected CategoryDAO categoryDAO = new CategoryDAO();
    protected OrderDAO orderDAO = new OrderDAO();
    protected OrderItemDAO orderItemDAO = new OrderItemDAO();
    protected ProductDAO productDAO = new ProductDAO();
    protected ProductImageDAO productImageDAO = new ProductImageDAO();
    protected PropertyDAO propertyDAO = new PropertyDAO();
    protected PropertyValueDAO propertyValueDAO = new PropertyValueDAO();
    protected ReviewDAO reviewDAO = new ReviewDAO();
    protected UserDAO userDAO = new UserDAO();
    
    public void service(HttpServletRequest request, HttpServletResponse response) {
		
    	try {
			
    		int start = 0;
    		int count = 0;
    		try {
				start = Integer.parseInt(request.getParameter("page.start"));
			} catch (Exception e) {
				// TODO: handle exception
			}
    		
    		try {
				count = Integer.parseInt(request.getParameter("page.count"));
			} catch (Exception e) {
				// TODO: handle exception
			}
    		
    		Page page = new Page(start, count);
    		
    		/*�������䣬���ö�Ӧ�ķ���*/
            String method = (String) request.getAttribute("method");
            Method m = this.getClass().getMethod(method, HttpServletRequest.class,
                    HttpServletResponse.class,Page.class);
            String redirect = m.invoke(this,request, response,page).toString();
             
            /*���ݷ����ķ���ֵ��������Ӧ�Ŀͻ�����ת���������ת�����߽���������ַ���*/
            if (redirect.startsWith("@")) {
				response.sendRedirect(redirect.substring(1));
			}else if (redirect.startsWith("%")) {
				response.getWriter().print(redirect.substring(1));;
			}else {
				request.getRequestDispatcher(redirect).forward(request, response);
			}
    		
    		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
    	
	}

}
