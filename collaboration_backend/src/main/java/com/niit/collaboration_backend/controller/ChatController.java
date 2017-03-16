package com.niit.collaboration_backend.controller;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
	private static final Logger log = LoggerFactory.getLogger(ChatController.class);

	@MessageMapping("/chat")
	@SendTo("/topic/message")
	public OutputMessage sendMessage(Message message)
	{
		log.debug("Calling the method sedMessage()");
		log.debug("Message id :" + message.getFid());
		System.out.println("in backend chat controller "+ message.getFid());
		log.debug("Message    : " + message.getMessage());
		
		return new  OutputMessage(message, new Date());
	}
}