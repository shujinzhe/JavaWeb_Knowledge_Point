package 监听器;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 监听HttpSession的创建和销毁
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class MyHttpSessionAttributeListener implements HttpSessionListener{
	/**
	 * Session创建时调用
	 */
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Session创建时调用...");
	}

	/**
	 * Session销毁时调用
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Session销毁时调用...");
	}

}
