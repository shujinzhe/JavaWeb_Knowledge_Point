package JDBC_DBUtil;


public class TestDBUtils {
	public static void main(String[] args) {
		/**
		 * 	DbUtils ：提供如关闭连接、装载JDBC驱动程序等常规工作的工具类，里面的所有方法都是静态的。主要方法如下：
				public static void close(…) throws java.sql.SQLException：　DbUtils类提供了
					三个重载的关闭方法。这些方法检查所提供的参数是不是NULL，如果不是的话，它们就关闭Connection、
					Statement和ResultSet。
				public static void closeQuietly(…): 这一类方法不仅能在Connection、Statement和
					ResultSet为NULL情况下避免关闭，还能隐藏一些在程序中抛出的SQLEeception。
				public static void commitAndCloseQuietly(Connection conn)： 用来提交连接，
					然后关闭连接，并且在关闭连接时不抛出SQL异常。 
				public static boolean loadDriver(java.lang.String driverClassName)：这一方法
					装载并注册JDBC驱动程序，如果成功就返回true。使用该方法，你不需要捕捉这个异常ClassNotFoundException。
		 */
	}
}
