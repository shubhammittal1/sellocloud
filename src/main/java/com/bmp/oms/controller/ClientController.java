package com.bmp.oms.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bmp.bean.DebitCreditBean;
import com.bmp.bean.client.ClientBillingBean;
import com.bmp.bean.client.ClientPincodeGroupCourierPriorityBean;
import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.bean.courier.ClientProductCourierPriority;
import com.bmp.constant.MessageConstant;
import com.bmp.model.app.client.BillingOtherCharges;
import com.bmp.model.app.client.Client;
import com.bmp.model.app.client.ClientCategoryMapping;
import com.bmp.model.app.client.ClientCode;
import com.bmp.model.app.client.ClientCourierRateListTemplate;
import com.bmp.model.app.client.ClientFinance;
import com.bmp.model.app.client.ClientNew;
import com.bmp.model.app.client.ClientProductSkuRate;
import com.bmp.model.app.client.ClientRateList;
import com.bmp.model.app.client.ClientServiceablePincode;
import com.bmp.model.app.client.ClientWarehouse;
import com.bmp.model.app.client.ComplaintBox;
import com.bmp.model.app.client.RateListTemplate;
import com.bmp.oms.service.client.BillingOtherChargesService;
import com.bmp.oms.service.client.ClientAccountService;
import com.bmp.oms.service.client.ClientBillingService;
import com.bmp.oms.service.client.ClientCategoryMappingService;
import com.bmp.oms.service.client.ClientCodeService;
import com.bmp.oms.service.client.ClientCourierRateListTemplateService;
import com.bmp.oms.service.client.ClientDashboardService;
import com.bmp.oms.service.client.ClientFinanceService;
import com.bmp.oms.service.client.ClientNewService;
import com.bmp.oms.service.client.ClientProductSkuRateService;
import com.bmp.oms.service.client.ClientRateListService;
import com.bmp.oms.service.client.ClientService;
import com.bmp.oms.service.client.ClientServiceablePincodeService;
import com.bmp.oms.service.client.ClientWarehouseService;
import com.bmp.oms.service.client.ComplaintBoxService;
import com.bmp.oms.service.client.RateListTemplateService;
import com.bmp.oms.service.courier.CourierService;
import com.bmp.oms.service.masters.ProductTypeService;
import com.bmp.oms.service.masters.RateZoneService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	@Qualifier("clientService")
	private ClientService clientService;
	
	@Autowired
	@Qualifier("courierServiceImpl")
	private CourierService courierService;
	
	@Autowired
	@Qualifier("clientRateListService")
	private ClientRateListService clientRateListService;
	
	@Autowired
	@Qualifier("productTypeServiceImpl")
	private ProductTypeService productTypeService;

	@Autowired
	@Qualifier("rateZoneServiceImpl")
	private RateZoneService rateZoneService;
	
	@Autowired
	@Qualifier("clientWarehouseServiceImpl")
	private ClientWarehouseService clientWarehouseService;
	
	@Autowired
	@Qualifier("clientDashboardServiceImpl")
	private ClientDashboardService clientDashboardService;
	
	@Autowired
	@Qualifier("clientCategoryMappingServiceImpl")
	private ClientCategoryMappingService clientCategoryMappingService;

	@Autowired
	@Qualifier("clientFinanceServiceImpl")
	private ClientFinanceService clientFinanceService;
	
	@Autowired
	@Qualifier("rateListTemplateServiceImpl")
	private RateListTemplateService rateListTemplateService;
	
	@Autowired
	@Qualifier("clientCourierRateListTemplateServiceImpl")
	private ClientCourierRateListTemplateService clientCourierRateListTemplateService;
	
	@Autowired
	@Qualifier("clientBillingServiceImpl")
	private ClientBillingService clientBillingService;
	
	@Autowired
	@Qualifier("clientAccountServiceImpl")
	private ClientAccountService clientAccountService;
	
	@Autowired
	@Qualifier("complaintBoxServiceImpl")
	private ComplaintBoxService complaintBoxService;
	
	@Autowired
	@Qualifier("clientServiceablePincodeServiceImpl")
	private ClientServiceablePincodeService clientServiceablePincodeService;
	
	@Autowired
	@Qualifier("clientCodeServiceImpl")
	private ClientCodeService clientCodeService;
	
	@Autowired
	@Qualifier("clientProductSkuRateServiceImpl")
	private ClientProductSkuRateService clientProductSkuRateService;
	
	@Autowired
	@Qualifier("clientNewServiceImpl")
	private ClientNewService clientNewService;
	
	@Autowired
	@Qualifier("billingOtherChargesServiceImpl")
	private BillingOtherChargesService billingOtherChargesService;
	
	@Autowired
	private MessageSource messageSource;
	
	
	@RequestMapping(value = "/getAllClient", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllClient (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return clientService.getAllClient(datatableRequestBean);
    }

	@RequestMapping(value = "/createClient", method = RequestMethod.POST)
	public @ResponseBody ResponseBean createClient(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Map<String,MultipartFile> doc = new HashMap<String,MultipartFile>();
		doc.put("logoImg", request.getFile("logoImageName"));
		doc.put("moaDoc", request.getFile("moaDocument"));
		doc.put("additionalDoc1", request.getFile("additionalDocument1"));
		doc.put("additionalDoc2", request.getFile("additionalDocument2"));
		doc.put("cancelCheque", request.getFile("cancelCheque"));
		doc.put("panCard", request.getFile("panCard"));
		
		String clientBean = request.getParameter("clientBean");
		ObjectMapper mapper = new ObjectMapper();
		Client client = mapper.readValue(clientBean, Client.class);
        return clientService.createClient(client,doc, request);
	}
	
	@RequestMapping(value = "/updateClient", method = RequestMethod.POST)
	public @ResponseBody ResponseBean updateClient(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Map<String,MultipartFile> doc = new HashMap<String,MultipartFile>();
		doc.put("logoImg", request.getFile("logoImageName"));
		doc.put("moaDoc", request.getFile("moaDocument"));
		doc.put("additionalDoc1", request.getFile("additionalDocument1"));
		doc.put("additionalDoc2", request.getFile("additionalDocument2"));
		doc.put("cancelCheque", request.getFile("cancelCheque"));
		doc.put("panCard", request.getFile("panCard"));
		
		String clientBean = request.getParameter("clientBean");
		ObjectMapper mapper = new ObjectMapper();
		Client client = mapper.readValue(clientBean, Client.class);
        return clientService.updateClient(client,doc, request);
	}
	
	@RequestMapping(value = "/deleteClient/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteClient(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientService.deleteClient(key);
    }
	
	@RequestMapping(value = "/checkClientKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkClientKeyAvailable (@PathVariable("key") String key) {
		return clientService.checkClientKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getAllClientRateList", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllClientRateList (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return clientRateListService.getAllClientRateList(datatableRequestBean);
    }

	@RequestMapping(value = "/createClientRateList", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createClientRateList(@RequestBody ClientRateList clientRateList, HttpServletRequest request, HttpServletResponse response) {
		return clientRateListService.createClientRateList(clientRateList);
    }
	

	@RequestMapping(value = "/updateClientRateList", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateCLientRateList(@RequestBody ClientRateList clientRateList, HttpServletRequest request, HttpServletResponse response) {
		return clientRateListService.updateClientRateList(clientRateList);
    }
	
	@RequestMapping(value = "/deleteClientRateList/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteClientRateList(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientRateListService.deleteClientRateList(key);
    }
	
	@RequestMapping(value = "/checkClientRateListKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkClientRateListKeyAvailable (@PathVariable("key") String key) {
		return clientRateListService.checkClientRateListKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getClient/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getClient (@PathVariable("key") String key) {
		return clientService.getClient (key);
    }
	@RequestMapping(value = "/getClientToken", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getClientToken () {
		return clientService.getClientToken ();
    }
	
	@RequestMapping(value = "/createClientPincodeGroupCourierPriority", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createClientPincodeGroupCourierPriority(@RequestBody ClientPincodeGroupCourierPriorityBean clientPincodeGroupCourierPriorityBean, HttpServletRequest request, HttpServletResponse response) {
		return clientService.createClientPincodeGroupCourierPriority(clientPincodeGroupCourierPriorityBean);
    }
	
	@RequestMapping(value = "/deleteClientGroupToGroup", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean deleteClientGroupToGroup(@RequestBody ClientPincodeGroupCourierPriorityBean clientPincodeGroupCourierPriorityBean, HttpServletRequest request, HttpServletResponse response) {
		return clientService.deleteClientGroupToGroup(clientPincodeGroupCourierPriorityBean);
    }
	
	
	@RequestMapping(value = "/loadClients", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadClients( HttpServletRequest request, HttpServletResponse response) {
		return clientService.loadClients();
    }
	
	@RequestMapping(value = "/loadClientsAll", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadClientsAll( HttpServletRequest request, HttpServletResponse response) {
		return clientService.loadClientsAll();
    }
	
	@RequestMapping(value = "/getClientDocCategories/{key}", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean getClientDocCategories(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientService.getClientDocCategories(key);
    }
	
	@RequestMapping(value = "/loadCourier", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadCourier( HttpServletRequest request, HttpServletResponse response) {
		return courierService.loadCouriers();
    }
	
	@RequestMapping(value = "/loadRateZone", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadRateZone( HttpServletRequest request, HttpServletResponse response) {
		return rateZoneService.loadRateZones();
    }
	
	@RequestMapping(value = "/pincodeCourierPriority/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean pincodeCourierPriority (@PathVariable("key") String key) {
		return clientService.loadClientData(key);
    }
	
	@RequestMapping(value = "/createPincodeCourierPriority", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createPincodeCourierPriority(@RequestBody Client client, HttpServletRequest request, HttpServletResponse response) {
		return clientService.createPincodeCourierPriority(client);
    }
	
	@RequestMapping(value = "/loadProductTypes", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadProductTypes( HttpServletRequest request, HttpServletResponse response) {
		return productTypeService.loadProductTypes();
    }

	@RequestMapping(value = "/loadClientRateZones/{clientKey}", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean loadClientRateZones(@PathVariable("clientKey") String clientKey) {
		return clientService.loadClientRateZones(clientKey);
    }
	
	@RequestMapping(value = "/checkClientTokenAvailable/{token}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkClientTokenAvailable (@PathVariable("token") String token) {
		return clientService.checkClientTokenAvailable(token);
    }
	
	@RequestMapping(value = "/checkClientCodeAvailable/{clientCode}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkClientCodeAvailable (@PathVariable("clientCode") String clientCode) {
		return clientService.checkClientCodeAvailable(clientCode);
    }
	
	@RequestMapping(value = "/getAllClientWarehouse", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllClientWarehouse (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return clientWarehouseService.getAllClientWarehouse(datatableRequestBean);
    }
	
	@RequestMapping(value = "/checkClientWarehouseKeyAvailable/{warehouseName_s}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkClientWarehouseKeyAvailable (@PathVariable("warehouseName_s") String key) {
		return clientWarehouseService.checkClientWarehouseKeyAvailable(key);
    }
	
	@RequestMapping(value = "/createClientWarehouse", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createClientWarehouse(@RequestBody ClientWarehouse clientWarehouse, HttpServletRequest request, HttpServletResponse response) {
		return clientWarehouseService.createClientWarehouse(clientWarehouse);
    }
	
	@RequestMapping(value = "/updateClientWarehouse", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateClientWarehouse(@RequestBody ClientWarehouse clientWarehouse, HttpServletRequest request, HttpServletResponse response) {
		return clientWarehouseService.updateClientWarehouse(clientWarehouse);
    }
	
	@RequestMapping(value = "/deleteClientWarehouse/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteClientWarehouse(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientWarehouseService.deleteClientWarehouse(key);
    }
	
	@RequestMapping(value = "/getWarehouse", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getWarehouse (@RequestParam(value = "clientKey",required = false) String clientKey) {
		return clientWarehouseService.getWarehouse (clientKey);
    }
	
	@RequestMapping(value = "/getProductTypesList", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean getProductTypesList( HttpServletRequest request, HttpServletResponse response) {
		return productTypeService.getProductTypesList();
    }
	
	@RequestMapping(value = "/getClientShipmentsReport", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean getClientShipmentsReport(@RequestParam("key") String key,@RequestParam(value = "clientId", required=false) String clientId,HttpServletRequest request, HttpServletResponse response) {
		return clientDashboardService.getClientShipmentsReport(key,clientId);
    }
	
	@RequestMapping(value = "/updateClientProductCourierPriority/{clientKey}", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createPage(@RequestBody Map<String, ClientProductCourierPriority> clientProductCourierPriorityMap, @PathVariable("clientKey") String clientkey, HttpServletRequest request, HttpServletResponse response) {
		return clientService.updateClientProductCourierPriority(clientkey,clientProductCourierPriorityMap);
    }
	
	@RequestMapping(value = "/getAllClientProductCourierPriority", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllClientProductCourierPriority (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return clientService.getAllClientProductCourierPriority(datatableRequestBean);
    }
	
	@RequestMapping(value = "/deleteClientProductCourierPriority/{key}/{productType}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteClientProductCourierPriority(@PathVariable("key") String key,@PathVariable("productType") String productType, HttpServletRequest request, HttpServletResponse response) {
		return clientService.deleteClientProductCourierPriority(key,productType);
    }

	@RequestMapping(value = "/getClientsOnInscan", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean getClientsOnInscan( HttpServletRequest request, HttpServletResponse response) {
		return clientService.getClientsOnInscan();
    }
	
	@RequestMapping(value = "/getAllClientCategoryMapping", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllPages (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return clientCategoryMappingService.getAllClientCategoryMapping(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createClientCategoryMapping", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createPage(@RequestBody ClientCategoryMapping clientCategoryMapping, HttpServletRequest request, HttpServletResponse response) {
		return clientCategoryMappingService.createClientCategoryMapping(clientCategoryMapping);
    }
	
	@RequestMapping(value = "/updateClientCategoryMapping", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updatePage(@RequestBody ClientCategoryMapping clientCategoryMapping, HttpServletRequest request, HttpServletResponse response) {
		return clientCategoryMappingService.updateClientCategoryMapping(clientCategoryMapping);
    }
	
	@RequestMapping(value = "/deleteClientCategoryMapping/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deletePage(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientCategoryMappingService.deleteClientCategoryMapping(key);
    }
	
	@RequestMapping(value = "/getAllRateListTemplate", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllRateListTemplate (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return rateListTemplateService.getAllRateListTemplate(datatableRequestBean);
    }

	@RequestMapping(value = "/createRateListTemplate", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createRateListTemplate(@RequestBody RateListTemplate rateListTemplate, HttpServletRequest request, HttpServletResponse response) {
		return rateListTemplateService.createRateListTemplate(rateListTemplate);
    }
	
	@RequestMapping(value = "/updateRateListTemplate", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateRateListTemplate(@RequestBody RateListTemplate rateListTemplate, HttpServletRequest request, HttpServletResponse response) {
		return rateListTemplateService.updateRateListTemplate(rateListTemplate);
    }
	
	@RequestMapping(value = "/deleteRateListTemplate/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteRateListTemplate(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return rateListTemplateService.deleteRateListTemplate(key);
    }
	
	@RequestMapping(value = "/checkRateListTemplateKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkRateListTemplateKeyAvailable (@PathVariable("key") String key) {
		return rateListTemplateService.checkRateListTemplateKeyAvailable(key);
    }
	
	@RequestMapping(value = "/createClientFinance", method = RequestMethod.POST)
	public @ResponseBody ResponseBean createClientFinance(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Map<String,MultipartFile> doc = new HashMap<String,MultipartFile>();
		doc.put("logoImg", request.getFile("logoImageName"));
		doc.put("moaDoc", request.getFile("moaDocument"));
		doc.put("additionalDoc1", request.getFile("additionalDocument1"));
		doc.put("additionalDoc2", request.getFile("additionalDocument2"));
		doc.put("cancelCheque", request.getFile("cancelCheque"));
		doc.put("panCard", request.getFile("panCard"));
		
		String clientBean = request.getParameter("clientBean");
		ObjectMapper mapper = new ObjectMapper();
		ClientFinance clientFinance = mapper.readValue(clientBean, ClientFinance.class);
        return clientFinanceService.createClientFinance(clientFinance,doc);
	}
	
	@RequestMapping(value = "/updateClientFinance", method = RequestMethod.POST)
	public @ResponseBody ResponseBean updateClientFinance(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Map<String,MultipartFile> doc = new HashMap<String,MultipartFile>();
		doc.put("logoImg", request.getFile("logoImageName"));
		doc.put("moaDoc", request.getFile("moaDocument"));
		doc.put("additionalDoc1", request.getFile("additionalDocument1"));
		doc.put("additionalDoc2", request.getFile("additionalDocument2"));
		doc.put("cancelCheque", request.getFile("cancelCheque"));
		doc.put("panCard", request.getFile("panCard"));
		
		String clientBean = request.getParameter("clientBean");
		ObjectMapper mapper = new ObjectMapper();
		ClientFinance clientFinance = mapper.readValue(clientBean, ClientFinance.class);
        return clientFinanceService.updateClientFinance(clientFinance,doc);
	}
	
	@RequestMapping(value = "/getAllClientFinance", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllClientFinance (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return clientFinanceService.getAllClientFinance(datatableRequestBean);
    }

	@RequestMapping(value = "/deleteClientFinance/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteClientFinance(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientFinanceService.deleteClientFinance(key);
    }
	
	@RequestMapping(value = "/checkClientFinanceKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkClientFinanceKeyAvailable (@PathVariable("key") String key) {
		return clientFinanceService.checkClientFinanceKeyAvailable(key);
    }
	
	@RequestMapping("/downloadClientDoc")
	@ResponseBody
		public void downloadDrsScannedFile(@RequestParam(value="key") String fileName, HttpServletResponse response) throws Exception{
		clientFinanceService.downloadClientDoc(fileName,response);
	}
	
	@RequestMapping(value = "/getClientAndRateListTempleateAndProductType", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean getClientAndRateListTempleateAndProductType (HttpServletRequest request, HttpServletResponse response) {
        return clientService.getClientAndRateListTempleateAndProductType();
    }
	
	@RequestMapping(value = "/getBillingBankDeposits", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getBillingBankDeposits(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return clientBillingService.getBillingBankDeposits(datatableRequestBean);
	}

	@RequestMapping(value = "/saveBillDepositSlip", method = RequestMethod.POST)
	public @ResponseBody ResponseBean saveBillDepositSlip(MultipartHttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();
		MultipartFile file = request.getFile("depositSlip");

		param.put("depositSlip", file);
		param.put("key", request.getParameter("key"));
		param.put("depositDate", request.getParameter("depositDate"));
		param.put("bankName", request.getParameter("bankName"));
		param.put("accountNo", request.getParameter("accountNo"));
		param.put("transactionNo", request.getParameter("transactionNo"));
		param.put("depositedAmt", request.getParameter("depositedAmt"));

		return clientBillingService.saveBillDepositSlip(param);
	}
	
	@RequestMapping(value = "/getAllClientBills", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getAllClientBills(HttpServletRequest request, HttpServletResponse response) {
		return clientBillingService.getAllClientBills();
	}
	
	@RequestMapping(value = "/getAllBillingClosed", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllBillingClosed(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return clientBillingService.getAllBillingClosed(datatableRequestBean);
	}
	
	@RequestMapping(value = "/billingMarkAsDispute", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean billingMarkAsDispute(@RequestParam(value = "key") String key, HttpServletRequest request,HttpServletResponse response) {
		return clientBillingService.billingMarkAsDispute(key);
	}
	
	@RequestMapping(value = "/getAllbillingDispute", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllbillingDispute(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return clientBillingService.getAllbillingDispute(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getBillingValue", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getBillingValue(@RequestParam(value = "key") String key,HttpServletRequest request, HttpServletResponse response) {
		return clientBillingService.getBillingValue(key);
	}
	
	@RequestMapping(value = "/updatePaymentModeAndColectedAmt", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean updatePaymentModeAndColectedAmt(
			@RequestParam(value = "key") String key,
			@RequestParam(value = "orderKey") String orderKey,
			@RequestParam(value = "paymentMode") String paymentMode,
			@RequestParam(value = "clctAmt") String clctAmt,
			HttpServletRequest request,HttpServletResponse response) {
		return clientBillingService.updatePaymentModeAndColectedAmt(key, orderKey, paymentMode, clctAmt);
	}
	
	@RequestMapping(value = "/billingDisputeResolve", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean billingDisputeResolve(@RequestParam(value = "key") String key,HttpServletRequest request, HttpServletResponse response) {
		return clientBillingService.billingDisputeResolve(key);
	}

	@RequestMapping(value = "/getAllFinalizedClientBilling", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllFinalizedClientBilling (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return clientBillingService.getAllFinalizedClientBilling(datatableRequestBean);
    }
	
	@RequestMapping(value = "/finalizeClientBilling", method = RequestMethod.POST)
	public @ResponseBody ResponseBean finalizeClientBilling(@RequestBody ClientBillingBean clientBillingBean,HttpServletRequest request, HttpServletResponse response) {
		/*MultipartFile file = request.getFile("file");
		String beanData = request.getParameter("beanData");
		ObjectMapper mapper = new ObjectMapper();
		ClientBillingBean clientBillingBean = new ClientBillingBean();
		try {
			clientBillingBean = mapper.readValue(beanData,ClientBillingBean.class);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return clientBillingService.finalizeClientBilling(clientBillingBean);
	}
	
	@RequestMapping(value = "/createClientBilling", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean createClientBilling(
			@RequestBody ClientBillingBean clientBillingBean,
			HttpServletRequest request, HttpServletResponse response) {
		return clientBillingService.createClientBilling(clientBillingBean);
	}
	
	@RequestMapping(value = "/validateClientBilling", method = RequestMethod.POST)
	public @ResponseBody ResponseBean validateClientBilling(MultipartHttpServletRequest request, HttpServletResponse response)throws Exception {
		MultipartFile file = request.getFile("file");
		String beanData = request.getParameter("beanData");
		ObjectMapper mapper = new ObjectMapper();
		ClientBillingBean clientBillingBean = mapper.readValue(beanData,
				ClientBillingBean.class);
		return clientBillingService.validateClientBilling(clientBillingBean, file);
	}
	
	@RequestMapping(value = "/deleteClientBill/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteClientBill(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientBillingService.deleteClientBill(key);
    }
	
	@RequestMapping(value = "/getAllBillingApprovedClientBill", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllBillingApprovedClientBill (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return clientBillingService.getAllBillingApprovedClientBill(datatableRequestBean);
    }
	
	@RequestMapping(value = "/markBillApproved", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean markBillApproved(@RequestParam(value = "key") String key,HttpServletRequest request, HttpServletResponse response) {
		return clientBillingService.markBillApproved(key);
	}
	
	@RequestMapping(value = "/getClientBalance/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getClientBalance(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientAccountService.getClientBalance(key);
    }
	
	@RequestMapping(value = "/getClientDetailsForEBSGateway", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getClientDetailsForEBSGateway(HttpServletRequest request, HttpServletResponse response) {
		return clientAccountService.getClientDetailsForEBSGateway();
    }
	
	@RequestMapping(value = "/updateClientBalance", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateClientBalance(@RequestBody DebitCreditBean debitCreditBean,HttpServletRequest request, HttpServletResponse response) {
		return clientAccountService.updateClientBalance(debitCreditBean, false);
    }
	
	@RequestMapping(value = "/getAllComplaint", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllComplaint (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return complaintBoxService.getAllComplaint(datatableRequestBean);
    }
	
	@RequestMapping(value = "/addComplaint", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addComplaint(@RequestBody ComplaintBox complaintBox, HttpServletRequest request, HttpServletResponse response) {
		return complaintBoxService.addComplaint(complaintBox);
    }
	
	@RequestMapping(value = "/assignComplant", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean assignComplant(@RequestBody ComplaintBox complaintBox, HttpServletRequest request, HttpServletResponse response) {
		return complaintBoxService.assignComplant(complaintBox);
    }
	
	@RequestMapping(value = "/getCommentsData/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getCommentsData(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return complaintBoxService.getCommentsData(key);
    }
	
	@RequestMapping(value = "/addCommentsData", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addCommentsData(@RequestBody ComplaintBox complaintBox, HttpServletRequest request, HttpServletResponse response) {
		return complaintBoxService.addCommentsData(complaintBox);
    }
	
	@RequestMapping(value = "/complaintClosed/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean complaintClosed(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return complaintBoxService.complaintClosed(key);
    }
	
	@RequestMapping(value = "/getAllClientServiceablePincode", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllClientServiceablePincode (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return clientServiceablePincodeService.getAllClientServiceablePincode(datatableRequestBean);
    }
	
	@RequestMapping(value = "/createClientServiceablePincode", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createClientServiceablePincode(@RequestBody ClientServiceablePincode clientServiceablePincode, HttpServletRequest request, HttpServletResponse response) {
		return clientServiceablePincodeService.saveServiceablePincode(clientServiceablePincode);
    }
	
	@RequestMapping(value = "/updateServiceablePincode", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateServiceablePincode(@RequestBody ClientServiceablePincode clientServiceablePincode, HttpServletRequest request, HttpServletResponse response) {
		return clientServiceablePincodeService.updateServiceablePincode(clientServiceablePincode);
    }
	
	@RequestMapping(value = "/getProductTypeByClient/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getProductTypeByClient(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientService.getProductTypeByClient(key);
    }
	
	@RequestMapping(value = "/getAllClientCode", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllClientCode (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return clientCodeService.getAllClientCode(datatableRequestBean);
    }
	
	@RequestMapping(value = "/deleteClientCode/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteClientCode(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientCodeService.deleteClientCode(key);
    }
	
	@RequestMapping(value = "/addClientCode", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addClientCode(@RequestBody ClientCode clientCode, HttpServletRequest request, HttpServletResponse response) {
		return clientCodeService.createClientCode(clientCode);
    }
	
	@RequestMapping(value = "/updateClientCode", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateClientCode(@RequestBody ClientCode clientCode, HttpServletRequest request, HttpServletResponse response) {
		return clientCodeService.updateClientCode(clientCode);
    }
	
	@RequestMapping(value = "/checkClientCodeKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkClientCodeKeyAvailable(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientCodeService.checkClientCodeKeyAvailable(key);
    }
	
	@RequestMapping(value = "/downloadClientCode", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean downloadClientCode(HttpServletRequest request, HttpServletResponse response) {
		return clientCodeService.downloadReport(response);
    }
	
	@RequestMapping(value = "/loadClientAndProductType", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean loadClientAndProductType(HttpServletRequest request, HttpServletResponse response) {
		return clientService.loadClientAndProductType();
	}
	
	/*@RequestMapping(value = "/loadClientsOrderVerifyChecked", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean loadClientsOrderVerifyChecked( HttpServletRequest request, HttpServletResponse response) {
		return clientService.loadClientsOrderVerifyChecked();
    }*/
	@RequestMapping(value = "/loadClientsOrderVerifyChecked", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean loadClientsOrderVerifyChecked(@RequestParam(value="type") String type, HttpServletRequest request, HttpServletResponse response) {
    	return clientService.loadClientsOrderVerifyChecked(type);
    }
	
	@RequestMapping(value = "/loadPodType", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadPodType(HttpServletRequest request, HttpServletResponse response) {
		return clientService.loadPodType();
    }
	
	@RequestMapping(value = "/loadClientIdProofType/{awb}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadClientIdProofType(@PathVariable("awb") String awb,HttpServletRequest request, HttpServletResponse response) {
		return clientService.loadClientIdProofType(awb);
    }
	
	@RequestMapping(value = "/loadDeliveryDetils/{awb}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadDeliveryDetils(@PathVariable("awb") String awb,HttpServletRequest request, HttpServletResponse response) {
		return clientService.loadDeliveryDetils(awb);
    }
	
	
	
	
	@RequestMapping(value = "/createClientProductSkuRate", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createClientProductSkuRate(@RequestBody ClientProductSkuRate clientProductSkuRate, HttpServletRequest request, HttpServletResponse response) {
		return clientProductSkuRateService.createClientProductSkuRate(clientProductSkuRate);
    }
	
	@RequestMapping(value = "/updateClientProductSkuRate", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateClientProductSkuRate(@RequestBody ClientProductSkuRate clientProductSkuRate, HttpServletRequest request, HttpServletResponse response) {
		return clientProductSkuRateService.updateClientProductSkuRate(clientProductSkuRate);
    }
	
	@RequestMapping(value = "/getAllClientProductSkuRate", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllClientProductSkuRate (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return clientProductSkuRateService.getAllClientProductSkuRate(datatableRequestBean);
    }
	
	@RequestMapping(value = "/deleteClientProductSkuRate/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteClientProductSkuRate(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientProductSkuRateService.deleteClientProductSkuRate(key);
    }
	
	@RequestMapping(value = "/getWalletClient", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getWalletClient( HttpServletRequest request, HttpServletResponse response) {
		return clientService.getWalletClient();
    }
	
	@RequestMapping(value = "/rechargeManualClientWallet", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean rechargeManualClientWallet (@RequestBody Map<String,String> map, HttpServletRequest request, HttpServletResponse response) {
        return clientAccountService.rechargeManualClientWallet(map);
    }
	
	@RequestMapping(value = "/createClientNew", method = RequestMethod.POST)
	public @ResponseBody ResponseBean createClientNew(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Map<String,MultipartFile> doc = new HashMap<String,MultipartFile>();
		
		Map<String,MultipartFile> d= request.getFileMap();
		doc.put("pancord-doc", request.getFile("panDoc"));
		doc.put("gst-doc", request.getFile("gstDoc"));
		doc.put("checkbook-doc", request.getFile("checkbookDoc"));
		doc.put("logo-doc", request.getFile("logoDoc"));
		
		String clientNewBean = request.getParameter("clientBean");
		ObjectMapper mapper = new ObjectMapper();
		ClientNew clientNew = mapper.readValue(clientNewBean, ClientNew.class);
        return clientNewService.createClientNew(clientNew, doc);
	}
	
	@RequestMapping(value = "/updateClientNew", method = RequestMethod.POST)
	public @ResponseBody ResponseBean updateClientNew(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Map<String,MultipartFile> doc = new HashMap<String,MultipartFile>();
		doc.put("pancord-doc", request.getFile("panDoc"));
		doc.put("gst-doc", request.getFile("gstDoc"));
		doc.put("checkbook-doc", request.getFile("checkbookDoc"));
		doc.put("logo-doc", request.getFile("logoDoc"));
		
		String clientNewBean = request.getParameter("clientBean");
		ObjectMapper mapper = new ObjectMapper();
		ClientNew clientNew = mapper.readValue(clientNewBean, ClientNew.class);
        return clientNewService.updateClientNew(clientNew,doc);
	}
	
	@RequestMapping(value = "/getAllClientNew", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllClientNew (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return clientNewService.getAllClientNew(datatableRequestBean);
    }

	@RequestMapping(value = "/deleteClientNew", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteClientNew(@RequestParam("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientNewService.deleteClientNew(key);
    }
	
	@RequestMapping(value = "/checkClientNewKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkClientNewKeyAvailable (@PathVariable("key") String key) {
		return clientNewService.checkClientNewKeyAvailable(key);
    }
	
	@RequestMapping("/downloadClientNewDoc")
	@ResponseBody
		public void downloadClientNewDoc(@RequestParam(value="key") String fileName, HttpServletResponse response) throws Exception{
		clientNewService.downloadDoc(fileName,response);
	}
	
	
	@RequestMapping(value = "/getAllClientCourierRateListTemplate", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllClientCourierRateListTemplate (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return clientCourierRateListTemplateService.getAllRateListTemplate(datatableRequestBean);
    }

	@RequestMapping(value = "/createClientCourierRateListTemplate", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createClientCourierRateListTemplate(@RequestBody ClientCourierRateListTemplate rateListTemplate, HttpServletRequest request, HttpServletResponse response) {
		return clientCourierRateListTemplateService.createRateListTemplate(rateListTemplate);
    }
	
	@RequestMapping(value = "/updateClientCourierRateListTemplate", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateClientCourierRateListTemplate(@RequestBody ClientCourierRateListTemplate rateListTemplate, HttpServletRequest request, HttpServletResponse response) {
		return clientCourierRateListTemplateService.updateRateListTemplate(rateListTemplate);
    }
	
	@RequestMapping(value = "/deleteClientCourierRateListTemplate/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteClientCourierRateListTemplate(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientCourierRateListTemplateService.deleteRateListTemplate(key);
    }
	
	@RequestMapping(value = "/checkClientCourierRateListTemplateKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkClientCourierRateListTemplateKeyAvailable (@PathVariable("key") String key) {
		return clientCourierRateListTemplateService.checkRateListTemplateKeyAvailable(key);
    }
	
	@RequestMapping(value = "/createClientBillingNew", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createClientBillingNew (@RequestBody List<ClientBillingBean> clientBillingBeans, HttpServletRequest request, HttpServletResponse response) {
        return clientBillingService.createClientBillingNew(clientBillingBeans);
    }
	
	@RequestMapping(value = "/getGetBillingData", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getGetBillingData (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return clientBillingService.getGetBillingData(datatableRequestBean);
    }
	
	@RequestMapping(value = "/deleteClientBillNew/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteClientBillNew(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientBillingService.deleteClientBillNew(key);
    }
	
	@RequestMapping("/createPDF/{billingKey}/{type}")
	@ResponseBody
    public void createPDF(@PathVariable("billingKey") String billingKey,@PathVariable("type") Boolean type, HttpServletRequest request, HttpServletResponse response) {
		String fileName = messageSource.getMessage(MessageConstant.DRS_PATH, null, null)+"/"+billingKey+"-Invoice-.pdf";
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);
		try {
			/*clientBillingService.billInvoicePDF(fileName,billingKey,type, request);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos = drsService.convertPDFToByteArrayOutputStream(fileName);
			OutputStream os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();*/
			
			clientBillingService.billInvoicePDF(fileName,billingKey,type, request);
			File file = new File(fileName);
			if(file != null && !file.exists()){
	            String errorMessage = "Sorry. The file you are looking for does not exist";
	            System.out.println(errorMessage);
	            OutputStream outputStream = response.getOutputStream();
	            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
	            outputStream.close();
	            return;
	        }
	        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
	        if(mimeType==null){
	            System.out.println("mimetype is not detectable, will take default");
	            mimeType = "application/octet-stream";
	        }
	        System.out.println("mimetype : "+mimeType);
	        response.setContentType(mimeType);
	        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
	        response.setContentLength((int)file.length());
	        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
	        FileCopyUtils.copy(inputStream, response.getOutputStream());
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
    }
	
	@RequestMapping(value = "/getAllBillingOtherCharges", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllBillingOtherCharges (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return billingOtherChargesService.getAllBillingOtherCharges(datatableRequestBean);
    }

	@RequestMapping(value = "/createBillingOtherCharges", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createBillingOtherCharges(@RequestBody BillingOtherCharges billingOtherCharges, HttpServletRequest request, HttpServletResponse response) {
		return billingOtherChargesService.createBillingOtherCharges(billingOtherCharges);
    }
	
	@RequestMapping(value = "/updateBillingOtherCharges", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateBillingOtherCharges(@RequestBody BillingOtherCharges billingOtherCharges, HttpServletRequest request, HttpServletResponse response) {
		return billingOtherChargesService.updateBillingOtherCharges(billingOtherCharges);
    }
	
	@RequestMapping(value = "/deleteBillingOtherCharges/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteBillingOtherCharges(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return billingOtherChargesService.deleteBillingOtherCharges(key);
    }
	
	@RequestMapping(value = "/getBillingOtherChargesForDropdown", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getBillingOtherChargesForDropdown( HttpServletRequest request, HttpServletResponse response) {
		return billingOtherChargesService.getBillingOtherChargesForDropdown();
    }
	
	@RequestMapping(value = "/updateInvoiceNo", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean updateInvoiceNo(@RequestParam("key") String key, @RequestParam("invoiceNo") String invoiceNo, HttpServletRequest request, HttpServletResponse response) {
		return clientBillingService.updateInvoiceNo(key, invoiceNo);
    }
	
	@RequestMapping(value = "/getOrderShippingChargeDetails", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getOrderShippingChargeDetails(@RequestParam("key") String key,HttpServletRequest request, HttpServletResponse response) {
		return clientAccountService.getOrderShippingChargeDetails(key);
    }
	
	@RequestMapping(value = "/searchClientWarehouse", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean searchClientWarehouse (@RequestParam(value = "client", required = false) String client,
    		@RequestParam(value = "input") String input) {
		return clientWarehouseService.searchClientWarehouse(client, input);
    }
	
	@RequestMapping(value = "/updateClientNewToken", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean updateClientNewToken(HttpServletRequest request, HttpServletResponse response) {
		return clientNewService.updateClientNewToken();
    }
	
	@RequestMapping(value = "/loadWarehouse", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadWarehouse () {
		return clientWarehouseService.loadWarehouse();
    }


	@RequestMapping(value = "/getAllClients", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getAllClients ( HttpServletRequest request, HttpServletResponse response) {
		return clientWarehouseService.getAllClientList();
	}

	@RequestMapping(value = "/getAllClientWarehouseByUser", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllClientWarehouseByUser (@RequestParam String filter, @RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
		filter=filter.replaceAll("referrer.*", "");
		return clientWarehouseService.getAllClientWarehouseByUser(filter,datatableRequestBean);
	}

	@RequestMapping(value = "/getAllWarehousesByClient", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getAllWarehousesByClient( @RequestParam(required = false,value="clientKey") String key, HttpServletRequest request, HttpServletResponse response) {
		return clientWarehouseService.getAllWarehouseByClient(key);
	}
	
}