package 解析XML;

import java.awt.datatransfer.Transferable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * 使用JAXP的Dom方式解析XML
 * @author Eric_Junior
 * 创建时间：2017年10月1日
 */
public class JAXP_Dom解析XML {
	public static void main(String[] args) throws Exception {
		//1、获取DocumentBuilder工厂对象
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		//2、获取DocumentBuilder对象
		DocumentBuilder builder = dbFactory.newDocumentBuilder();
		//3、使用DocumentBuilder对象的解析方法，与xml文件关联,获取关联的Document对象
		/**
		 * 注意：是org.w3c.dom.Document，不是dom4j下的Document
		 */
		Document document = (Document) builder.parse(JAXP_Dom解析XML.class
				.getClassLoader().getResource("stu.xml").getFile());
		//获取根元素的名称
		//System.out.println(document.getDocumentElement().getNodeName());
		
//		getNode(document);
		
		addStuNode(document);
		
		saveToFile(document);
	}
	

	/**
	 * 获取节点
	 * @param document
	 */
	public static void getNode(Document document){
		//获取节点列表
		NodeList list = document.getElementsByTagName("student");
		//遍历
		for(int i=0;i<list.getLength();i++){
			Element ele = (Element) list.item(i);
			if(ele!=null&&ele.getNodeType()==1){
				System.out.println(ele.getAttribute("id"));
			}
			//获取节点所有的子节点
			NodeList children = ele.getChildNodes();
			for(int j=0;j<children.getLength();j++){
				Node n = children.item(j);
				//节点类型
				//会把节点之间的空格也解析为节点
				if(n!=null&&n.getNodeType()==Node.ELEMENT_NODE){
//				if(n!=null&&n.getNodeType()==1){
					System.out.println(n.getNodeName() + "=" + n.getTextContent());
				}
			}
			System.out.println("===========================");
		}
	}
	
	/**
	 * 添加一个学生节点
	 * @param document
	 */
	private static void addStuNode(Document document) {
		// TODO Auto-generated method stub
		Element root = document.getDocumentElement();
		
		Element stu = document.createElement("student");
		stu.setAttribute("id", "005");
		
		Element name = document.createElement("name");
		name.setTextContent("eric");
		
		Element age = document.createElement("age");
		age.setTextContent("22");
		
		stu.appendChild(name);
		stu.appendChild(age);
		
		root.appendChild(stu);
		
	}
	
	
	/**
	 * 保存到文件
	 * @param document
	 * @throws Exception
	 */
	private static void saveToFile(Document document) throws Exception {
		// TODO Auto-generated method stub
		//1、获得转换器工厂
		TransformerFactory tsFactory = TransformerFactory.newInstance();
		
		//2、获得转换器
		Transformer transformer = tsFactory.newTransformer();
		
		//3、获取源
		DOMSource source = new DOMSource(document);
		
		//获取结果
		StreamResult result = new StreamResult(new OutputStreamWriter(
				new FileOutputStream("newStu.xml"),"UTF-8"));
		
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		
		transformer.transform(source, result);
		
		
		
		
	}
}
