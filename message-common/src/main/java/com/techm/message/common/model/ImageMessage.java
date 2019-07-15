package com.techm.message.common.model;

import lombok.Data;

@Data
public class ImageMessage extends AbsMessage implements IMessage{
	
	private Object imageMessage;

}
