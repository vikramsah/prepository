package com.techm.message.common.model;

import lombok.Data;

@Data
public class TextMessage extends AbsMessage implements IMessage {
	
	private String message;

	

}
