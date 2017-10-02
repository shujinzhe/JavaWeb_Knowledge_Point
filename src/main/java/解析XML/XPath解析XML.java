package 解析XML;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
/**
 * 使用XPath简化Dom4j解析XML
 * @author Eric_Junior
 * 创建时间：2017年10月1日
 */
public class XPath解析XML {
	public static void main(String[] args) throws DocumentException {
		//加载XML文件
		Document document = XMLUtils.readXML("stu.xml");
		//根节点
		Element root = document.getRootElement();
		
		/**
		 * 	路径表达式：
		 * 	1、以"//xxx"开头的表示绝对路径下所有xxx节点，不考虑节点位置
		 *	2、以"/"开头的为绝对路径，任何节点调用，结果都一样
		 *	3、否则为相对路径
		 *	4、@区分是节点还是属性，"//@id"表示获取所有的id属性对象
		 *	5、"//xxx[@id]"表示获取所有带id属性的xxx节点
		 *	6、"//xxx[@id='002']"表示获取id等于002的xxx节点
		 *	7、"//xxx[age>20]"表示所有子节点age的值大于20的xxx节点
		 */
//		String xpath = "//student";
//		String xpath = "/students/student";
//		String xpath = "student";
//		String xpath = "//@id";
//		String xpath = "//student[@id]";
		String xpath = "//student[@id='003']";
//		String xpath = "//student[age>20]";
		//获取单个节点
		//Element ele = root.selectSingleNode(xpath)
		
		//获取多个节点
		List<Element> list = root.selectNodes(xpath);
		for(Element e: list){
			System.out.println("id=" + e.attributeValue("id")
					+ "|name=" + e.elementText("name")
					+ "|age=" + e.elementText("age"));
		}
	}
}
