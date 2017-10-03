package Servlet进阶;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 记录上次访问网站的时间
 * @author Eric_Junior
 * 创建时间：2017年10月3日
 */
public class LastDateServlet  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		/**
		 * 第一次访问时
		 * 		客户端还不存在Cookie
		 * 		服务器创建Cookie并放置到响应头中，传给客户端
		 * 第二次访问时
		 * 		客户端传递Cookie到服务器端
		 * 		服务器端读取客户端传递的Cookie并显示在页面上
		 * 		服务器创建Cookie，并放置到响应头中，传给客户端
		 * 		重复第二次访问的步骤
		 * 
		 */
		Cookie[] cookies = req.getCookies();
		if(cookies==null){
			out.println("上次访问该网站的时间：无记录");
			/**
			 * 在Cookie保存时间的时候，时间中不能包含空格 ： /等特殊的字符
			 */
			Cookie lastdateCookie = new Cookie("lastdate", 
					new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")
					.format(new Date()));
			lastdateCookie.setMaxAge(365*24*60*60);
			lastdateCookie.setPath(req.getContextPath());
			resp.addCookie(lastdateCookie);
		}
		if(cookies!=null&&cookies.length>0){
			for(Cookie cookie : cookies){
				if("lastdate".equals(cookie.getName())){
					out.println("上次访问该网站的时间：" + cookie.getValue());
					Cookie lastdateCookie = new Cookie("lastdate", 
							new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")
							.format(new Date()));
					lastdateCookie.setMaxAge(365*24*60*60);
					lastdateCookie.setPath(req.getContextPath());
					resp.addCookie(lastdateCookie);
					break;
				}
			}
		}
		
	}

}
