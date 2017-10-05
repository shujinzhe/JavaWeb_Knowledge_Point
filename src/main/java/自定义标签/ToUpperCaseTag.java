package 自定义标签;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Locale;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
/**
 * 标签处理类，字符串转换成大写
 * @author Eric_Junior
 * 创建时间：2017年10月5日
 */
public class ToUpperCaseTag implements SimpleTag{
	private PageContext pageContext;
	private JspFragment jspFragment;
	
	@Override
	public void setJspContext(JspContext jspContext) {
		this.pageContext = (PageContext)jspContext;
	}
	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter();
		this.jspFragment.invoke(sw);
		String result = sw.toString().toUpperCase();
		pageContext.getOut().print(result);
	}

	@Override
	public JspTag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 存在标签体，JSP引擎将把标签体封装成一个JSPFragment对象
	 * 并传给标签处理器对象
	 */
	@Override
	public void setJspBody(JspFragment jspFragment) {
		this.jspFragment = jspFragment;
	}


	@Override
	public void setParent(JspTag arg0) {
		// TODO Auto-generated method stub
		
	}

}
