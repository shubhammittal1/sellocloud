package com.bmp.mail.executor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.bmp.mail.model.CommonMailDTO;
import com.bmp.mail.server.MailServer;

@Service
@Scope("singleton")
@Qualifier("mailExecutorSynchService")
public class MailExecutorSynchService {
    
	@Autowired
	@Qualifier("mailServer")
	private MailServer mailServer;
	
	public boolean sendSynchEmail(final CommonMailDTO commonMailDTO) {
        boolean result = mailServer.sendMail(commonMailDTO);
        return result;
    }
}
