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
 * 标签处理类，循环输出值
 * @author Eric_Junior
 * 创建时间：2017年10月5日
 */
public class CircleTag implements SimpleTag{
	private Integer begin;
	private Integer end;
	private Integer step;
	

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public void setStep(Integer step) {
		this.step = step;
	}


	private PageContext pageContext;
	@Override
	public void setJspContext(JspContext jspContext) {
		// TODO Auto-generated method stub
		this.pageContext = (PageContext)jspContext;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		for(int i = begin;i<end;i+=step){
			pageContext.getOut().print(i + " ");
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
