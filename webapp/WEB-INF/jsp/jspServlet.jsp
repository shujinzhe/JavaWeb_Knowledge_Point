<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%=basePath %>">
</head>
<body>
	<!-- 获取firstServlet转发过来的info信息 -->
	Java表达式获取：<%=request.getAttribute("info") %><br/>
	EL表达式获取：${info }<br/>
	以servlet的形式访问到了WEB-INF下的jsp文件<br/>
</body>
</html>