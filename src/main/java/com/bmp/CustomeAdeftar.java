package com.bmp;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.w3c.dom.Node;



public class CustomeAdeftar extends XmlAdapter<Object, Object>{

	@Override
	public Object marshal(Object v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object unmarshal(Object v) throws Exception {
		Node node = (Node) v;
		System.out.println(node.getAttributes().getNamedItem("name").getNodeValue());
		System.out.println("Hello ....."+node.getFirstChild().getNodeValue());
		
		return null;
	}

}
