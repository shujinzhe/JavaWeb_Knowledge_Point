package Servlet进阶;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 	登录时保存Cookie信息
 * @author Eric_Junior
 * 创建时间：2017年10月3日
 */
public class LoginSaveCookie extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//POST请求编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//使用Cookie保存中文时需要转码
		//从Cookie中取中文时要解码
		String username = URLEncoder.encode(req.getParameter("username"), "utf-8");
		String passwd = URLEncoder.encode(req.getParameter("passwd"), "utf-8");
		String save = req.getParameter("save");
		Cookie usernameCookie = null;
		Cookie passwdCookie = null;
		if(username!=null&&!"".equals(username)){
			usernameCookie = new Cookie("username", username);
		}
		if(passwd!=null&&!"".equals(passwd)){
			passwdCookie = new Cookie("passwd", passwd);
		}
		if(save!=null){
			System.out.println("Cookie被保存了");
			if(usernameCookie!=null){
				usernameCookie.setMaxAge(7*24*60*60);
			}
			if(passwdCookie!=null){
				passwdCookie.setMaxAge(7*24*60*60);
			}
			resp.addCookie(usernameCookie);
			resp.addCookie(passwdCookie);
		}else{
			System.out.println("Cookie没有被保存");
			if(usernameCookie!=null){
				usernameCookie.setMaxAge(0);
			}
			if(passwdCookie!=null){
				passwdCookie.setMaxAge(0);
			}
		}
		
	}

}
