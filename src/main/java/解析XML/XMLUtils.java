package 解析XML;

import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * 工具类，加载maven工程的xml文件，返回Document对象
 * @author Eric_Junior
 * 创建时间：2017年10月1日
 */
public class XMLUtils {
	public static Document readXML(String fileName) throws DocumentException{
		//1、dom4j中读取xml文档的对象
		SAXReader reader = new SAXReader();
		//2、maven工程下加载resources下的文件
		URL url = Dom4j解析XML.class.getClassLoader().getResource(fileName);
		Document document = reader.read(url.getFile());
		return document;
	}
}
