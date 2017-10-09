package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 批量梳理，提高处理速度
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class TestJDBCBatch {
	public static void main(String[] args) {
		testBatchInsert();
	}
	
	/**
	 * 测试批量插入
	 */
	public static void testBatchInsert(){
		DBManager dbManager = new DBManager();
		Connection conn = null;
		Statement st = null;
		try {
			conn = dbManager.getConnection();
			st = conn.createStatement();
			conn.setAutoCommit(false);
			String sql = "";
			for(int i=0;i<2017;i++){
				sql = "insert into t_batch(name) values('name" + i + "')";
				st.addBatch(sql);
				if(i%1000==0){
					st.executeBatch();
					st.clearBatch();
				}
			}
			st.executeBatch();
			conn.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(conn!=null){
				try {
					//事务回滚
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}finally{
			dbManager.closeResource(conn, null, null);
		}
	}
}

