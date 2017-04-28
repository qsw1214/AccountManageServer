package base.cn.util.xml;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

public abstract class XmlManager {

	protected Document doc;
	protected Element root;
	
	protected void initRootFromDoc(){
		root = doc.getRootElement();
	}
	
	/**
	 * 添加根节点
	 * */
	public Element addRootNode(String name){
		return this.root=this.doc.addElement(name);
	}
	
	/**
	 *  添加根节点的child
	 * 
	 *  @param  nodeName 节点名
	 */ 
	public Element addNodeFromRoot(String nodeName){
	    return root.addElement(nodeName);
	}
	
	/**
	 *  添加根节点的child
	 * 
	 *  @param  nodeName 节点名
	 *  @param  nodeValue 节点值
	 */ 
	public Element addNodeFromRoot(String nodeName, String nodeValue){
        Element node = root.addElement(nodeName);
	    node.addText(nodeValue);
	    return node;
	}
	
	/**
	 *  添加某个节点的child
	 * 
	 *  @param  nodeChildName 子节点名
	 *  @param  nodeChildValue 子节点值
	 */ 
	public Element addChildFromNode(Element node,String nodeChildName, String nodeChildValue){
        Element nodeChild=node.addElement(nodeChildName);
        nodeChild.addText(nodeChildValue);
        return nodeChild;
	}
	
	/**
	 *  添加某个节点的child
	 * 
	 *  @param  nodeChildName 子节点名
	 *  @param  nodeChildValue 子节点值
	 */ 
	public Element addChildFromNode(Element node,String nodeChildName){
		return node.addElement(nodeChildName); 
	}
	
	/**
	 *  添加某个节点的属性
	 * 
	 *  @param  attributeName 属性名名
	 *  @param  attributeValue 属性值
	 */ 
	public void addNodeAttribute(Element node,String attributeName, String attributeValue){
		node.addAttribute(attributeName, attributeValue);
	}
	
	/**
	 *  获得某个节点的属性值
	 * 
	 *  @param  attributeName 属性名名
	 */ 
	public String getNodeAttribute(Element node,String attributeName){
		Attribute attribute=node.attribute(attributeName);
		return attribute.getValue();
	}
	
	/**
	 *  设置某个节点的text
	 * 
	 *  @param  nodeName 节点名
	 *  @param  nodeValue 节点值
	 */ 
	public void setElementValue(String nodeName, String nodeValue)   {
		Node node  =   this.doc.selectSingleNode( "/"   +  nodeName);
		node.setText(nodeValue);
	} 
	
	/** 
	 *  获得某个节点的值
	 * 
	 *  @param  nodeName 节点名称
	 */ 
	public String getElementValue(String nodeName)   {
		Node node  =  this.doc.selectSingleNode( "/"   +  nodeName);
		return  node.getText(); 
	} 
	
	/**
	 *  设置一个子节点值
	 * 
	 *  @param  nodeName 父节点名
	 *  @param  childNodeName 子节点名
	 *  @param  childNodeValue 子节点值
	 */ 
	public void setElementValue(String nodeName, String childNodeName,String childNodeValue)   {
		Node childNode  =   this.doc.selectSingleNode( "/"   +  nodeName  +   "/" +  childNodeName);
		childNode.setText(childNodeValue);
	} 
	
	/**
	 *  获得某个节点的子节点的值
	 * 
	 *  @param  nodeName
	 *  @param  childNodeName
	 *  @return 
	 */ 
	public String getElementValue(String nodeName, String childNodeName)   {
		Node node  =   this.doc.selectSingleNode( "/"   +  nodeName  +   "/" +  childNodeName);
		return  node.getText(); 
	} 
	
	/**
	 *  获得某个节点
	 * 
	 *  @param  nodeName
	 *  @param  childNodeName
	 *  @return 
	 */ 
	public Element getElementFormPath(String xPath)   {
		return (Element)this.doc.selectSingleNode(xPath); 
	} 
	
	/**
	 *  获得某个节点下的子节点列表
	 * 
	 *  @param  nodeName
	 *  @param  childNodeName
	 *  @return 
	 */ 
	public List getElementListFormPath(String xPath)   {
		return this.doc.selectNodes(xPath);
	} 
	
	/**
	 * 返回xml字符串
	 * */
	public String getXmlString(){
		return this.doc.asXML();
	}
}
