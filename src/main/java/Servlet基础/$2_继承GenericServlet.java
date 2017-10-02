package Servlet基础;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现GenericServlet接口
 * @author Eric_Junior
 * 创建时间：2017年10月2日
 */
public class $2_继承GenericServlet extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	/**
	 * 这里使用了设计模式中的模板设计
	 */
	@Override
	public void init() throws ServletException {
		System.out.println(getServletConfig().getInitParameter("encoding"));
	}
	
	

	

}
