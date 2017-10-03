package Servlet进阶;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 	读Cookie
 * @author Eric_Junior
 * 创建时间：2017年10月3日
 */
public class ReadCookieServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		/**
		 * 获取所有的Cookie
		 */
		Cookie[] cookies = req.getCookies();
		if(cookies!=null&&cookies.length>0){
			for(Cookie cookie : cookies){
				if("username".equals(cookie.getName())){
					out.println(cookie.getValue());
				}
			}
		}
	}

}
