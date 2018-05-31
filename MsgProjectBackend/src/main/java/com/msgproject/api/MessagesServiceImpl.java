package com.msgproject.api;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MessagesServiceImpl {

	Map<String, Message> messages = new HashMap<String, Message>();

		
	public Collection<Message> listMessages() {

		return this.messages.values();
	}

	public Message listarPorId(String id) {

		return this.messages.get(id);
	}

	public Message cadastrar(Message cliente) {
		
		
		return this.messages.put(cliente.getId(), cliente);
	}

	public Message atualizar(Message cliente) {
		
		this.messages.remove(cliente.getId());
		return messages.put(cliente.getId(), cliente);
	}

	public Message remove(String id) {

		return this.messages.remove(id);

	}

}
