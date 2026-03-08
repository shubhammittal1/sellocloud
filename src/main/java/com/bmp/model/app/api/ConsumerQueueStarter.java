package com.bmp.model.app.api;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ConsumerQueueStarter {

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void startConsumers() {
        for (int i = 0; i < 3; i++) {
            TrackingConsumer consumer =
                applicationContext.getBean(TrackingConsumer.class);

            new Thread(consumer, "tracking-consumer-" + i).start();
        }
    }
}



