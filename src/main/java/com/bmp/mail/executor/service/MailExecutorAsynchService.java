package com.bmp.mail.executor.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.bmp.mail.model.CommonMailDTO;
import com.bmp.mail.server.MailServer;

@Service
@Scope("singleton")
@Qualifier("mailExecutorAsynchService")
public class MailExecutorAsynchService {
	
	@Qualifier("mailServer")
	private MailServer mailServer;
	
    private static final int THREAD_POOL = 30;
    private ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);
    
    public  void sendAsynchEmail(final CommonMailDTO commonMailDTO) {
    	if(commonMailDTO.isRealtimeAlert()) {
    		executorService.execute(new Runnable() {
                public void run() {
                	mailServer.sendMail(commonMailDTO);
                }
            });
    	}
    }
}