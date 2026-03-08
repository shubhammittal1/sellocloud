package com.bmp.mail.executor.service;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.bmp.constant.GlobalConstant;
import com.bmp.mail.model.CommonMailDTO;
import com.google.protobuf.Message;

@Service
@Scope("singleton")
@Qualifier("velocityEngineHelper")
public class VelocityEngineHelper {

    private VelocityEngine velocityEngine;
    
    @Autowired
	private MessageSource messageSource;

    private void intiVelocityEngine() {
        //first, get and initialise an engine
        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
    }
    
    public String getEmailBody(final CommonMailDTO commonMailDTO) {
    	if (velocityEngine == null) {
    		intiVelocityEngine ();
    	}
    	
    	//String absolutePath=new File(Thread.currentThread().getContextClassLoader().getResource("").getFile()).getParentFile().getParentFile().getPath();//this goes to webapps directory
    	//System.out.println("path" +absolutePath);
    	
    	/*  add that list to a VelocityContext  */
        VelocityContext context = new VelocityContext();
        context.put("commonMailDTO", commonMailDTO);
        
        /*  get the Template  */
        Template t = velocityEngine.getTemplate("/templates/"+commonMailDTO.getAlertMaster().getTemplateName());
        /*  now render the template into a Writer  */
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        
        return writer.toString();
    }
    
    public String getProformaInvoiceBody(final CommonMailDTO commonMailDTO) {
    	if (velocityEngine == null) {
    		intiVelocityEngine ();
    	}
    	
    	//String absolutePath=new File(Thread.currentThread().getContextClassLoader().getResource("").getFile()).getParentFile().getParentFile().getPath();//this goes to webapps directory
    	//System.out.println("path" +absolutePath);
    	
    	/*  add that list to a VelocityContext  */
        VelocityContext context = new VelocityContext();
        context.put("commonMailDTO", commonMailDTO);
        
        String proformaInvoiceFile = messageSource.getMessage(GlobalConstant.RAL_PROFORMA_INVOICE, null, null);
        
        /*  get the Template  */
        Template t = velocityEngine.getTemplate("/templates/"+proformaInvoiceFile+".vm");
        /*  now render the template into a Writer  */
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        
        return writer.toString();
    }

}
