package JDBC_数据库连接池;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import JDBC.DBManager;

/**
 * 使用DBCP创建通用的数据库连接池
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class DBCPManager {
	private static DBCPManager dbcpManager = new DBCPManager();
	private static BasicDataSource bds = null;
	private DBCPManager(){
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
		try {
			bds = BasicDataSourceFactory
					.createDataSource(props);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DBCPManager getManager(){
		return dbcpManager;
	}
	
	public static Connection getConnection(){
		try {
			return bds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 关闭资源
	 */
	public static void closeResource(Connection conn,Statement st,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(st!=null){
					st.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if(conn!=null){
						conn.close();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
