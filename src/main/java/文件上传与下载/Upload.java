package 文件上传与下载;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
 * 文件上传
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class Upload extends HttpServlet{

	//允许上传的文件类型
	String[] allowedExt = new String[]{"doc","jpeg","jpg"};
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		/**
		 * 请求类型是enctype="multipart/form-data"
		 */
		if(isMultipart){
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Configure a repository (to ensure a secure temp location is used)
			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			//设置溢写到磁盘临时目录
			factory.setRepository(repository);
			//缓冲区的大小，超过该大小会溢写到磁盘，单位为字节
			factory.setSizeThreshold(1024);

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// Parse the request
			List<FileItem> items = null;
			try {
				//限制上传文件大小
				//超出文件大小进行异常处理
				upload.setSizeMax(1024*1024*1024);
				//解析request对象
				items = upload.parseRequest(req);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
			    FileItem item = iter.next();
			    //表单域
			    if (item.isFormField()) {
			    	// Process a regular form field
			    	if (item.isFormField()) {
			    	    String name = item.getFieldName();
			    	    String value = item.getString("UTF-8");
			    	    System.out.println("item.isFormField() " + name + "   " + value);
			    	}
			    } else {
			    	//文件域
			    	// Process a file upload
			    	if (!item.isFormField()) {
			    	    String fieldName = item.getFieldName();
			    	    String fileName = item.getName();
			    	    String contentType = item.getContentType();
			    	    boolean isInMemory = item.isInMemory();
			    	    long sizeInBytes = item.getSize();
			    	    System.out.println("!item.isFormField() " + fieldName + "   " + fileName);
			    	    System.out.println("文件类型：" + contentType);
			    	    System.out.println("文件大小：" + sizeInBytes);
			    	    
			    	    //获取真实路径
			    	    String realPath = this.getServletContext().getRealPath("/pic");
			    	    File uploadedFile = new File(realPath + "/" + fileName);
			    	    boolean isValidFile = Arrays.asList(allowedExt).contains(fileName.split("\\.")[1]);
			    	    try {
			    	    	if(isValidFile){
			    	    		//写入文件
								item.write(uploadedFile);
			    	    	}else{
			    	    		throw new RuntimeException("不支持该文件类型：" + fileName.split("\\.")[1]);
			    	    	}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	}
			    	
		    	    
			    }
			}
		}
		
	}

}
