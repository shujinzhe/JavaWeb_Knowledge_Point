package 文件上传与下载;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 文件下载
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class Download extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//设置响应的类型
		resp.setContentType("application/x-msdownload");
		//浏览器不直接处理相应的实体内容，而是由用户选择将相应的实体内容保存到一个文件中
		//attachment表示要求用户干预
		//filename建议下载的文件名
		//必须在setContentType之后
		//中文名需要使用URLEncoder编码
		resp.setHeader("Content-Disposition", "attachment;filename="+
				URLEncoder.encode("赵丽颖","utf-8")+".jpg");
		
		String realPath = this.getServletContext()
				.getRealPath("/pic/赵丽颖.jpg");
		FileInputStream in = new FileInputStream(realPath);
		BufferedInputStream bis = new BufferedInputStream(in);
		
		//响应对象中获取输出流
		OutputStream out = resp.getOutputStream();
		BufferedOutputStream bout = new BufferedOutputStream(out);
		
		byte[] buf = new byte[100*1024];
		int len = 0;
		while((len = bis.read(buf))!=-1){
			bout.write(buf,0,len);
		}
		bout.close();
		bis.close();
	}

}
