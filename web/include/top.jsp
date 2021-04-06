<%@ page import="com.tmall.listener.OnlineCounter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
 
<nav class="top ">
        <a href="index.jsp">
            <span style="color:#C40000;margin:0px" class=" glyphicon glyphicon-home redColor"></span>
            京东首页
        </a> 
         
        <span>喵，欢迎来京东</span>
        <span>
			在线人数:<%=OnlineCounter.getOnline()%>
		</span>
         
        <c:if test="${!empty user}">
            <a href="login.jsp">${user.name}</a>
            <a href="forelogout">退出</a>    
        </c:if>
         
        <c:if test="${empty user}">
            <a href="login.jsp">请登录</a>
            <a href="register.jsp">免费注册</a>    
        </c:if>
 
        <span class="pull-right">
            <a href="forebought">我的订单</a>
            <a href="forecart">
            <span style="color:#C40000;margin:0px" class=" glyphicon glyphicon-shopping-cart redColor"></span>
            购物车<strong>${cartTotalItemNumber}</strong>件</a>      
        </span>
         
</nav>