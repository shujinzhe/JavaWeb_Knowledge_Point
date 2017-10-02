package Servlet基础;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
public class $1_继承Servlet implements Servlet{
	//该Servlet的配置信息
	private ServletConfig config;

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
		
		/**
		 * 1、设置状态码
		 */
//		resp.setStatus(404);
		
		/**
		 * 2、得到初始化配置信息
		 */
//		System.out.println(config.getInitParameter("encoding"));
		
		/**
		 * 3、定时刷新
		 */
//		resp.getWriter().write("2秒后返回百度首页....");
//		resp.setHeader("refresh", "2;url=http://www.baidu.com");
		
		/**
		 * 4、设置MIME类型以及编码
		 * MIME类型在Tomcat的conf的web.xml中有详细说明
		 * 注意：一定要先设置ContentType，再使用PrintWriter
		 */
		resp.setContentType("text/html;charset=" + config.getInitParameter("encoding"));
		resp.getWriter().write("正常显示中文....");
		
		/**
		 * 5、设置网页缓存失效时间
		 */
		resp.setDateHeader("Expire", new Date().getTime());
		
		/**
		 * 6、得到servlet上下文环境
		 * 7、得到绝对路径
		 */
		ServletContext sc = config.getServletContext();
		String realPath = sc.getRealPath("/myservlet1");
		System.out.println(realPath);
		
		/**
		 * 8、得到全局参数
		 */
		String globalParam = config.getServletContext()
				.getInitParameter("globalParam");
		System.out.println("全局参数：" + globalParam);
	}
	
	/**
	 * 构造方法之后Tomcat容器调用init方法
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
		System.out.println("构造方法之后Tomcat容器调用init方法");
	}
	
	/**
	 * 容器销毁时调用destory方法
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("容器销毁时调用destory方法");
	}

	/**
	 * 可能存在子类继承，可以拿到父类的配置信息
	 */
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "我的第一个Servlet";
	}

	

	

}
