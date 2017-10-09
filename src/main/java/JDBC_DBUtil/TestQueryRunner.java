package JDBC_DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import JDBC_数据库连接池.DBCPManager;

/**
 * 测试DBUtils的QueryRunner
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
@SuppressWarnings("unchecked")
public class TestQueryRunner {
	public static void main(String[] args) throws Exception {
//		testQueryRunnerNoParam();
		testQueryRunnerWithParam();
		/**
		 * 比较有用的实现类
		 * 使用BeanHandler或BeanListHandler将查询结果集封装到JavaBean中
		 * BeanListHandler实现了ResultSetHandler接口
		 */
	}
	/**
	 * 使用QueryRunner进行没有参数的select查询
	 * @throws Exception
	 */
	public static void testQueryRunnerNoParam() throws Exception{
		DBCPManager dbcpManager = DBCPManager.getManager();
		Connection conn = dbcpManager.getConnection();
		String sql = "select id from t_blob";
		QueryRunner query = new QueryRunner();
		query.query(conn, sql, new ResultSetHandler() {

			/**
			 * 回调函数
			 */
			@Override
			public Object handle(ResultSet rs) throws SQLException {
				System.out.println("回调函数获取结果集列数：" + rs.getMetaData().getColumnCount());
				/**
				 * 这里可以存放结果集的处理逻辑
				 */
				return null;
			}
		});
	}
	
	/**
	 * 使用QueryRunner进行有参数的select查询
	 * @throws Exception
	 */
	public static void testQueryRunnerWithParam() throws Exception{
		DBCPManager dbcpManager = DBCPManager.getManager();
		Connection conn = dbcpManager.getConnection();
		String sql = "select id from t_blob where id=?";
		Object[] params = new Object[]{1};
		QueryRunner query = new QueryRunner();
		query.query(conn, sql, new ResultSetHandler() {

			/**
			 * 回调函数
			 */
			@Override
			public Object handle(ResultSet rs) throws SQLException {
				System.out.println("回调函数获取结果集列数：" + rs.getMetaData().getColumnCount());
				/**
				 * 这里可以存放结果集的处理逻辑
				 */
				return null;
			}
		},
		//相当于PreparedStatement的填充数组
		params);
	}
	
	
	
}
