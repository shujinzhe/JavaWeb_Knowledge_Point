package JDBC;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


/**
 * JDBC元数据信息
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class TestMetaData {
	public static void main(String[] args) {
//		testMetaData();
		testResultSetMetaData();
	}
	/**
	 * 数据库元数据
	 */
	public static void testMetaData(){
		DBManager dbManager = new DBManager();
		Connection conn = null;
		try {
			conn = dbManager.getConnection();
			DatabaseMetaData dbMeta = conn.getMetaData();
			System.out.println(dbMeta);
			System.out.println("数据库名称：" + dbMeta.getDatabaseProductName());
			System.out.println("数据库版本" + dbMeta.getDatabaseProductVersion());
			System.out.println("数据库用户名：" + dbMeta.getUserName());
			System.out.println("数据库驱动名称：" + dbMeta.getDriverName());
			System.out.println("数据库驱动版本：" + dbMeta.getDriverVersion());
			dbManager.closeResource(conn, null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 结果集元数据
	 */
	public static void testResultSetMetaData(){
		DBManager dbManager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dbManager.getConnection();
			String sql = "select id from t_blob";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			//获取结果集的元数据信息
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("获取结果集列数：" + rsmd.getColumnCount());
			System.out.println("获取指定列的名称：" + rsmd.getColumnName(1));
			System.out.println("获取指定列的类型：" + rsmd.getColumnType(1));
			System.out.println("获取指定列的类型名称：" + rsmd.getColumnTypeName(1));
			//可以使用元数据信息遍历ResultSet
			dbManager.closeResource(conn, null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
