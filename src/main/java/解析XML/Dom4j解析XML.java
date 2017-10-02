package 解析XML;

import java.net.URL;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 使用Dom4j解析XML
 * @author Eric_Junior
 * 创建时间：2017年10月1日
 */
public class Dom4j解析XML {
	public static void main(String[] args) throws DocumentException {
		//1、dom4j中读取xml文档的对象
		SAXReader reader = new SAXReader();
		//2、maven工程下加载resources下的文件
		URL url = Dom4j解析XML.class.getClassLoader().getResource("stu.xml");
		Document document = reader.read(url.getFile());
		//3、获取根元素节点对象
		Element root = document.getRootElement();
		//4、通过根元素对象操作文档中的内容
		
		getStuInfos(document);
		
//		addStuInfos(document);
		
//		deleteStuInfos(document);
		
		
	}


	/**
	 * 遍历，获取所有学生信息
	 * @param document
	 */
	private static void getStuInfos(Document document) {
		// TODO Auto-generated method stub
		Element root = document.getRootElement();
		//迭代器方式
		//Iterator<Element> it = root.elementIterator("student");
		List<Element> stus = root.elements("student");
		for(Element e : stus){
			System.out.println("id=" + e.attributeValue("id")
					+ "|name=" + e.elementText("name")
					+ "|age=" + e.elementText("age"));
		}
	}
	
	
	/**
	 * 添加节点与属性
	 * @param document
	 */
	private static void addStuInfos(Document document) {
		// TODO Auto-generated method stub
		Element root = document.getRootElement();
		//添加一个student节点
		//id=005
		//name=eric
		//age=25
		Element stu = root.addElement("student").addAttribute("id", "005");
		stu.addElement("name").addText("eric");
		stu.addElement("age").addText("25");
		//此时的操作修改的是内存中的xml文件
		//以XML字符串的形式打印
		System.out.println(document.asXML());
	}
	

	/**
	 * 删除节点，删除属性
	 * @param document
	 */
	private static void deleteStuInfos(Document document) {
		// TODO Auto-generated method stub
		Element root = document.getRootElement();
		//删除第一个学生的id属性
		Element stu1 = (Element) root.elements("student").get(0);
		stu1.remove(stu1.attribute("id"));
		System.out.println(document.asXML());
		
		System.out.println("===========分隔线============");
		//删除第一个学生信息
		//父节点调用remove方法
		root.remove(stu1);
		System.out.println(document.asXML());
	}
	
	
}
