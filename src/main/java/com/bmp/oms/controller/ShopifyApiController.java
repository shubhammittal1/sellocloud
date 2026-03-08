package com.bmp.oms.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.bmp.bean.common.ResponseBean;
import com.bmp.bean.user.SessionUserBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.oms.service.api.marketplace.ShopifyService;

@Controller
@RequestMapping("/shopify")
public class ShopifyApiController {
	
	@Autowired
	@Qualifier("shopifyServiceImpl")
	private ShopifyService shopifyAuthService;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public RedirectView  auth(@RequestParam(value = "shop") String shop,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = shopifyAuthService.auth(shop, request, response);
		return new RedirectView(url);
	}
	
	@RequestMapping(value = "/callback", method = RequestMethod.GET)
	public RedirectView callback(@RequestParam(value = "code") String code,
            @RequestParam(value = "hmac") String hmac,
            @RequestParam(value = "shop") String shop,
            @RequestParam(value = "state") String state,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session) throws Exception {
		ResponseBean responseBean = shopifyAuthService.callback(code, hmac, shop, state, session);
		
		// Create first-party session cookie
        //response.addHeader("Set-Cookie", "shop=" + shop + "; Path=/; HttpOnly; Secure; SameSite=Lax");

		//response.sendRedirect(responseBean.getResponse().toString());
        return new RedirectView(responseBean.getResponse().toString());
	}
	
	@RequestMapping(value = "/customers/data_request", method = RequestMethod.POST)
    public ResponseEntity<Void> handleDataRequest(@RequestBody String payload, @RequestHeader(value = "X-Shopify-Hmac-Sha256", required = false) String hmacHeader) {
		System.out.println("data_request -------->  "+hmacHeader);
		System.out.println("data_request -------->  "+payload);
		if(hmacHeader != null) {
        	if(!isValidShopifyWebhook(payload, hmacHeader)) {
        		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        	}
        }
        return ResponseEntity.ok().build();
    }

	@RequestMapping(value = "/customers/redact", method = RequestMethod.POST)
    public ResponseEntity<Void> handleCustomerRedact(@RequestBody String payload, @RequestHeader(value = "X-Shopify-Hmac-Sha256", required = false) String hmacHeader) {
		System.out.println("data_request -------->  "+hmacHeader);
		System.out.println("data_request -------->  "+payload);
		if(hmacHeader != null) {
        	if(!isValidShopifyWebhook(payload, hmacHeader)) {
        		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        	}
        }
        return ResponseEntity.ok().build();
    }

	@RequestMapping(value = "/shop/redact", method = RequestMethod.POST)
    public ResponseEntity<Void> handleShopRedact(@RequestBody String payload, @RequestHeader(value = "X-Shopify-Hmac-Sha256", required = false) String hmacHeader, HttpServletResponse response) {
		System.out.println("data_request -------->  "+hmacHeader);
		System.out.println("data_request -------->  "+payload);
		if(hmacHeader != null) {
        	if(!isValidShopifyWebhook(payload, hmacHeader)) {
        		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        	}
        }
        shopifyAuthService.handleShopRedact(payload, response);
        return ResponseEntity.ok().build();
    }
	
	private boolean isValidShopifyWebhook(String payload, String hmacHeader) {
	    try {
	    	String sharedSecret  = messageSource.getMessage(GlobalConstant.SHOPIFY_API_SECRET, null, null);
	        Mac mac = Mac.getInstance("HmacSHA256");
	        mac.init(new SecretKeySpec(sharedSecret.getBytes(), "HmacSHA256"));
	        byte[] hash = mac.doFinal(payload.getBytes(StandardCharsets.UTF_8));
	        String calculatedHmac = Base64.getEncoder().encodeToString(hash);
	        return MessageDigest.isEqual(calculatedHmac.getBytes(), hmacHeader.getBytes());
	    } catch (Exception e) {
	        return false;
	    }
	}
	
}
