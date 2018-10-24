package com.msgproject.api.services;

import java.util.Random;
import java.util.Stack;
import org.springframework.stereotype.Service;

@Service
public class MessagesServiceImpl {

	private Random rand = new Random();
	private Stack<Integer> stack = new Stack<>();

	public void add() {

		for (int i = 0; i < 10000; i++) {

			this.stack.add(rand.nextInt(10000000));
		}

	}

	public Integer remove() {

		try {

			return this.stack.pop();

		} catch (Exception e) {

			return -1;
		}
	}

	public void empty() {

		this.stack = new Stack<>();
	
	}

	public Stack all() {

		return this.stack;

	}

}
