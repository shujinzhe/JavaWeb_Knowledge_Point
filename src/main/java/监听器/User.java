package 监听器;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
/**
 * 实现HttpSessionBindingListener接口的对象可以感知对象在Session中的绑定与删除
 * 注意：HttpSessionBindingListener接口不需要在web.xml中注册
 * HttpSessionBindingListener可实现在线人数的统计
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class User implements HttpSessionBindingListener,HttpSessionActivationListener,Serializable{
	private String name;
	private String pwd;
	
	/**
	 * 在Session中放置JavaBean
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("User加入到Session域中...");
	}
	/**
	 * 在Session中删除JavaBean
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("User从Session域中移除...");
	}
	/**
	 * Session活化
	 * Session对象从硬盘上读出
	 */
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Session钝化
	 * 把Session对象保存到硬盘
	 * 对象需实现序列化接口
	 */
	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
