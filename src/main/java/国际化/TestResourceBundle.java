package 国际化;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 实现国际化的关键
 * @author Eric_Junior
 * 创建时间：2017年10月9日
 */
public class TestResourceBundle {
	public static void main(String[] args) {
		/**
		 * 第一个参数：资源文件基名
		 * 第二个参数：区域
		 */
		ResourceBundle rb = ResourceBundle.getBundle
				("myresource", Locale.US);
		System.out.println(rb.getString("name"));
		
		/**
		 * JSP页面中可以使用JSTL的国际化标签库
		 * Strut2中可以更方便的使用i18n
		 */
	}
}
