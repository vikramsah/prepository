package com.techm.messaging.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techm.message.common.model.TextMessage;
import com.techm.messaging.service.IMessagingService;

@RestController
@RequestMapping("/messaging/")
public class MessagingController {
	@Autowired
	IMessagingService messageService;

	@SuppressWarnings("rawtypes")
	@RequestMapping(path = "/message", method = RequestMethod.POST)
	public ResponseEntity postTextMessage(@RequestBody TextMessage message) {
		 messageService.postMessage(message);
		 return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
		
	}

}
