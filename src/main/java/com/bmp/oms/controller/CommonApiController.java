package com.bmp.oms.controller;

import com.bmp.oms.service.api.marketplace.WooCommerceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/common/api")
public class CommonApiController {

    @Autowired
    @Qualifier("wooCommerceServiceImpl")
    private WooCommerceService wooCommerceService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public void auth(HttpServletResponse response, HttpServletRequest request) throws Exception {
    }

    @RequestMapping(value = "/wooComm/callback", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> callback(/*@RequestParam String consumer_key,
                                 @RequestParam String consumer_secret,
                                 @RequestParam String user_id*/) {
        return ResponseEntity.ok("WooCommerce App Authorized Successfully!");
    }
}
