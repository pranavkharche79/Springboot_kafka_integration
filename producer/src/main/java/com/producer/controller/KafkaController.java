package com.producer.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producer.service.KafkaService;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
	
	@Autowired
	private KafkaService kafkaService;
	
	@PostMapping("/message")
	public ResponseEntity<?> sendMessages() {
		for (int i = 1; i <= 500000; i++) {    // Producing 5 Lakh Messages
			kafkaService.sendMessage("Message number is "+i);
		}
		return new ResponseEntity<>(Map.of("message","messages are send"),HttpStatus.OK);
	}
	
}
