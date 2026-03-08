package com.bmp.oms.controller;

import com.bmp.bean.common.ResponseBean;
import com.bmp.oms.service.api.marketplace.WooCommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/woocommerce")
public class WooCommerceAuthController {

    @Qualifier("wooCommerceServiceImpl")
    @Autowired
    private WooCommerceService wooCommerceService;


    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public void auth(HttpServletResponse response,
                     @RequestParam("app_url") String appUrl,
                     @RequestParam("return_url") String returnUrl,
                     @RequestParam("callback_url") String callbackUrl) {
        wooCommerceService.auth(response, appUrl, returnUrl, callbackUrl);
    }

    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    public ResponseEntity<ResponseBean> callback(@RequestBody Map<String, String> payload) {
        ResponseBean responseBean = wooCommerceService.callback(payload);
        return ResponseEntity.ok(responseBean);
    }
}
