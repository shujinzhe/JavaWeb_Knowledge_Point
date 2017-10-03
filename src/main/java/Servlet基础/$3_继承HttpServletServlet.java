package Servlet基础;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 继承HttpServlet
 * @author Eric_Junior
 * 创建时间：2017年10月2日
 */
public class $3_继承HttpServletServlet extends HttpServlet{

	/**
	 * if(req.getMethod()=="HEAD"){
	 * 		//只返回头信息
	 * }	
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.write("协议：" + req.getProtocol() + "<br/>");
		out.write("地址：" + req.getRemoteAddr() + "<br/>");
		out.write("主机：" + req.getRemoteHost() + "<br/>");
		out.write("端口：" + req.getRemotePort() + "<br/>");
		out.write("用户：" + req.getRemoteUser() + "<br/>");
		out.write("上下文路径：" + req.getContextPath() + "<br/>");
		out.write("Servlet路径" + req.getServletPath() + "<br/>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}



	

	

}
