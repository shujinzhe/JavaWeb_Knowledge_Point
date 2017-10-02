package 解析XML;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;


/**
 * 使用JAXP的SAX(Simple API for XML)方式解析XML
 * @author Eric_Junior
 * 创建时间：2017年10月1日
 */

/**
 * SAX通常用于读取，不进行增删改
 * 基于事件驱动的
 */
public class JAXP_SAX解析XML {
	public static void main(String[] args) throws Exception {
		//1、获取SAXParserFactory工厂对象
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		//2、获取SAXParser对象
		SAXParser sax = saxFactory.newSAXParser();
		
//		parse1(sax);
		parse2(sax);
	}

	/**
	 * 继承DefaultHandler的方式
	 * 实现：打印XML中所有name标签的值
	 * @param sax
	 * @throws Exception 
	 */
	private static void parse2(SAXParser sax) throws Exception {
		// TODO Auto-generated method stub
		//3、使SAXParser对象与xml文件关联,并传入一个事件处理器
		InputStream in = JAXP_SAX解析XML.class
				.getClassLoader().getResourceAsStream("stu.xml");
		sax.parse(in, new MyDefaultHandler());
	}

	/**
	 * 使用XMLReader解析
	 * @param sax
	 * @throws Exception 
	 */
	private static void parse1(SAXParser sax) throws Exception {
		// TODO Auto-generated method stub
		//3、使SAXParser对象与xml文件关联,并传入一个事件处理器
		InputStream in = JAXP_SAX解析XML.class
				.getClassLoader().getResourceAsStream("stu.xml");
		//XML读取器
		XMLReader reader = sax.getXMLReader();
		//注册事件处理器
		reader.setContentHandler(new MyHandler());
		reader.parse(new InputSource(in));
	}
	
}


class MyDefaultHandler extends DefaultHandler{
	//保存开始的name标签
	private String name;
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if("name".equals(qName)){
			this.name = qName;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if("name".equals(this.name)){
			System.out.println(new String(ch,start,length));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if("name".equals(qName)){
			this.name = null;
		}
	}
	
}


class MyHandler implements ContentHandler{

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("startDocument...A");
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("endDocument...D");
	}

	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("startElement..B");
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("endElement...C");
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("characters---");
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processingInstruction(String target, String data)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		
	}
	
}
