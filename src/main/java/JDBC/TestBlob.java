package JDBC;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 * 测试大字段的存储和读取
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class TestBlob {
	public static void main(String[] args) {
		
//		testInsertBlob();
		testReadBlob();
	}
	/**
	 * 测试插入大字段
	 */
	public static void testInsertBlob(){
		DBManager dbManager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
		/**
		 * 结果集也可以是可滚动的
		 * 	Connection中：
		 * 		Statement createStatement(int resultSetType,
                 	int resultSetConcurrency)
                    throws SQLException
           	Parameters:
				resultSetType - a result set type; 
					one of ResultSet.TYPE_FORWARD_ONLY, 
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					or ResultSet.TYPE_SCROLL_SENSITIVE
				resultSetConcurrency - a concurrency type; 
					one of ResultSet.CONCUR_READ_ONLY 
					or ResultSet.CONCUR_UPDATABLE
			Returns:
				a new Statement object that will generate ResultSet objects with the given type and concurrency
		 */
		ResultSet rs = null;
		
		try {
			conn = dbManager.getConnection();
			String sql = "insert into t_blob(id,image) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			InputStream in = TestBlob.class.getClassLoader()
					.getResourceAsStream("blob_test.jpg");
			ps.setBlob(2, in);
			System.out.println(ps.executeUpdate());
			dbManager.closeResource(conn, ps, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试读取大字段
	 */
	public static void testReadBlob(){
		DBManager dbManager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dbManager.getConnection();
			String sql = "select image from t_blob where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			rs = ps.executeQuery();
			Blob blob = null;
			if(rs.next()){
				blob = rs.getBlob(1);
				InputStream in = blob.getBinaryStream();
				BufferedInputStream bis = new BufferedInputStream(in);
				BufferedOutputStream bos = new BufferedOutputStream(
						new FileOutputStream("xxx.jpg"));
				byte[] buf = new byte[1024*100];
				int len = 0;
				while((len = bis.read(buf))!=-1){
					bos.write(buf,0,len);
				}
				bos.close();
				bis.close();
				
			}
			
			dbManager.closeResource(conn, ps, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
