package com.bmp.model.app.bulk;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;

@Document(collection="bulkValidation")
@AssignKey(assvalue=false)
public class BulkValidation extends MongoBaseBean{

	private static final long serialVersionUID = -780097633735445272L;
	
	private String className;
	private String methodName;
	private String message;
	private Boolean insertCheck;
	private Boolean updateCheck;
	private Boolean deleteCheck;
	
	public BulkValidation() {
		super();
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getMethodName() {
		return methodName;
	}
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Boolean isInsertCheck() {
		return insertCheck;
	}
	
	public void setInsertCheck(Boolean insertCheck) {
		this.insertCheck = insertCheck;
	}
	
	public Boolean isUpdateCheck() {
		return updateCheck;
	}
	
	public void setUpdateCheck(Boolean updateCheck) {
		this.updateCheck = updateCheck;
	}
	
	public Boolean isDeleteCheck() {
		return deleteCheck;
	}
	
	public void setDeleteCheck(Boolean deleteCheck) {
		this.deleteCheck = deleteCheck;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}