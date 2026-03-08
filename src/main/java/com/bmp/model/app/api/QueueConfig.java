package com.bmp.model.app.api;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class QueueConfig {
	
	@Bean(name = "trackingQueue")
    public BlockingQueue<String> trackingQueue() {
        return new ArrayBlockingQueue<String>(1000);
    }
}
