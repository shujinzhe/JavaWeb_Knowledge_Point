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
 * 标签处理类，找出最大值
 * @author Eric_Junior
 * 创建时间：2017年10月5日
 */
public class MaxValueTag implements SimpleTag{
	private Integer num1;
	private Integer num2;
	public void setNum1(Integer num1) {
		this.num1 = num1;
	}
	public void setNum2(Integer num2) {
		this.num2 = num2;
	}

	private PageContext pageContext;
	@Override
	public void setJspContext(JspContext jspContext) {
		// TODO Auto-generated method stub
		this.pageContext = (PageContext)jspContext;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		if(num1<num2){
			pageContext.getOut().print(num2);
		}else{
			pageContext.getOut().print(num1);
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
