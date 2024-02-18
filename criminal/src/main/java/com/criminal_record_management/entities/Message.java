package com.criminal_record_management.entities;

public class Message {
	public String content;
	public String Type;
	public String cssClass;
	public Message(String content, String type, String cssClass) {
		super();
		this.content = content;
		Type = type;
		this.cssClass = cssClass;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	
	

}
