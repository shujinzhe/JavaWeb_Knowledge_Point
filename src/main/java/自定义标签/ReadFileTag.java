package 自定义标签;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
/**
 * 标签处理类，输出文本文件内容
 * @author Eric_Junior
 * 创建时间：2017年10月5日
 */
public class ReadFileTag implements SimpleTag{
	private PageContext pageContext;
	private String src;
	public void setSrc(String src) {
		this.src = src;
	}
	
	@Override
	public void setJspContext(JspContext jspContext) {
		this.pageContext = (PageContext)jspContext;
	}
	@Override
	public void doTag() throws JspException, IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(pageContext
						.getServletContext()
						.getResourceAsStream("/WEB-INF/db.properties")));
		String tmp;
		while((tmp = br.readLine())!=null){
			/**
			 * 如果读取的文件中有<,>等特殊字符，需要替换才能在JSP页面正常显式
			 */
			pageContext.getOut().println(tmp + "<br/>");
		}
	}

	@Override
	public JspTag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setParent(JspTag arg0) {
		// TODO Auto-generated method stub
		
	}

}
