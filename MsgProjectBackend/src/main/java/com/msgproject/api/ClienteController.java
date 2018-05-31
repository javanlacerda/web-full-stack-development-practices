package com.msgproject.api;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/msgs")
public class ClienteController {

	private MessagesServiceImpl service = new MessagesServiceImpl();
	private int idControll = 1;
	private final String credential = "javan:javan123";

	final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	final CorsConfiguration config = new CorsConfiguration();

	@GetMapping
	public Collection<Message> listAll() {

		return service.listMessages();
	}

	@GetMapping(path = "/{id}")
	public Message listarPorId(@PathVariable(name = "id") String id) {

		return service.listarPorId(id);
	}

	@PostMapping
	public Message cadastrar(@Valid @RequestBody Message msg) {

		try {
			if (msg.getCredentials().equals(this.credential)) {
				String id = "" + this.idControll++;
				msg.setId(id);
				msg.setFrontend(msg.getCredentials().split(":")[0]);
				return service.cadastrar(msg);
			} else {
				throw new IllegalArgumentException("Wrong credentials!");
			}
		} catch (IllegalArgumentException e) {

			return null;
		}

	}

	@PutMapping
	public Message atualizar(@Valid @RequestBody Message msg) {

		try {
			if (msg.getCredentials().equals(this.credential)) {
				String id = "" + this.idControll++;
				msg.setId(id);
				msg.setFrontend(msg.getCredentials().split(":")[0]);
				return service.cadastrar(msg);
			} else {
				throw new IllegalArgumentException("Wrong credentials!");
			}
		} catch (IllegalArgumentException e) {

			return null;
		}

	}

	@DeleteMapping(path = "/{id}")
	public Message remover(@PathVariable(name = "id") String id) {

		return service.remove(id);

	}

}
