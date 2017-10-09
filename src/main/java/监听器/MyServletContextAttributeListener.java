package 监听器;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * 监听ServletContext中属性的添加、删除以及替换
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener{

	/**
	 * ServletContext中增加属性
	 */
	@Override
	public void attributeAdded(ServletContextAttributeEvent sca) {
		// TODO Auto-generated method stub
		System.out.println("属性key：" + sca.getName() + "|属性value：" + sca.getValue());
	}
	/**
	 * ServletContext中删除属性
	 */
	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * ServletContext中替换属性
	 */
	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	


}
