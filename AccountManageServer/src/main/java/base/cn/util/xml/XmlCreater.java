package base.cn.util.xml;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XmlCreater extends XmlManager {

	public XmlCreater(){
		this.doc=DocumentHelper.createDocument();
	}
	
	public XmlCreater(String coding){
		this();
		this.doc.setXMLEncoding(coding);
	}
	
	public XmlCreater(String coding,String rootName){
		this(coding);
		super.addRootNode(rootName);
	}
	
	public static void main(String []args){
		XmlCreater xcu = new XmlCreater("utf-8","root");
		xcu.addNodeFromRoot("head");
		xcu.addNodeFromRoot("body", "你好");
		System.out.println(xcu.getXmlString());
		
		XmlCreater x1 = new XmlCreater("utf-8");
		x1.addRootNode("root");
		Element rootEle = x1.getElementFormPath("root");
		x1.addNodeAttribute(rootEle, "id", "1");
		x1.addNodeAttribute(rootEle, "name", "1");
		x1.addNodeFromRoot("msg", "消息一");
		x1.addNodeFromRoot("msg", "消息二");
		System.out.println(x1.getXmlString());
		System.out.println(x1.getNodeAttribute(rootEle, "id"));
	}
}
