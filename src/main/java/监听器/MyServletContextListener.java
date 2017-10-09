package 监听器;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * 监听ServletContext的创建与销毁
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class MyServletContextListener implements ServletContextListener{

	/**
	 * 当ServletContext创建时
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("当ServletContext创建时调用...");
	}
	
	/**
	 * 当ServletContext销毁时
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("当ServletContext销毁时调用...");
	}


}
