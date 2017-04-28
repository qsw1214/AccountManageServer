package base.cn.util.xml;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlPaser extends XmlManager{
	
	public XmlPaser(File xmlFile) throws Exception{
		doc = new SAXReader().read(xmlFile);
		initRootFromDoc();
	}

	public XmlPaser(String xmlString)throws Exception{
		doc = DocumentHelper.parseText(xmlString);
		initRootFromDoc();
	}
	
	public XmlPaser(InputStream inputStream) throws Exception{
		doc = new SAXReader().read(inputStream);
		initRootFromDoc();
	}
	
	public static void main(String []args) throws Exception{
		String string = "<r><a id=\"1\"><a1>a1</a1><a1>a2</a1></a><b id=\"2\"></b></r>";
		XmlPaser xp = new XmlPaser(string);
		Element headElement=xp.getElementFormPath("/r/a");
		String id=xp.getNodeAttribute(headElement, "id");
		List list = xp.getElementListFormPath("/r/a");
		for(int i = 0; i < list.size(); i ++){
			Element element = (Element)list.get(i);
			System.out.println(element.attributeValue("id") + ";" + element.getText());
		}
	}
}
