<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 设置为true时可以使用JSP的内置对象exception -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=exception.getMessage() %>
</body>
</html>