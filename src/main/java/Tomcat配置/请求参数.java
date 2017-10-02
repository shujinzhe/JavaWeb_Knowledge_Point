package Tomcat配置;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 获取一次Http请求的参数信息
 * @author Eric_Junior
 * 创建时间：2017年10月2日
 */
public class 请求参数 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(9000);
		Socket s = ss.accept();
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		s.close();
		ss.close();
	}
	
	//访问http://localhost:9000的请求参数：
	
//	  	GET / HTTP/1.1
//		Host: localhost:9000
//		Connection: keep-alive
//		Cache-Control: max-age=0
//		User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.79 Safari/537.36
//		Upgrade-Insecure-Requests: 1
//		Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
//		Accept-Encoding: gzip, deflate, br
//		Accept-Language: zh-CN,en;q=0.8,zh;q=0.6
	 

}
