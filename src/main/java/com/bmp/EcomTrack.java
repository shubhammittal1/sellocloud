package com.bmp;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EcomTrack {
	public EcomexpressObjects ecomexpressObjects;
	
	
	public EcomexpressObjects getEcomexpressObjects() {
		return ecomexpressObjects;
	}

	public void setEcomexpressObjects(EcomexpressObjects ecomexpressObjects) {
		this.ecomexpressObjects = ecomexpressObjects;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class EcomexpressObjects{
	    public int version;
	    public EcomObject object;
		public int getVersion() {
			return version;
		}
		public void setVersion(int version) {
			this.version = version;
		}
		public EcomObject getObject() {
			return object;
		}
		public void setObject(EcomObject object) {
			this.object = object;
		}
	    
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class EcomObject{
	    public ArrayList<Field> field;
	    public String model;
	    public int pk;
		public ArrayList<Field> getField() {
			return field;
		}
		public void setField(ArrayList<Field> field) {
			this.field = field;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public int getPk() {
			return pk;
		}
		public void setPk(int pk) {
			this.pk = pk;
		}
	    
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Field{
	    public String name;
	    public String type;
	    public String content;
	    public ArrayList<EcomObject> object;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Object getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public ArrayList<EcomObject> getObject() {
			return object;
		}
		public void setObject(ArrayList<EcomObject> object) {
			this.object = object;
		}
	    
	}

}

