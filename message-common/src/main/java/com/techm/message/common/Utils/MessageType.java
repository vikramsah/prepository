package com.techm.message.common.Utils;

public enum MessageType {
	TEXT("TEXT"),
	IMAGE("IMAGE"),
	VIDEO("VIDEO");
	
	private final String messageType; 
	private MessageType (String messageType) {
		this.messageType = messageType;
	}
	
	public String getMessageType() {
		return this.messageType;
	}
}
