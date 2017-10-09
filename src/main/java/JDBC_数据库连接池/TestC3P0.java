package JDBC_数据库连接池;

import java.beans.PropertyVetoException;
import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0数据池
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class TestC3P0 {
	public static void main(String[] args) {
		testC3P0();
	}
	
	private static void testC3P0(){
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		Connection conn = null;
		try {
			cpds.setDriverClass("com.mysql.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/javaweb");
			cpds.setUser("root");
			cpds.setPassword("123456");
			cpds.setMinPoolSize(4);
			cpds.setMaxPoolSize(10);
			//设置每次请求的数目
			cpds.setAcquireIncrement(5);
			conn = cpds.getConnection();
			System.out.println(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
