package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.mysql.jdbc.Driver;

/**
 * 测试Mysql连接
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class TestConnection {
	public static void main(String[] args) {
//		testDriver();
//		testDriver2();
		testDriver3();
	}
	
	/**
	 * 真正开发中的连接方式
	 */
	public static void testDriver3(){
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mysql",
					"root",
					"123456");
			System.out.println(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 注册驱动
	 */
	public static void testDriver2(){
		try {
			String url = "jdbc:mysql://localhost:3306/mysql";
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mysql",
					"root",
					"123456");
			System.out.println(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过Driver接口连接
	 */
	public static void testDriver(){
		try {
			Driver driver = new com.mysql.jdbc.Driver();
			Properties info = new Properties();
			info.setProperty("user", "root");
			info.setProperty("password", "123456");
			String url = "jdbc:mysql://localhost:3306/mysql";
			Connection conn = driver.connect(url, info);
			System.out.println(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
