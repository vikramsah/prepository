package com.techm.receiver.messagereceiver;

import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.techm.message.common.model.TextMessage;
import ch.qos.logback.classic.Logger;

@Service
public class ProcessMessage {
	private final Logger logger = (Logger) LoggerFactory.getLogger(ProcessMessage.class);
	private static final String TOPIC_JSON = "messageTopic";
	
	@KafkaListener(topics = TOPIC_JSON, groupId = "group_json", containerFactory="messageKafkaListenerContainerFactory" )
    public void consumeJson(TextMessage message) throws IOException {
        logger.info(String.format("#### -> Consumed Json message -> %s", message));
    }

}
