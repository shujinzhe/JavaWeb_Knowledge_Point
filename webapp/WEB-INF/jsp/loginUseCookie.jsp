<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*,javax.servlet.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username="";
	String passwd="";
	Cookie[] cookies = request.getCookies();
	if(cookies!=null&&cookies.length>0){
		for(Cookie cookie : cookies){
			if("username".equals(cookie.getName())){
				username = URLDecoder.decode(cookie.getValue(), "UTF-8");
			}
			if("passwd".equals(cookie.getName())){
				passwd = URLDecoder.decode(cookie.getValue(),"UTF-8");
			}
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用Cookie登录</title>
</head>
<body>
	<form action="loginSaveCookie" method="post">
		用户名：<input type="text" name="username" value="<%=username %>"/><br/>
		密&nbsp;&nbsp;码：<input type="password" name="passwd" value="<%=passwd %>"/><br/>
		<input type="checkbox" name="save" />保存用户名密码<br/>
		<input type="submit" value="登录" />
	</form>
</body>
</html>