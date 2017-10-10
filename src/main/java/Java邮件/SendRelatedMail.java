package Java邮件;

import java.net.URLDecoder;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 发送含有内嵌资源的邮件
 * @author Eric_Junior
 * 创建时间：2017年10月10日
 */
public class SendRelatedMail {
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
		message.setSubject("含有内嵌资源的邮件");
		message.setFrom(new InternetAddress("test01@eric.com"));
		message.addRecipients(Message.RecipientType.TO, 
				InternetAddress.parse("test02@eric.com"));

		MimeBodyPart text = new MimeBodyPart();
		text.setContent("<img src=cid:test width=500 height=600 >", "text/html");
		MimeBodyPart image = new MimeBodyPart();
		/**
		 * DataHandler为多重不同源和格式下可用的数据提供统一的接口
		 * DataSource提供任意数据集合的抽象
		 */
		String path = URLDecoder.decode(SendRelatedMail.class
				.getResource("test.jpg").getFile(),"utf-8");
		image.setDataHandler(new DataHandler(
				new FileDataSource(path)));
		//设置图片唯一标识
		image.setContentID("test");
		//含有内嵌资源时，设置子类型为related
		MimeMultipart mimeMultipart = new MimeMultipart("related");
		mimeMultipart.addBodyPart(text);
		mimeMultipart.addBodyPart(image);
		//设置邮件内容
		message.setContent(mimeMultipart);
		//设置邮件的内容和消息头一致
		message.saveChanges();
		
	}
}
