package com.bmp.oms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.bmp.bean.common.ResponseBean;
import com.bmp.constant.ResponseStatus;
import com.bmp.oms.service.api.marketplace.FlipkartMarketplaceService;

@Controller
@RequestMapping("/flipkart")
public class FlipkartAuthController {
	
	@Autowired
    @Qualifier("flipkartMarketplaceServiceImpl")
    private FlipkartMarketplaceService flipkartService;
    
    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    @ResponseBody
    public void auth(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String redirectUrl = flipkartService.auth(request);
        response.sendRedirect(redirectUrl);
    }
    
    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    @ResponseBody
    public RedirectView callback(@RequestParam("code") String code, @RequestParam("state") String state) {

    	ResponseBean responseBean = flipkartService.callback(code,state);
		if(ResponseStatus.SUCCESS.equals(responseBean.getStatus())) {
			return new RedirectView(responseBean.getResponse().toString());
    	}else {
    		return new RedirectView("");
    	}
    }

}
