package 过滤器;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
/**
 * 自定义过滤器
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class MyFilter implements Filter{

	/**
	 * 初始化方法
	 * filterConfig可以获取过滤器的配置信息
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器初始化...");
	}

	/**
	 * 过滤器的过滤逻辑
	 * FilterChain表示一个过滤器链，与web.xml中过滤器的顺序一致
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		继承ServletRequestWrapper过滤不雅信息 reqWrapper = 
				new 继承ServletRequestWrapper过滤不雅信息((HttpServletRequest) request);
		chain.doFilter(reqWrapper, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("过滤器销毁...");
	}

}
