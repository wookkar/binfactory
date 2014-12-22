package com.coupang.beanfactory;

import java.io.*;
import java.util.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.*;

public class XmlFileBeanDefinitionLoader extends BeanDefinitionLoader {

	public XmlFileBeanDefinitionLoader(String filePath) {
		super(filePath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BeanDefinition> beanDifinitionFileLoaders(InputStream inputStream){
		
		List<BeanDefinition> addDefinitions = new ArrayList<BeanDefinition>();
		
		DocumentBuilderFactory factory = null;
	    DocumentBuilder builder = null;
	    Document ret = null;

	    try {
	      factory = DocumentBuilderFactory.newInstance();
	      builder = factory.newDocumentBuilder();
	    } catch (ParserConfigurationException e) {
	      e.printStackTrace();
	    }

	    try {
	      ret = builder.parse(new InputSource(inputStream));
	    } catch (SAXException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    
	    for(int i = 0; i < ret.getElementsByTagName("bean").getLength(); i++){
	    	Node node = ret.getElementsByTagName("bean").item(i);
	    	addDefinitions.add(new BeanDefinition(node.getAttributes().getNamedItem("name").getTextContent(), 
	    			node.getAttributes().getNamedItem("class").getTextContent(), 
	    			node.getAttributes().getNamedItem("scope").getTextContent()));
	    }
	    
		return addDefinitions;

	}
}
