package com.bmp.oms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmp.bean.common.ResponseBean;
import com.bmp.bean.user.SessionUserBean;
import com.bmp.constant.CatalogueSource;
import com.bmp.constant.ResponseStatus;
import com.bmp.dao.channel.ClientChannelDao;
import com.bmp.model.app.channel.ClientChannel;
import com.bmp.oms.service.api.marketplace.WooCommerceService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.oms.service.api.WebHookService;

@Controller
@RequestMapping("/webhooks")
public class WebhookController {
	@Autowired
	@Qualifier("webHookServiceImpl")
	private WebHookService webHookService;
    
    @Autowired
    @Qualifier("wooCommerceServiceImpl")
    private WooCommerceService wooCommerceService;

    @Autowired
    @Qualifier("clientChannelDaoImpl")
    private ClientChannelDao clientChannelDao;

    @Autowired
    @Qualifier("sessionUserBean")
    private SessionUserBean sessionUserBean;
	
    @RequestMapping(value = "/saleOrderPushCallBack",  method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity saleOrderPushCallBack(@RequestBody Object payload, HttpServletRequest request) {
        return webHookService.saleOrderPushCallBack(request, payload);
    }
    @RequestMapping(value = "/getVenderOrderHistory",  method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity getVendorOrderHistory(@RequestBody Object payload, HttpServletRequest request) {
        return webHookService.getVendorOrderHistory(request, payload);
    }

    @RequestMapping(value = "/updateDelhiveryLr",  method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity updateDelhiveryLr() {
        return webHookService.updateDelhiveryLr();
    }

    @RequestMapping(value = "/printlabelCallBack",  method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity printlabelCallBack(@RequestBody Object payload, HttpServletRequest request) {
        return webHookService.printlabelCallBack(request, payload);
    }
    @RequestMapping(value = "/getAllTrackingWebhook", method = RequestMethod.POST)
    @ResponseBody
    public DatatableResponseBean getAllTrackingWebhook (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return webHookService.getAllTrackingWebhook(datatableRequestBean);
    }

    @RequestMapping(value = "/woocommerce/order/create",  method = RequestMethod.POST)
    public ResponseEntity<?> wooCommerceOrderCreateWebhook(HttpServletRequest request) {
        try {
            return wooCommerceService.orderCreateWebhook(request);
        } catch (Exception e) {
            // Log the exception
            ResponseBean responseBean = new ResponseBean();
            responseBean.setStatus(ResponseStatus.FAIL);
            responseBean.setMessage("Error processing WooCommerce order create webhook");
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(responseBean);
        }
    }

    @RequestMapping(value = "/woocommerce/order/update",  method = RequestMethod.POST)
    public ResponseEntity<?> wooCommerceOrderUpdateWebhook(HttpServletRequest request) {
        try {
            return wooCommerceService.orderUpdateWebhook(request);
        } catch (Exception e) {
            // Log the exception
            ResponseBean responseBean = new ResponseBean();
            responseBean.setStatus(ResponseStatus.FAIL);
            responseBean.setMessage("Error processing WooCommerce order update webhook");
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(responseBean);
        }
    }

    @RequestMapping(value = "/woocommerce/product/create",  method = RequestMethod.POST)
    public ResponseEntity<?> wooCommerceProductCreateWebhook(HttpServletRequest request) {
        try {
            return wooCommerceService.productCreateWebhook(request);
        } catch (Exception e) {
            // Log the exception
            ResponseBean responseBean = new ResponseBean();
            responseBean.setStatus(ResponseStatus.FAIL);
            responseBean.setMessage("Error processing WooCommerce product create webhook");
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(responseBean);
        }
    }

    @RequestMapping(value = "/woocommerce/product/update",  method = RequestMethod.POST)
    public ResponseEntity<?> wooCommerceProductUpdateWebhook(HttpServletRequest request) {
        try {
            return wooCommerceService.productUpdateWebhook(request);
        } catch (Exception e) {
            // Log the exception
            ResponseBean responseBean = new ResponseBean();
            responseBean.setStatus(ResponseStatus.FAIL);
            responseBean.setMessage("Error processing WooCommerce product update webhook");
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(responseBean);
        }
    }
    
    @RequestMapping(value = "/shopifyOrderWebhook",  method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity shopifyOrderWebhook(@RequestBody Object payload, HttpServletRequest request) {
        return webHookService.shopifyOrderWebhook(request, payload);
    }

    @RequestMapping(value = "/woocommerce/register-webhooks",  method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> registerWooCommerceWebhooks(@RequestParam String clientKey, @RequestParam String appBaseUrl) {
            return wooCommerceService.registerAllWebhooks(clientKey,appBaseUrl);
    }
}
