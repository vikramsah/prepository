package com.techm.message.common.model;

import lombok.Data;

@Data
public abstract class AbsMessage {
	
	protected String messageId;
	protected String messageOwnerId;
}
