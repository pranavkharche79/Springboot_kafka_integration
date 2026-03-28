package com.consumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfiguration {
	
	@KafkaListener(topics = AppConstants.PRANAV_TOPIC_NAME, groupId = AppConstants.GROUP_ID)
	public void getMessage(String msg) {
		System.out.println(msg);
	}
	
}
