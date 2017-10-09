package 过滤器;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class 继承ServletRequestWrapper过滤不雅信息  extends HttpServletRequestWrapper{

	public 继承ServletRequestWrapper过滤不雅信息(HttpServletRequest request) {
		super(request);
	}

	/**
	 * 这里使用了装饰器模式，配合Filter使用，可以实现对getParameter的过滤
	 */
	public String getParameter(String name) {
		// TODO Auto-generated method stub
		String value = super.getParameter(name);
		if(value!=null && value.contains("bad")){
			value = value.replaceAll("bad", "***");
		}
		return value;
	}

}
