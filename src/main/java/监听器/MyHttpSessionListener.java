package 监听器;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 监听HttpSession中属性的添加、删除以及替换
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class MyHttpSessionListener implements HttpSessionAttributeListener{
	/**
	 * HttpSession中增加属性
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * HttpSession中删除属性
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * HttpSession中替换属性
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
