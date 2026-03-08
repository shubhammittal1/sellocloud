package com.bmp.oms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bmp.bean.common.ResponseBean;
import com.bmp.bean.saleorder.MeeshoOrderDetailsBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.OrderType;
import com.bmp.constant.PacketFlow;
import com.bmp.constant.PaymentType;
import com.bmp.constant.ResponseStatus;
import com.bmp.dao.BranchDao;
import com.bmp.dao.ClientDao;
import com.bmp.dao.CourierDao;
import com.bmp.dao.PincodeDao;
import com.bmp.dao.SaleOrderDao;
import com.bmp.dao.SaleOrderExtraDao;
import com.bmp.dao.VendorApiDao;
import com.bmp.model.app.api.VendorApiBean;
import com.bmp.model.app.client.Client;
import com.bmp.model.app.client.ClientCode;
import com.bmp.model.app.courier.Courier;
import com.bmp.model.app.facility.Branch;
import com.bmp.model.app.masters.Pincode;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.saleorder.SaleOrderExtra;
import com.bmp.oms.service.masters.impl.RoutingUtility.RoutingMode;
import com.bmp.oms.service.saleorder.SaleOrderService;
import com.bmp.utility.CommonUtility;
import com.bmp.utility.apiUtility.HttpRequestBeanNew;
import com.bmp.utility.apiUtility.HttpUtilittyNew;
import com.bmp.utility.logger.AsyncLogger;
import com.google.gson.Gson;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

@Controller()
@RequestMapping("/meesho")
public class MeeshoPrintController {

	private static final String DEL_CPC_PINCODE = "999911";
	private static final String DEL_CPC_BRANCH = "DELCPC";
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("asyncLoggerImpl")
	private AsyncLogger logger;
	
	@Autowired
	@Qualifier("vendorApiDaoImpl")
	private VendorApiDao vendorApiDao;
	
	@Autowired
	@Qualifier("pincodeDaoImpl")
	private PincodeDao pncodeDao;
	
	@Autowired
	@Qualifier("saleOrderDaoImpl")
	private SaleOrderDao saleOrderDao;
	
	@Autowired
	@Qualifier("saleOrderExtraDaoImpl")
	private SaleOrderExtraDao saleOrderExtraDao;
	
	@Autowired
	@Qualifier("clientDaoImpl")
	private ClientDao clientDao;
	
	@Autowired
	@Qualifier("courierDaoImpl")
	private CourierDao courierDao;
	
	@Autowired
	@Qualifier("saleOrderServiceImpl")
	private SaleOrderService saleOrderService;
	
