package Servlet进阶;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		InputStream in = req.getInputStream();
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		streamCopy(in, out);
//		byte[] result = out.toByteArray();
//		System.out.println(new String(result));
		
		/**
		 * 使用Request的getParameter方法获取请求实体内容中的参数
		 */
		System.out.println(req.getParameter("name"));
	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}



	//读取请求消息的实体内容
	//GET请求方式是没有实体内容的
	private void streamCopy(InputStream in,OutputStream out) throws IOException{
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = in.read(buf))!=-1){
			out.write(buf,0,len);
		}
	}
}
