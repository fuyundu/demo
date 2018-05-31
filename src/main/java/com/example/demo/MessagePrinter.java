package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
	private MessageService service;

    @Autowired
    public MessagePrinter(MessageService service) {
        this.service = service;
    }
    public void hello() {
    	service.hello();
    }
}