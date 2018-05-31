package com.msgproject.api.services;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.msgproject.api.entities.Message;

@Service
public class MessagesServiceImpl {

	Map<String, Message> messages = new HashMap<String, Message>();

		
	public Collection<Message> listMessages() {

		return this.messages.values();
	}

	public Message listById(String id) {

		return this.messages.get(id);
	}

	public Message register(Message message) {
		
		return this.messages.put(message.getId(), message);
	}

	public Message update(Message message) {
		
		this.messages.remove(message.getId());
		return messages.put(message.getId(), message);
	}

	public Message remove(String id) {

		return this.messages.remove(id);

	}

}
