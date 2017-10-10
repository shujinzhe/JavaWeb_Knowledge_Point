package Java邮件;

import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.URLDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * 发送含有附件的邮件
 * @author Eric_Junior
 * 创建时间：2017年10月10日
 */
public class SendMixedMail {
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

	@SuppressWarnings("deprecation")
	private static void setMessage(Message message) throws Exception {
		message.setSubject("含有附件的邮件");
		message.setFrom(new InternetAddress("test01@eric.com"));
		message.addRecipients(Message.RecipientType.TO, 
				InternetAddress.parse("test02@eric.com"));
		//文本
		MimeBodyPart text = new MimeBodyPart();
		/**
		 * 处理setContent文本信息的乱码问题
		 * 指定"text/html;charset=utf-8"
		 */
		text.setContent("<h1>包含附件，请点击下载</h1>", "text/html;charset=utf-8");
		//附件
		MimeBodyPart attach = new MimeBodyPart();
		
		/*String path = URLDecoder.decode(SendMixedMail.class
				.getResource("mail-1.4.1.jar").getFile(),"utf-8");
		attach.setDataHandler(new DataHandler(
				new FileDataSource(path)));*/
		
		attach.setDataHandler(new DataHandler(
				new URLDataSource(SendMixedMail.class
						.getResource("mail-1.4.1.jar"))));
		//处理附件名称的中文乱码问题
		String fileName = MimeUtility.encodeText("邮件.jar",
				MimeUtility.mimeCharset("UTF-8"),null);
		//设置下载的名字
		attach.setFileName(fileName);
		//含有内嵌资源时，设置子类型为related
		MimeMultipart mimeMultipart = new MimeMultipart("mixed");
		mimeMultipart.addBodyPart(text);
		mimeMultipart.addBodyPart(attach);
		//设置邮件内容
		message.setContent(mimeMultipart);
		//设置邮件的内容和消息头一致
		message.saveChanges();
		
		/**
		 * 也可以将邮件保存到本地
		 */
//		FileOutputStream fos = new FileOutputStream("D:/1.eml");
//		message.writeTo(fos);
//		fos.close();
	}
}
