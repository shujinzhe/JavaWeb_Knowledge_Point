package Servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现servlet接口
 * @author Eric_Junior
 * 创建时间：2017年10月2日
 */
public class MyServlet1 implements Servlet{
	/**
	 * 处理请求的方法
	 */
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		//获取请求地址
		String requestURI = req.getRequestURI();
		//IP
		String remoteIP = req.getRemoteAddr();
		//请求方式
		String method = req.getMethod();
		//得到所有的请求头
		Enumeration<String> enumHeader = req.getHeaderNames();
		while(enumHeader.hasMoreElements()){
			String headerName = (String)enumHeader.nextElement();
			String headerValue = req.getHeader(headerName);
		}
		
		//设置状态码
		resp.setStatus(404);
	}
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}
