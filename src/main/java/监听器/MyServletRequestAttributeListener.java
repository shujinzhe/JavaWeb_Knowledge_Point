package 监听器;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
/**
 * 监听Request中属性的添加、删除与替换
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener{
	/**
	 * Request中增加属性
	 */
	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Request中删除属性
	 */
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Request中替换属性
	 */
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
