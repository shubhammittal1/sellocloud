package com.bmp.mail.model;

import java.util.List;

import com.bmp.model.app.utility.AlertMaster;

public class CommonMailDTO {
    
	private AlertMaster alertMaster;
	private List<Object> data;
	private String[] mailTo;
	private String[] mailcc;
    private String mailFrom;
    private String subject;
    private String mailBody;
    private String[] attachmentPath;
    private boolean realtimeAlert;

    public CommonMailDTO() {
		super();
	}
	public AlertMaster getAlertMaster() {
		return alertMaster;
	}

	public void setAlertMaster(AlertMaster alertMaster) {
		this.alertMaster = alertMaster;
	}
	
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	public String[] getMailTo() {
		return mailTo;
	}
	public void setMailTo(String[] mailTo) {
		this.mailTo = mailTo;
	}
	public String[] getMailcc() {
		return mailcc;
	}
	public void setMailcc(String[] mailcc) {
		this.mailcc = mailcc;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMailBody() {
		return mailBody;
	}
	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}
	public String[] getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String[] attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public String getMailFrom() {
        return mailFrom;
    }
    public void setMailFrom(final String mailFrom) {
        this.mailFrom = mailFrom;
    }
    
	public boolean isRealtimeAlert() {
		return realtimeAlert;
	}
	public void setRealtimeAlert(boolean realtimeAlert) {
		this.realtimeAlert = realtimeAlert;
	}
    
}