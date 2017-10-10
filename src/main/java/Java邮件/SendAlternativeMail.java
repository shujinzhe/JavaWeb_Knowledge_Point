package Java邮件;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 发送超文本邮件
 * @author Eric_Junior
 * 创建时间：2017年10月10日
 */
public class SendAlternativeMail {
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
		setMessage(message);
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

	private static void setMessage(Message message) throws Exception {
		message.setSubject("含有超文本的邮件");
		message.setFrom(new InternetAddress("test01@eric.com"));
		message.addRecipients(Message.RecipientType.TO, 
				InternetAddress.parse("test02@eric.com"));
		//MimeBodyPart类表示邮件的一个MIME消息
		MimeBodyPart text = new MimeBodyPart();
		text.setContent("<h1>AAAAA</h1>","text/html");
		//一个或多个MimeBodyPart构成一个MimeMultiPart
		//alternative子类型表示超文本(默认为mixed)
		MimeMultipart mimeMultipart = new MimeMultipart("alternative");
		mimeMultipart.addBodyPart(text);
		//设置邮件内容
		message.setContent(mimeMultipart);
		//设置邮件的内容和消息头一致
		message.saveChanges();
		
	}
}
