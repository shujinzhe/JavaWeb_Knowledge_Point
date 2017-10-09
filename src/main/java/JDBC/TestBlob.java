package JDBC;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 测试大字段的存储和读取
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class TestBlob {
	public static void main(String[] args) {
		
		testInsertBlob();
	}
	/**
	 * 测试插入大字段
	 */
	public static void testInsertBlob(){
		DBManager dbManager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dbManager.getConnection();
			String sql = "insert into t_blob(id,blob) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			FileInputStream in = new FileInputStream(new File("blob_test.jpg"));
			ps.setBlob(2, in);
			System.out.println(ps.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
