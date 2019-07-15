package com.techm.messaging;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.techm.message.common.model.IMessage;
import com.techm.messaging.dao.IUserManagementDAO;
import com.techm.messaging.dao.UserManagementDAOImpl;
import com.techm.messaging.service.IMessagingService;
import com.techm.messaging.service.IUserManagementService;
import com.techm.messaging.service.MessageServiceImpl;
import com.techm.messaging.service.UserManagementServiceImpl;

@SpringBootApplication
public class MessagingApplication {
	
	@Value("${kafka.bootstrap-servers}")
	private String bootstrapServers;

	public static void main(String[] args) {
		SpringApplication.run(MessagingApplication.class, args);
	}
	
	
	@Bean
	public IUserManagementService userManagementService() {
		return new UserManagementServiceImpl();
	}
	
	@Bean 
	public IUserManagementDAO userRegistrationDAO() {
		return new UserManagementDAOImpl();
	}
	
	@Bean 
	public IMessagingService messageService() {
		return new MessageServiceImpl();
	}
	
	public Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<>();
	    // list of host:port pairs used for establishing the initial connections to the Kakfa cluster
	    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
	        bootstrapServers);
	    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	        StringSerializer.class);
	    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
	        JsonSerializer.class);
	    return props;
	}
	
	@Bean
	public ProducerFactory<String, IMessage> producerFactory() {
	  return new DefaultKafkaProducerFactory<>(producerConfigs());
	}
	
	@Bean
	public KafkaTemplate<String, IMessage> kafkaTemplate() {
	  return new KafkaTemplate<>(producerFactory());
	}

}
