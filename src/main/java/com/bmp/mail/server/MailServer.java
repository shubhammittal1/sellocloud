package com.bmp.mail.server;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.bmp.bean.user.SessionUserBean;
import com.bmp.constant.AlertStatus;
import com.bmp.constant.AlertType;
import com.bmp.constant.GlobalConstant;
import com.bmp.dao.SettingsDao;
import com.bmp.dao.SmsMailMasterDao;
import com.bmp.mail.model.CommonMailDTO;
import com.bmp.model.app.utility.SmsMailMaster;
import com.bmp.utility.logger.AsyncLogger;

@Service
@Scope("singleton")
@Qualifier("mailServer")
public class MailServer {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("asyncLoggerImpl")
	private AsyncLogger logger;

	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;
	
	@Autowired
	@Qualifier("smsMailMasterDaoImpl")
	private SmsMailMasterDao smsMailMasterDao;
	
	@Autowired	
	@Qualifier("settingsDaoImpl")
	private SettingsDao settingsDao;

	private Session mailSession;
	
    public void setMailSession () {
		try {
			Properties properties = System.getProperties();
	        properties.setProperty(GlobalConstant.MAIL_SMTP_HOST, messageSource.getMessage(GlobalConstant.MAIL_SMTP_HOST, null, null));
	        properties.setProperty(GlobalConstant.MAIL_SMTP_PORT, messageSource.getMessage(GlobalConstant.MAIL_SMTP_PORT, null, null));
	        properties.setProperty(GlobalConstant.MAIL_SMTP_AUTH, messageSource.getMessage(GlobalConstant.MAIL_SMTP_AUTH, null, null));
	        
	        // It will comment if send from send greed.
	        //properties.setProperty("mail.smtp.starttls.enable", "true");
	        //properties.setProperty("smtp.starttls.enable", "true");
	        
	        
	        /* properties.put("mail.smtp.starttls.enable", "false");
	        properties.put("mail.smtp.starttls.required", "false");*/
	        
	        /* properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");*/
	        // set the session object
	        logger.info(MailServer.class, "User name: "+messageSource.getMessage(GlobalConstant.MAIL_PASSWORD_AUTHENTICATOR_USERNAME, null, null));
	        logger.info(MailServer.class, "API Key: "+messageSource.getMessage(GlobalConstant.MAIL_PASSWORD_AUTHENTICATOR_APIKEY, null, null));
	        mailSession = Session.getDefaultInstance(properties, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(messageSource.getMessage(GlobalConstant.MAIL_PASSWORD_AUTHENTICATOR_USERNAME, null, null),
	                		messageSource.getMessage(GlobalConstant.MAIL_PASSWORD_AUTHENTICATOR_APIKEY, null, null));
	            }
	        });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public boolean sendMail(final CommonMailDTO commonMailDTO) {
        try {
        	if (mailSession == null) {
        		setMailSession ();
        	}
        	// If will be removed if mail domain verified. Now send from single sender.
        	commonMailDTO.setMailFrom("support@bookmypacket.com");
        	// send mail for real time 
        	if(!commonMailDTO.isRealtimeAlert()) {
        		SmsMailMaster smsMailMaster =  new SmsMailMaster();
    			smsMailMaster.setAlertMasterId(commonMailDTO.getAlertMaster().getKey_s());
    			smsMailMaster.setAlertStatus_s(AlertStatus.PENDING);
    			smsMailMaster.setAlertType_s(AlertType.MAIL);
    			smsMailMaster.setTo(StringUtils.join(commonMailDTO.getMailTo(),","));
    			smsMailMaster.setCc(StringUtils.join(commonMailDTO.getMailcc(),","));
    			smsMailMaster.setSubjectLine(commonMailDTO.getSubject());
    			smsMailMaster.setFrom(commonMailDTO.getMailFrom());
    			smsMailMaster.setMessage(commonMailDTO.getMailBody());
    			if(smsMailMasterDao.saveObject(smsMailMaster, SmsMailMaster.class) == GlobalConstant.SUCCESS) {
    				System.out.println("Mail Not Send At Realtime :: It Send By Crone Job");
    				return false;
    			}
        	}
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(mailSession);
            setMailMessage(commonMailDTO, message);

            // Send message
           /* Transport transport = mailSession.getTransport(messageSource.getMessage(GlobalConstant.MAIL_TRANSPORT_PROTOCOL, null, null));

            transport.connect(messageSource.getMessage(GlobalConstant.MAIL_SMTP_HOST, null, null), messageSource.getMessage(GlobalConstant.MAIL_PASSWORD_AUTHENTICATOR_USERNAME, null, null),
            		messageSource.getMessage(GlobalConstant.MAIL_ACCOUNT_PASSWORD, null, null));*/
            Transport.send(message, message.getAllRecipients());
            //transport.sendMessage(message, message.getAllRecipients());
            //transport.close();
            logger.info(MailServer.class, "Sent message successfully....");
        } catch (Exception mex) {
            mex.printStackTrace();
            logger.info(MailServer.class, "Exception in sending mail in SSP mail Server::" + mex);
            return false;
        }
        return true;
    }

    private void setMailMessage(final CommonMailDTO commonMailDTO, final MimeMessage message)
            throws MessagingException, AddressException {
    	    //commonMailDTO.setMailFrom("BMPSupport");
        if (commonMailDTO.getMailFrom() != null) {
            message.setFrom(new InternetAddress(commonMailDTO.getMailFrom()));
        }
        
        if (commonMailDTO.getMailTo() != null) {
        	for (int i=0; i < commonMailDTO.getMailTo().length; i++) {
        		message.addRecipient(Message.RecipientType.TO, new InternetAddress(commonMailDTO.getMailTo()[i]));
			}
        }
        
       /* if (commonMailDTO.getMailcc() != null) {
        	for (int i=0; i < commonMailDTO.getMailcc().length; i++) {
        		message.addRecipient(Message.RecipientType.CC, new InternetAddress(commonMailDTO.getMailcc()[i]));
			}
        }*/
        
        if (message.getFrom() == null) {
            message.setFrom(new InternetAddress(commonMailDTO.getMailFrom()));
        }
        
        if (commonMailDTO.getSubject() != null) {
            message.setSubject(commonMailDTO.getSubject());
        } 
        
        //message.setRecipient(Message.RecipientType.BCC, new InternetAddress("amol.zambare@bookmypacket.com"));
        
        logger.info(MailServer.class, "Mail From::" + message.getFrom().toString());
        logger.info(MailServer.class, "Mail TO::" + message.getRecipients(RecipientType.TO).toString());
        logger.info(MailServer.class, "Subject::" + message.getSubject());
        
        Multipart multipart = new MimeMultipart();

        // creates body part for the message
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(commonMailDTO.getMailBody(), "text/html");
        multipart.addBodyPart(messageBodyPart);
        // message.setText();

        if (commonMailDTO.getAttachmentPath() != null && commonMailDTO.getAttachmentPath() != null) {
        	for (int i=0; i<commonMailDTO.getAttachmentPath().length; i++) {
        		MimeBodyPart attachPart = new MimeBodyPart();
                DataSource source = new FileDataSource(commonMailDTO.getAttachmentPath()[i]);
                attachPart.setDataHandler(new DataHandler(source));
                attachPart.setFileName(commonMailDTO.getAttachmentPath()[i].substring(commonMailDTO.getAttachmentPath()[i].lastIndexOf("/")+1, commonMailDTO.getAttachmentPath()[i].length()));
                multipart.addBodyPart(attachPart);
        	}
        }
        message.setContent(multipart);

    }
   
}