	@Autowired
	@Qualifier("branchDaoImpl")
	private BranchDao branchDao;
	
	
	@RequestMapping("/meeshoPrint")
	public void meeshoPrint(@RequestParam(value ="meeshoAwbNumber") String meeshoAwbNumber,HttpServletRequest request, HttpServletResponse servletResponse) {
		
		if(meeshoAwbNumber != null && !"".equals(meeshoAwbNumber.trim())) {
			try {
				VendorApiBean vendorApiBean = vendorApiDao.getObjectById(messageSource.getMessage(GlobalConstant.MEESHO_PRINT_API_KEY, null, null).trim(), VendorApiBean.class);
				//Step-1 Get All PDF urls
				List<String> lableUrlList = new ArrayList<String>();
				for(String order : meeshoAwbNumber.split(",")) {
					if(order != null && !"".equals(order.trim())) {
						order = order.trim();
						MeeshoOrderDetailsBean meeshoOrderDetailsBean = callMeeshoPrintDetailsApi(vendorApiBean, order);
						if(meeshoOrderDetailsBean != null) {
							try {
								lableUrlList.add(meeshoOrderDetailsBean.getOrders().get(0).getShipping_details().getLabel_url());
							}catch(Exception e) {e.printStackTrace();}
						}
						/*System.out.println(meeshoOrderDetailsBean.getOrders().get(0).getShipping_details().getLabel_url());
						if(jsonObject != null && !jsonObject.isNull("orders")) {
							JSONArray jsonArray = jsonObject.getJSONArray("orders");
							if(!jsonArray.isNull(0)) {
								JSONObject jobj = jsonArray.getJSONObject(0);
								if(!jobj.isNull("shipping_details") && !jobj.getJSONObject("shipping_details").isNull("label_url")) {
									String lableURL = jobj.getJSONObject("shipping_details").getString("label_url");
									if(lableURL != null && !"".equals(lableURL.trim())) {
										
									}
								}
							}
						}*/
					}
				}
				
				// Step-2 Download All PDF files. 
				String path = messageSource.getMessage(GlobalConstant.MEESHO_PRINT_PATH, null, null).trim();
				File file = new File(path);
				file.mkdirs();
				List<String> pdfFileList = new ArrayList<String>();
				for(String lableUrl : lableUrlList) {
					String fileName = downloadMeeshoPdf(lableUrl, path);
					if(fileName != null) {
						pdfFileList.add(path+"/"+fileName);
					}
				}
				
				//Step-3 Merge all PDF file in a single PDF.
				servletResponse.setContentType("application/pdf");
				servletResponse.setHeader("Content-disposition", "attachment;filename=Print-Label.pdf");
				mergePdfFiles(pdfFileList, servletResponse.getOutputStream());
				
				//Step-4 Delete all PDF files
				FileUtils.cleanDirectory(file);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public MeeshoOrderDetailsBean callMeeshoPrintDetailsApi(VendorApiBean vendorApiBean, String awb) {
		Date date = new Date();
		String security = generateSHA256(vendorApiBean.getCarrierId(), vendorApiBean.getTokenUrl(), date);
		HttpRequestBeanNew requestBean = new HttpRequestBeanNew();
		requestBean.setRequestMethod("GET");
		
		Map<String,String> headerMap = new HashMap<String, String>();
		headerMap.put("timestamp", String.valueOf(date.getTime()));
		headerMap.put("security", security);
		headerMap.put("merchant", vendorApiBean.getCarrierId());
		
		requestBean.setHeaderParams(headerMap);
		requestBean.setRequestParams(new HashMap<String,Object>());
		requestBean.setRequestURL(vendorApiBean.getUrl_s()+awb);
		Map<String, StringBuffer> responseMap = new HttpUtilittyNew().doGET(requestBean);
		if(responseMap.get("response") != null) {
			try {
				Gson gson = new Gson();
				MeeshoOrderDetailsBean meeshoOrderDetailsBean = gson.fromJson(responseMap.get("response").toString(), MeeshoOrderDetailsBean.class);
				return meeshoOrderDetailsBean;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}else {
			return null;
		}
	}
	
	private String generateSHA256(String clientId, String secretKey, Date date) {
		try {					
			String timestamp = String.valueOf(date.getTime());
			String digestString = clientId+secretKey+timestamp;
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] messageDigest = md.digest(digestString.getBytes());
			BigInteger bigInteger = new BigInteger(1, messageDigest);
			String hashtext = bigInteger.toString(16);
			while (hashtext.length() < 32) {				
				hashtext = "0" + hashtext; 
			}		
			return hashtext; 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public void mergePdfFiles(List<String> pathList, OutputStream outputStream) throws Exception {
		Document document = new Document();
		List<PdfReader> readers = new ArrayList<PdfReader>();
		int totalPages = 0;
		for(String path : pathList) {
			InputStream in = new FileInputStream(path);
			PdfReader pdfReader = new PdfReader(in);
			readers.add(pdfReader);
			totalPages = totalPages + pdfReader.getNumberOfPages();
		}
		PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();
        PdfContentByte pageContentByte = writer.getDirectContent();
        
        PdfImportedPage pdfImportedPage;
        int currentPdfReaderPage = 1;
        Iterator<PdfReader> iteratorPDFReader = readers.iterator();
 
        // Iterate and process the reader list.
        while (iteratorPDFReader.hasNext()) {
        	PdfReader pdfReader = iteratorPDFReader.next();
        	while (currentPdfReaderPage <= pdfReader.getNumberOfPages()) {
                document.newPage();
                pdfImportedPage = writer.getImportedPage(pdfReader,currentPdfReaderPage);
                pageContentByte.addTemplate(pdfImportedPage, 0, 0);
                currentPdfReaderPage++;
            }
        	currentPdfReaderPage = 1;
        }
 
        outputStream.flush();
        document.close();
        outputStream.close();
	}
	
	private String downloadMeeshoPdf(String fileURL, String saveDir) throws Exception {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            if (disposition != null) {
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                        fileURL.length());
            }
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;
             
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[4096];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();
            return fileName;
        }
        httpConn.disconnect();
        return null;
    }
	
	@RequestMapping(value = "/api/uploadAllMeeshoOrderData", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean  uploadAllMeeshoOrderData() {
		ResponseBean responseBean = new ResponseBean();
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("softDataReceived_b").is(false).and("clientKey_s").is("meesho"));//GlobalConstant.MEESHO_CLIENT_KEY;
			List<String> list = saleOrderDao.getKeys(query, SaleOrder.class);
			//List<String> list = Arrays.asList("JGPP100198,JGPP100160,JGPP100158,JGPP100143".split(","));
			if(list != null && !list.isEmpty()) {
				VendorApiBean vendorApiBean = vendorApiDao.getObjectById(messageSource.getMessage(GlobalConstant.MEESHO_PRINT_API_KEY, null, null).trim(), VendorApiBean.class);
				int count =1;
				for(String awb : list) {
					MeeshoOrderDetailsBean meeshoOrderDetailsBean = callMeeshoPrintDetailsApi(vendorApiBean, awb);
					if(meeshoOrderDetailsBean != null && meeshoOrderDetailsBean.getOrders() != null && !meeshoOrderDetailsBean.getOrders().isEmpty()) {
						SaleOrder saleOrder = saleOrderDao.getObjectById(awb, SaleOrder.class);
						if(saleOrder != null) {
							if(convertOrderByMeeshoData(saleOrder, meeshoOrderDetailsBean)) {
								logger.info(MeeshoOrderDetailsBean.class, "Meesho data uploaded. AWB="+saleOrder.getKey_s()+" ---> " +count+"/"+list);
							}else {
								logger.info(MeeshoOrderDetailsBean.class, "Meesho not data uploaded. AWB="+saleOrder.getKey_s()+" ---> " +count+"/"+list);
							}
						}
						count++;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseBean;
	}
	
	private boolean convertOrderByMeeshoData(SaleOrder saleOrder, MeeshoOrderDetailsBean meeshoOrderDetailsBean) {
		try {
			if(saleOrder == null || meeshoOrderDetailsBean == null || meeshoOrderDetailsBean.getOrders() == null
					|| meeshoOrderDetailsBean.getOrders().isEmpty()) {
				return false;
			}
			saleOrder.setSenderName("Meesho");
			saleOrder.setSenderMobileNumber("999999999");
			saleOrder.setSenderAltNumber("999999999");
			saleOrder.setSenderEmail("abc@gmail.com");
			Branch sourceBranch = branchDao.getObjectById(saleOrder.getCurrentBranch_s(), Branch.class);
			Branch destinationBranch = branchDao.getObjectById(saleOrder.getCurrentBranch_s(), Branch.class);
			Pincode sourcePincode = pncodeDao.getObjectById(sourceBranch.getPincode(), Pincode.class);
			Pincode destinationPincode = pncodeDao.getObjectById(sourceBranch.getPincode(), Pincode.class);
			if(sourceBranch.getHub_b() == null && sourceBranch.getHub_b() == false) {
				if(sourceBranch.getParentBranch() != null) {
					destinationBranch = sourceBranch.getParentBranch();
					Pincode pincode = pncodeDao.getObjectById(sourceBranch.getParentBranch().getPincode(), Pincode.class);
					destinationPincode = pincode != null ? pincode : destinationPincode;
				}
				if(sourceBranch.getParentBranch() != null && DEL_CPC_BRANCH.equals(sourceBranch.getParentBranch().getKey_s())) {
					Pincode pincode = pncodeDao.getObjectById(DEL_CPC_PINCODE, Pincode.class);
					destinationPincode = pincode != null ? pincode : destinationPincode;
				}
			}
			//Pincode pincode = pncodeDao.getObjectById("999911", Pincode.class);
			saleOrder.setSenderCountry((sourcePincode.getCity() != null && sourcePincode.getCity().getState() != null && sourcePincode.getCity().getState().getCountry() != null) ? sourcePincode.getCity().getState().getCountry().getCountryName_s() :null);
			saleOrder.setSenderState((sourcePincode.getCity() != null && sourcePincode.getCity().getState() != null) ? sourcePincode.getCity().getState().getStateName_s() : null);
			saleOrder.setSenderCity(sourcePincode.getCity() != null ? sourcePincode.getCity().getCityName_s() : null);
			saleOrder.setSenderAddress("Meesho");

			//saleOrder.setSenderLandmark();
			saleOrder.setSenderPincode(sourcePincode != null ? sourcePincode.getKey_s() : DEL_CPC_PINCODE);
			saleOrder.setConsigneeName("Meesho");
			saleOrder.setConsigneeMobileNumber("999999999");
			saleOrder.setConsigneeAlternateNumber("999999999");
			saleOrder.setConsigneeEmailId("abc@gmail.com");
			saleOrder.setConsigneeCountry((destinationPincode.getCity() != null && destinationPincode.getCity().getState() != null && destinationPincode.getCity().getState().getCountry() != null) ? destinationPincode.getCity().getState().getCountry().getCountryName_s() :null);
			saleOrder.setConsigneeState((destinationPincode.getCity() != null && destinationPincode.getCity().getState() != null) ? destinationPincode.getCity().getState().getStateName_s() : null);
			saleOrder.setConsigneeCity(destinationPincode.getCity() != null ? destinationPincode.getCity().getCityName_s() : null);
			//saleOrder.setConsigneeLandmark();
			saleOrder.setConsigneeAddress("Meesho");
			saleOrder.setConsigneePincode(destinationPincode != null ? destinationPincode.getKey_s() : DEL_CPC_PINCODE);
			saleOrder.setPaymentType_s(PaymentType.PREPAID.toString());
			saleOrder.setCollectableAmount(0.0);
			
			saleOrder.setProductType ("standard");
			//saleOrder.setAwbNumber_s();
			//saleOrder.setKey_s();
			saleOrder.setSaleOrderNumber_s(meeshoOrderDetailsBean.getOrders().get(0).getOrderId());
			saleOrder.setClientManifest(meeshoOrderDetailsBean.getOrders().get(0).getOrder_group_id());
			saleOrder.setProductSKU(meeshoOrderDetailsBean.getOrders().get(0).getVsku() != null ? meeshoOrderDetailsBean.getOrders().get(0).getVsku().getVsku() :null);
			saleOrder.setSize(meeshoOrderDetailsBean.getOrders().get(0).getVariation() != null ? meeshoOrderDetailsBean.getOrders().get(0).getVariation().getName() : null);
			saleOrder.setQuantity(meeshoOrderDetailsBean.getOrders().get(0).getQuantity());
			if(meeshoOrderDetailsBean.getOrders().get(0).getProduct() != null) {
				saleOrder.setProductName(meeshoOrderDetailsBean.getOrders().get(0).getProduct().getName());
				if(meeshoOrderDetailsBean.getOrders().get(0).getProduct().getImage_urls() != null) {
					saleOrder.setProductImagesUrl(StringUtils.join(meeshoOrderDetailsBean.getOrders().get(0).getProduct().getImage_urls(),","));
				}
			}
			
			if(meeshoOrderDetailsBean.getOrders().get(0).getPrice_details() != null) {
				saleOrder.setProductPrice(meeshoOrderDetailsBean.getOrders().get(0).getPrice_details().getMrp());
			}
			if(meeshoOrderDetailsBean.getOrders().get(0).getShipping_details() != null) {
				String courierKey = meeshoOrderDetailsBean.getOrders().get(0).getShipping_details().getCarrier();
				saleOrder.setCourierAWBNumber_s(meeshoOrderDetailsBean.getOrders().get(0).getShipping_details().getAwb());
				if(courierKey != null) {
					courierKey = courierKey.replaceAll("\\s", "");
					Courier courier = courierDao.getEntityByLocationKey(courierKey);
					if(courier == null) {
						courier = courierDao.getEntityByLocationKey(courierKey.toLowerCase());
					}
					if(courier == null) {
						courier = courierDao.getEntityByLocationKey(courierKey.toUpperCase());
					}
					if(courier!= null ) {
						saleOrder.setCourierKey_s(courier.getKey_s());
					}else {
						saleOrder.setCourierKey_s(courierKey);
					}
				}
			}
			
			saleOrder.setWeight(120.00);
			saleOrder.setLength(1.0);
			saleOrder.setWidth(2.0);
			saleOrder.setHeight(3.0);
			saleOrder.setPerishable("No");
			saleOrder.setFlammable("No");
			saleOrder.setOrderType_s(OrderType.FWD.name());
			
			saleOrder.setDestinationBranch_s(destinationBranch != null? destinationBranch.getKey_s() : DEL_CPC_BRANCH);
			saleOrder.setSourceBranch_s(sourceBranch != null ? sourceBranch.getKey_s() : DEL_CPC_BRANCH);
			String toStstusKey = messageSource.getMessage(GlobalConstant.DATA_RECEIVED, null, null).trim();
			ResponseBean responseBean2 = saleOrderService.updateCurrentStatusAndPacketHistory(saleOrder, toStstusKey);
			if(responseBean2.getStatus().equals(ResponseStatus.SUCCESS)) {
				saleOrder.setSoftDataReceived_b(true);
				saleOrder.setSaleOrderDate(CommonUtility.convertLongDateToYYYYMMDDHHMMSS(new Date().getTime()));
				toStstusKey = messageSource.getMessage(GlobalConstant.INSCANNED_AWAITING_FOR_3PL_TRANSFER, null, null).trim();
				saleOrder.setRoutingMode_s(PacketFlow.HANDOVER_TO_3PL.toString());
				saleOrder.setCurrentBranch_s(sourceBranch != null ? sourceBranch.getKey_s() : DEL_CPC_BRANCH);
				saleOrderService.updateCurrentStatusAndPacketHistory(saleOrder, toStstusKey);
				saleOrderDao.updateObject(saleOrder);
				
				//SaleOrderExtra
				SaleOrderExtra saleOrderExtraDB = saleOrderExtraDao.getObjectById(saleOrder.getKey_s(), SaleOrderExtra.class);
				if(saleOrderExtraDB == null) {
					SaleOrderExtra saleOrderExtra = new SaleOrderExtra();
					saleOrderExtra.setExpired_b(false);
					saleOrderExtra.setKey_s(saleOrder.getKey_s());
					saleOrderExtra.setClientKey_s(saleOrder.getClientKey_s());
					
					saleOrderExtraDao.saveObject(saleOrderExtra, SaleOrderExtra.class);
				}
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
