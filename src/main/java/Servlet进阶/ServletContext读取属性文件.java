package Servlet进阶;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ServletContext读取属性文件
 * @author Eric_Junior
 * 创建时间：2017年10月3日
 */
public class ServletContext读取属性文件  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		/**
		 * 获取文件的绝对路径并加载
		 */
		String realPath = this.getServletContext().getRealPath("/WEB-INF/db.properties");
		Properties prop = new Properties();
		prop.load(new FileInputStream(realPath));
//		prop.load(this.getServletContext().getResourceAsStream("/WEB-INF/db.properties"));
		System.out.println(prop.getProperty("driver"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		
	}
}
