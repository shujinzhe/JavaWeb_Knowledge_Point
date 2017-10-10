package Java邮件;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 发送简单文本邮件
 * @author Eric_Junior
 * 创建时间：2017年10月10日
 */
public class SendSimpleMail {
	public static void main(String[] args) throws Exception {
		/**
		 * 1、设置邮件环境(Session类用于定义整个应用程序所需的环境)
		 */
		Properties props = new Properties();
		//设置发送邮件的协议
		props.setProperty("mail.transport.protocol", "smtp");
		//设置SMTP邮件服务器的地址
		props.setProperty("mail.host", "127.0.0.1");
		//设置连接到服务器使用的登录方式
		props.setProperty("mail.smtp.auth", "true");
		//获取Session对象
		Session session = Session.getInstance(props);
		//true表示输出调试信息
		session.setDebug(true);
		
		/**
		 * 2、利用环境信息创建邮件
		 */
		Message message = new MimeMessage(session);
		//设置邮件主题
		message.setSubject("hello world");
		//设置邮件发件人
		message.setFrom(new InternetAddress("test01@eric.com"));
		/**
		 * 设置邮件收件人
		 * BCC:暗送(假设发给A和B，但A不知道也发给了B)
		 * CC:抄送
		 * TO:发送
		 */
		message.addRecipients(Message.RecipientType.TO, 
				new Address[]{new InternetAddress("test02@eric.com")});
		//设置邮件内容
		message.setText("This is my first E-Mail...");
		/**
		 * 3、发送邮件
		 * Transport是发送邮件的核心API类
		 */
		Transport transport = session.getTransport();
		//设置连接
		transport.connect("test01", "123456");
		//发送邮件
		transport.sendMessage(message, message.getAllRecipients());
		//关闭资源
		transport.close();
	}
}
