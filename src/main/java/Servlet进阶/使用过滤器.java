package Servlet进阶;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理不雅信息
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class 使用过滤器 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletConfig()
				.getServletContext().getRequestDispatcher("/使用过滤器.jsp");
		/**
		 * ?name=bad222
		 * 包装类会将bad替换为***
		 */
		String v = req.getParameter("name");
		req.setAttribute("name", v);
		dispatcher.forward(req, resp);
	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}


}
