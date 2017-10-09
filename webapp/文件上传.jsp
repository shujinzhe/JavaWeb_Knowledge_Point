<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%
	/* InputStream in = request.getInputStream();
	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	String str = "";
	while((str=br.readLine())!=null){
		out.println(str + "<br/>");
	} */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>文件上传</title>
</head>
<body>
	<!-- 使用上传必须修改enctype类型 -->
	<form action="${pageContext.request.contextPath}/upload" method="post" 
		enctype="multipart/form-data">
		请选择要上传的文件:<input type="file" name="filePath" /><br/>
		请输入文件名:<input type="text" name="fileName" /><br/>
		<input type="submit" value="上传" />
	</form>
	
	<!-- enctype="multipart/form-data"时下面两个值取不到 -->
	<%-- filePath:${param.filePath }<br/>
	fileName:${param.fileName }<br/> --%>
</body>
</html>