package Servlet进阶;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 	写Cookie
 * @author Eric_Junior
 * 创建时间：2017年10月3日
 */
public class WriteCookieServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		/**
		 * 创建Cookie
		 * 第一个参数：cookie名
		 * 第二个参数：cookie值
		 */
		Cookie usernameCookie = new Cookie("username", "eric");
		
		/**
		 * 设置Cookie为持久Cookie
		 * 否则浏览器关闭，Cookie也就随之消失了
		 * setMaxAge(7*24*60*60)，单位为秒
		 */
		usernameCookie.setMaxAge(7*24*60*60);
		/**
		 * 设置Cookie的路径为根路径
		 */
		usernameCookie.setPath(req.getContextPath());
		//设置到响应头
		resp.addCookie(usernameCookie);
	}

}
