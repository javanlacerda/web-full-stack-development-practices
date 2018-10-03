package com.msgproject.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msgproject.api.services.MessagesServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/msgs")
public class MessageController {

	private MessagesServiceImpl service = new MessagesServiceImpl();

	@GetMapping
	public Integer listAll() {

		return service.remove();
	}

	@GetMapping(path = "/{id}")
	public void listById(@PathVariable(name = "id") String id) {

		service.add();
	}

}
