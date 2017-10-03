package Servlet进阶;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 使用HttpSession
 * @author Eric_Junior
 * 创建时间：2017年10月3日
 */
public class UsingHttpSession extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//如果没有就创建一个Session
		HttpSession session = req.getSession(true);
		out.println("session的ID：" + session.getId() + "<br/>");
		out.println("session是否为新创建的：" + session.isNew() + "<br/>");
		out.println("session的最大超时时间，单位为秒：" + session.getMaxInactiveInterval() + "<br/>");
		out.println("session的创建时间：" + session.getCreationTime() + "<br/>");
		out.println("session的上一次访问时间：" + session.getLastAccessedTime() + "<br/>");
		
		/**
		 * Session的主要方法，用于往Session域中添加键值对，供同一个会话的Servlet共享
		 * 1、setAttribute(String name,Object value)
		 * 2、getAttribute(String name)
		 * 3、removeAttribute(String name)
		 * 4、getAttributeNames()
		 */
	}
}
