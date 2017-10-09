package 数据库连接池;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

/**
 * DBCP数据库连接池,2.x版本
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class TestDBCP {
	public static void main(String[] args) {
//		DBCP01();
		DBCP02();
		
	}

	private static void DBCP01(){
		/**
		 * 实现了javax.sql.DataSource接口
		 */
		BasicDataSource bds = new BasicDataSource();
		//设置用户名
		bds.setUsername("root");
		//设置密码
		bds.setPassword("123456");
		//设置URL
		bds.setUrl("jdbc:mysql://localhost:3306/javaweb");
		//设置驱动
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		//设置初始化连接数
		bds.setInitialSize(4);
		//设置最大连接数
		bds.setMaxTotal(10);
		//设置最大空闲数
		bds.setMaxIdle(5);
		//设置最小空闲数
		bds.setMinIdle(3);
		//设置最大等待时间
		bds.setMaxWaitMillis(5*1000);
		//获取连接
		Connection conn = null;
		try {
			conn = bds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("使用构造方法创建：" + conn);
	}
	
	private static void DBCP02(){
		/**
		 * 可以将这些属性配置放在配置文件中
		 */
		Properties props = new Properties();
		props.setProperty("username", "root");
		props.setProperty("password", "123456");
		props.setProperty("url", "jdbc:mysql://localhost:3306/javaweb");
		props.setProperty("driverClassName", "com.mysql.jdbc.Driver");
		props.setProperty("initialSize", "4");
		props.setProperty("maxTotal", "10");
		props.setProperty("maxIdle", "5");
		props.setProperty("minIdle", "3");
		props.setProperty("maxWaitMillis", "5000");
		Connection conn = null;
		try {
			DataSource bds = BasicDataSourceFactory
					.createDataSource(props);
			conn = bds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("使用工厂创建：" + conn);
	}
}
