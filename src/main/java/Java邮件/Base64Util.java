package Java邮件;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import sun.misc.BASE64Encoder;

/**
 * Base64编码
 * @author Eric_Junior
 * 创建时间：2017年10月10日
 */
public class Base64Util {
	public static void main(String[] args) throws Exception {
		/**
		 * 定义Base64编码方式
		 * 使用命令行发送邮件需要进行Base64编码
		 * 使用的类为sun.misc.BASE64Encoder
		 */
		BASE64Encoder encoder = new BASE64Encoder();
		System.out.println("请输入用户名：");
		String username = new BufferedReader(
				new InputStreamReader(System.in)).readLine();
		System.out.println(encoder.encode(username.getBytes()));
		System.out.println("请输入密码：");
		String password = new BufferedReader(
				new InputStreamReader(System.in)).readLine();
		System.out.println(encoder.encode(password.getBytes()));
		
		/**
		 * 命令行发邮件(了解)
		 * 
		 * ehlo 邮件服务器地址
		 * 
		 * AUTH LOGIN
		 * 
		 * 用户名
		 * 
		 * 密码
		 * 
		 * mail from:<邮件地址>
		 * 
		 * rcpt to:<接收邮件地址>
		 * 
		 * data
		 * 
		 * from:<邮件地址>
		 * 
		 * subject:haha
		 * 空格
		 * aaaaaaaa
		 * .(代表结束)
		 * quit
		 */
		
	}
}
