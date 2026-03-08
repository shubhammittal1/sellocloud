package com.bmp.model.app.config;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bmp.oms.service.producerConsumer.resource.WmsOrderStatusPushResource;
@Configuration
public class ProducerConsumerConfig {
	
	@Bean(name = "wmsOrderStatusPushQueue")
    public BlockingQueue<WmsOrderStatusPushResource> wmsOrderStatusPushQueue() {
        return new ArrayBlockingQueue<WmsOrderStatusPushResource>(1000);
    }

}
