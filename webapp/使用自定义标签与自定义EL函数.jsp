<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://www.eric.com/jsp/mytag/core" prefix="eric" %>
<%@ taglib uri="http://www.eric.com/jsp/mytag/functions" prefix="func" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>使用自定义标签与自定义EL函数</title>
</head>
<body>
	Java表达式显式系统的当前时间：<%=new Date() %><br>
	Java代码显式系统的当前时间：<%out.println(new Date()); %><br/>
	1、自定义标签显式系统的当前时间：<eric:date/><br>
	
	2、自定义标签比较最大值：<eric:max num2="35" num1="45"/><br/>
	
	3、自定义标签循环输出值：<eric:circle begin="1" end="100" step="2"/><br/>
	
	4、自定义标签输出文件的内容：<eric:readFile src="/WEB-INF/db.properties"/><br/>
	<!-- 这时的eric是在标签体中，需要实现setJspBody方法 -->
	5、转换成大写：<eric:toUpperCase>eric</eric:toUpperCase><br/>
	
	
	6、使用自定义函数获取字符串长度：${func:getLen("aaa") }<br/>
	
	7、${fn:contains("aaa","aa") }
	
	
	
</body>
</html>