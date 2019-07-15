package com.techm.messaging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.techm.message.common.model.IMessage;

@Service
public class MessageServiceImpl implements IMessagingService {

	@Autowired
	private KafkaTemplate<String, IMessage> kafkaTemplate;

	private static final String MESSAGE_TOPIC = "messageTopic";
	@Override
	public void postMessage(IMessage message) {
		
		kafkaTemplate.send(MESSAGE_TOPIC, message);
	}

}
