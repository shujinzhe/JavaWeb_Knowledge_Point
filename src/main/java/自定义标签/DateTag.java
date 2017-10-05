package 自定义标签;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
/**
 * 标签处理类，输出当前时间
 * @author Eric_Junior
 * 创建时间：2017年10月5日
 */
public class DateTag implements SimpleTag{
	private PageContext pageContext;
	/**
	 * 第一步：JSP引擎将代表JSP页面的pageContext对象传给标签处理对象
	 * PageContext  extends JspContext
	 */
	@Override
	public void setJspContext(JspContext jspContext) {
		// TODO Auto-generated method stub
		System.out.println("调用了" + jspContext + "对象...");
		this.pageContext = (PageContext)jspContext;
	}
	/**
	 * 第二步：处理业务逻辑
	 */
	@Override
	public void doTag() throws JspException, IOException {
		pageContext.getOut().print(new Date());
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
