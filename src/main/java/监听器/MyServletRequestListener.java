package 监听器;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
/**
 * 监听Request的创建与销毁
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class MyServletRequestListener implements ServletRequestListener{
	/**
	 * Request创建时调用
	 */
	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Request创建时调用...");
	}
	
	/**
	 * Request销毁时调用
	 */
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Request销毁时调用...");
	}

}
