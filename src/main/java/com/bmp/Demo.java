package com.bmp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FileUtils;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class Demo {

	public static void main(String[] args) throws Exception {
		//main1();
		String dateStr = "05 Sep, 2022, 08:43 ";
		dateStr = dateStr.replace(",", "");
		SimpleDateFormat formater = new SimpleDateFormat("dd MMM yyyy HH:mm");
		System.out.println("Date : "+formater.parse(dateStr));
       
		
		
		
		
		
		
		
		
		
		
		
		
		/* File file = new File("/home/bmp/Desktop/Demo-xml.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        StringBuffer buffer = new StringBuffer();
        while ((st = br.readLine()) != null)
        	buffer.append(st);
    	
		
		String responseData = buffer.toString();
		Class<?> className = Class.forName("com.bmp.EcomexpressTrack");
		Object obj =null;
		JAXBContext jc = JAXBContext.newInstance(className);
	    Unmarshaller u = jc.createUnmarshaller();
	    obj = u.unmarshal(new StreamSource(new StringReader(responseData)));
	    Gson gson = new Gson();
	    gson.toJson(obj);
	    System.out.println(gson);
	    
	    
	    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    InputSource src = new InputSource();
	    src.setCharacterStream(new StringReader(responseData));
	    //builder.parse(arg0)(src);
	    Document doc = builder.parse(src);
	    NodeList nodeList =  doc.getElementsByTagName("field");
	   // Node node nodeList.item(0);
	    
	    XPathFactory xPathfactory = XPathFactory.newInstance();
	    XPath xpath = xPathfactory.newXPath();
	    String health = (String) xpath.evaluate("//object/field/object", doc, XPathConstants.STRING);
        System.out.println(health);
        //Element typemap = getElementNode(doc, "corba:typeMapping");
	    XPathExpression expr = xpath.compile("//object/field/object");
	    NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
	    for (int i = 0; i < nodes.getLength(); i++) {
	    	NodeList ch = nodes.item(i).getChildNodes();
	    	for(int j = 0; j < ch.getLength(); j++){
	    		Node node = nodes.item(j);
	    		System.out.println("Chields --->"+node.getAttributes().getLength());
	    		System.out.println("Chields --->"+node.getAttributes().item(0));
	    		System.out.println("Chields --->"+node.getAttributes().item(1));
	    		System.out.println("Chields --->"+node.getAttributes().getNamedItem("name"));
	    		System.out.println("Chields --->"+node.getAttributes().getNamedItem("name").getNodeValue());
	    	}
	    	Node node = nodes.item(i);
	    	System.out.println(node.getAttributes().getNamedItem("name").getNodeValue());
	    	if("scans".equals(node.getAttributes().getNamedItem("name").getNodeValue())){
	    		System.out.println(node.getFirstChild().getNodeValue());
	    	}
	    }
	    
	    for (int i =0; i<nodeList.getLength() ; i++){
	    	Node node = nodeList.item(i);
	    	System.out.println(node.getAttributes().getNamedItem("name").getNodeValue());
	    	if("scans".equals(node.getAttributes().getNamedItem("name").getNodeValue())){
	    		System.out.println(node.getFirstChild().getNodeValue());
	    	}
	    	if(node.getFirstChild() != null){
	    		System.out.println(node.getFirstChild().getNodeValue());
	    	}
	    	
	    }
	    System.out.println(doc.getElementsByTagName("field.object"));*/
	}
	
	
	 public static void main1() throws Exception {

		 File xmlFile = new File("/home/bmp/Desktop/Demo-xml.txt");
		 String data = FileUtils.readFileToString(new File("/home/bmp/Desktop/Demo-xml.txt"), "UTF-8");
		 /*XmlMapper xmlMapper = new XmlMapper();
		 Object object = xmlMapper.readValue(data, Object.class);
		 JsonNode jsonNode = xmlMapper.readTree(xmlFile);
		 //JsonNode jsonNode = xmlMapper.readTree(data.getBytes());
		 ObjectMapper objectMapper = new ObjectMapper();
		 System.out.println(jsonNode);
		 String value = objectMapper.writeValueAsString(jsonNode);
         System.out.println("*** Converting XML to JSON ***");
         System.out.println(value);*/
         
         String json = XML.toJSONObject(data).toString();
         System.out.println(json);
         json = json.replace("ecomexpress-objects", "ecomexpressObjects");
         System.out.println(json);
         
         Gson gson = new Gson();
         EcomTrack e = gson.fromJson(json,EcomTrack.class);
         //EcomTrack e = objectMapper.readValue(json, EcomTrack.class);
         
         System.out.println("End"+e);
	 }

}

@XmlRootElement(name="ecomexpress-objects")
class EcomexpressTrack{
	
	private String version;
	private EcomObject object;

	@XmlAttribute
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	@XmlElement(name="object")

	//@XmlJavaTypeAdapter(CustomeAdeftar.class)
	public EcomObject getObject() {
		return object;
	}

	public void setObject(EcomObject object) {
		this.object = object;
	}
	
	static class EcomObject {
		private String pk;
		private String model;
		private Field field;
		
		@XmlAttribute(name="pk")
		public String getPk() {
			return pk;
		}
		public void setPk(String pk) {
			this.pk = pk;
		}
		@XmlAttribute(name="model")
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		
		//@XmlJavaTypeAdapter(CustomeAdapter.class)
		@XmlElement(name="field")
		public Field getField() {
			return field;
		}
		public void setField(Field field) {
			this.field = field;
		}




		static class Field {
            private String name;
            private String value;

            @XmlAttribute(name="name")
            public String getName() { return name; }
            public void setName(String value) { this.name = value; }
            
			public String getText() {
				return value;
			}
			public void setText(String value) {
				this.value = value;
			} 
        }
		
		
	}
}

/*class Field {
    private String name;
    private String value;

    @XmlAttribute(name="name")
    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
    
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	} 
}*/

class CustomeAdapter extends XmlAdapter<Object, Object>{

	@Override
	public Object marshal(Object v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object unmarshal(Object v) throws Exception {
		return null;
	}

}

/*enum Type {
    BIG_INTEGER_FIELD, CHAR_FIELD, DATE_TIME_FIELD, FLOAT_FIELD;

    public String toValue() {
        switch (this) {
            case BIG_INTEGER_FIELD: return "BigIntegerField";
            case CHAR_FIELD: return "CharField";
            case DATE_TIME_FIELD: return "DateTimeField";
            case FLOAT_FIELD: return "FloatField";
        }
        return null;
    }

    public static Type forValue(String value) throws IOException {
        if (value.equals("BigIntegerField")) return BIG_INTEGER_FIELD;
        if (value.equals("CharField")) return CHAR_FIELD;
        if (value.equals("DateTimeField")) return DATE_TIME_FIELD;
        if (value.equals("FloatField")) return FLOAT_FIELD;
        throw new IOException("Cannot deserialize Type");
    }
}*/


