package com.bmp.oms.controller;
 
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bmp.bean.BulkUploadMasterBean;
import com.bmp.bean.c2c.SessionWebUserBean;
import com.bmp.bean.user.SessionUserBean;
import com.bmp.constant.DrsReportType;
import com.bmp.constant.FileDirectory;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.MessageConstant;
import com.bmp.dao.CityDao;
import com.bmp.dao.CountryDao;
import com.bmp.dao.PincodeDao;
import com.bmp.dao.StateDao;
import com.bmp.model.app.bulk.BulkHeader;
import com.bmp.model.app.bulk.BulkMaster;
import com.bmp.model.app.client.ClientCode;
import com.bmp.model.app.facility.User;
import com.bmp.model.app.masters.City;
import com.bmp.model.app.masters.Country;
import com.bmp.model.app.masters.Pincode;
import com.bmp.model.app.masters.State;
import com.bmp.oms.service.bulk.BulkMasterService;
import com.bmp.oms.service.bulk.BulkService;
import com.bmp.oms.service.client.ClientBillingService;
import com.bmp.oms.service.client.ClientCodeService;
import com.bmp.oms.service.client.ClientDashboardService;
import com.bmp.oms.service.client.ClientService;
import com.bmp.oms.service.drs.BranchCashClosingService;
import com.bmp.oms.service.drs.DrsService;
import com.bmp.oms.service.manifest.ManifestService;
import com.bmp.oms.service.masters.AWBSeriesService;
import com.bmp.oms.service.masters.CityService;
import com.bmp.oms.service.masters.CountryService;
import com.bmp.oms.service.masters.PincodeService;
import com.bmp.oms.service.masters.ServiceablePincodeService;
import com.bmp.oms.service.masters.StateService;
import com.bmp.oms.service.saleorder.PickupSheetService;
import com.bmp.oms.service.saleorder.RemittanceService;
import com.bmp.oms.service.saleorder.ReportService;
import com.bmp.oms.service.saleorder.SaleOrderService;
import com.bmp.oms.service.systemCalling.CallManifestService;
import com.bmp.oms.service.systemCalling.SendManualSmsService;
import com.bmp.oms.service.threePL.ThreePLDocketBeanService;
import com.bmp.oms.service.wms.OrderService;
import com.bmp.oms.service.wms.StockTransferNoteService;
import com.bmp.solr.common.ISolrSearchDao;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@Controller
@RequestMapping("/download")
public class FileDownloadController {
    
	@Autowired
	ApplicationContext applicationContext;
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("bulkMasterService")
	private BulkMasterService bulkMasterService;
	
	@Autowired
	@Qualifier("bulkService")
	private BulkService bulkService;
	
	@Autowired	
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;
	
	@Autowired	
	@Qualifier("awbSeriesServiceImp")
	private AWBSeriesService awbSeriesService;
	
	@Autowired	
	@Qualifier("serviceablePincodeServiceImpl")
	private ServiceablePincodeService serviceablePincodeService; 
	
	@Autowired	
	@Qualifier("threePLDocketBeanServiceImpl")
	private ThreePLDocketBeanService threePLDocketBeanService;
	
	@Autowired
	@Qualifier("stockTransferNoteServiceImpl")
	private StockTransferNoteService stockTransferNoteService;
	
	@Autowired
	@Qualifier("orderServiceImpl")
	private OrderService orderService;
	
	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;
	
	@Autowired
	@Qualifier("pickupSheetServiceImpl")
	private PickupSheetService pickupSheetService;
	
	@Autowired
	@Qualifier("manifestServiceImpl")
	private ManifestService manifestService;
	
	@Autowired
	@Qualifier("drsServiceImpl")
	private DrsService drsService;
	
	@Autowired
	@Qualifier("clientServiceImpl")
	private ClientService clientService;
	
	@Autowired
	@Qualifier("remittanceServiceImpl")
	private RemittanceService remittanceService;
	
	@Autowired
	@Qualifier("reportServiceImpl")
	private ReportService reportService;
	
	@Autowired
	@Qualifier("branchCashClosingServiceImpl")
	private BranchCashClosingService branchCashClosingService;
	
	@Autowired
	@Qualifier("saleOrderServiceImpl")
	private SaleOrderService saleOrderService;
	
	@Autowired
	@Qualifier("clientDashboardServiceImpl")
	private ClientDashboardService clientDashboardService;
	
	@Autowired
	@Qualifier("sessionWebUserBean")
	private SessionWebUserBean sessionWebUserBean;
	
	@Autowired
	@Qualifier("callManifestServiceImpl")
	private CallManifestService callManifestService;
	
	@Autowired
	@Qualifier("sendManualSmsServiceImpl")
	private SendManualSmsService sendManualSmsService;
	
	@Autowired
	@Qualifier("clientCodeServiceImpl")
	private ClientCodeService clientCodeService;
	
	@Autowired
	@Qualifier("cityServiceImpl")
	private CityService cityService;
	
	@Autowired
	@Qualifier("stateServiceImpl")
	private StateService stateService;
	
	@Autowired
	@Qualifier("countryServiceImpl")
	private CountryService countryService;
	
	@Autowired
	@Qualifier("pincodeServiceImpl")
	private PincodeService pincodeService;

	@Autowired
	@Qualifier("clientBillingServiceImpl")
	private ClientBillingService clientBillingService;
	
	@RequestMapping(value="/dump/{type}", method = RequestMethod.GET)
    public void downloadDumpFile(HttpServletResponse response, @PathVariable("type") String type) throws IOException {
        String fileType = null;
        User user = sessionUserBean.getUser();
        FileDirectory fileDirectory = FileDirectory.getFileDirectory(type);
        switch (fileDirectory) {
	        case STATEMASTER:
	        case CITYMASTER:
        	case COUNTRYMASTER:
        	case PINCODEMASTER:
			case PINCODEDIRECTORY:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			default:{
				break;
			}
		}
        if(GlobalConstant.BULK_TEMPLATE.equals(fileType)){
        	try {
        		String fileName = null;
        		BulkMaster bulkMaster = bulkMasterService.getMasterByKey(type);
        		Object dao = applicationContext.getBean(bulkMaster.getDaoName());
        		BulkUploadMasterBean bean2 = new BulkUploadMasterBean();
        		List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();
        		if(dao instanceof PincodeDao){
        			PincodeDao pincodeDao = (PincodeDao) dao;
        			List<Pincode> pincodes = pincodeDao.getAllObjects(Pincode.class);
        			listData = getExportData(pincodes);
        		} else if(dao instanceof CityDao){
        			CityDao cityDao = (CityDao) dao;
        			List<City> cities = cityDao.getAllObjects(City.class);
        			listData = getExportData(cities);
        		} else if(dao instanceof StateDao){
        			StateDao stateDao = (StateDao) dao;
        			List<State> states = stateDao.getAllObjects(State.class);
        			listData = getExportData(states);
        		} else if(dao instanceof CountryDao){
        			CountryDao countryDao = (CountryDao) dao;
        			List<Country> countries = countryDao.getAllObjects(Country.class);
        			listData = getExportData(countries);
        		}
        		bean2.setSuccessRecords(listData);
        		bean2.setCurrentUser(user.getLoginId());
    			bean2.setBulkMaster(bulkMaster);
    			fileName = bulkService.writeFile(bean2, new ArrayList<BulkHeader>(bulkMaster.getBulkHeaderMap().values()),GlobalConstant.DUMP_STRING);
        		downloadFile(new File(fileName),response);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
	
	@SuppressWarnings("unchecked")
	List<Map<String,Object>> getExportData(List<?> cities){
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		for (Object city : cities) {
			ObjectMapper mapper = new ObjectMapper();
			Map<String,Object> props = mapper.convertValue(city, Map.class);
			Iterator<String> iterator = props.keySet().iterator();
			while (iterator.hasNext()) {
				String mapKey = iterator.next();
				if(props.get(mapKey) != null){
					if(props.get(mapKey).toString().contains("{")){
						Map<String,Object> innerObject = (Map<String, Object>) props.get(mapKey);
						props.put(mapKey, innerObject.get("key_s"));
					}
				}
			}
			data.add(props);
		}
		return data;
	}
	
	@RequestMapping(value="/template/{type}", method = RequestMethod.GET)
    public void downloadTemplateFile(@PathVariable("type") String type, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileType = null;
        FileDirectory fileDirectory = FileDirectory.getFileDirectory(type);
        String clientKey = null;
        String clientCategory = null;
        switch (fileDirectory) {
	        case STATEMASTER:
	        case CITYMASTER:
        	case COUNTRYMASTER:
        	case PINCODEMASTER:
			case PINCODEDIRECTORY:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case SERVICEABLEPINCODE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case STAGINGSALEORDER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				clientKey = request.getParameter("clientKey");
		        clientCategory = request.getParameter("clientCategory");
				break;
			}
			case STAGINGBULKSALEORDER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				clientKey = request.getParameter("clientKey");
		        clientCategory = request.getParameter("clientCategory");
				break;
			}
			case AWBSERIES:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case UPLOADLBH:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case THREEPLCOURIERTOSALEORDER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case UPLOAD_3PL_REMMITTANCE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case THREEPL_STATUS_UPDATE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case PICKUP_REQUEST_MASTER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case BULK_INSCAN:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CLIENT_SKU_WEIGTH_LOOKER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CLIENT_BILLING_LBH_UPLOAD:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CTOC_BULK:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case UPDATE_CLIENT_BILL:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case UPDATE_DELIVERED_PERSON_DETAILS:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case RECONNECT_BULK:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case UPDATE_COURIER_AWB:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case REDIRECT_BULK:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CHANGE_AWB_SERIES_PRODUCT_TYPE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CLIENT_CODE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CLIENT_PRODUCT_SKU_RATE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CHANNEL_ORDER_BULK_UPLOAD:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case RAL_SALEORDER_UPDATE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CATALOGUEBUKLUPLOAD:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case STN_BULK_UPLOAD:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case MARKETPLACE_SKU_MAPPING:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case PO_UPLOAD:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			default:{
				break;
			}
		}
        if(GlobalConstant.BULK_TEMPLATE.equals(fileType)){
        	try {
        		if((fileDirectory.equals(FileDirectory.STAGINGSALEORDER) || fileDirectory.equals(FileDirectory.STAGINGBULKSALEORDER) )&& clientKey != null && clientCategory != null){
        			String filename = createOrderFile(fileDirectory, GlobalConstant.TEMPLATE_STRING, clientKey, clientCategory);
            		downloadFile(new File(filename),response);
        		} else {
        			String filename = createFileFile(fileDirectory,GlobalConstant.TEMPLATE_STRING);
            		downloadFile(new File(filename),response);
        		}
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
	
	private String createOrderFile(FileDirectory fileDirectory, String fileType, String clientKey, String clientCategory) throws Exception {
		User user = sessionUserBean.getUser();
		BulkMaster bulkMaster = bulkMasterService.getMasterByKey(fileDirectory.getFileDirectory());
		List<BulkHeader> bulkHeaderList = new ArrayList<BulkHeader>(bulkMaster.getBulkHeaderMap().values());
		if(clientKey != null && !"".equals(clientKey.trim()) && clientCategory != null && !"".equals(clientCategory.trim()) ){
			List<BulkHeader> qcHeaderList = clientService.getClientQcHeaders(clientKey, clientCategory);
			if(qcHeaderList != null && qcHeaderList.size() > 0){
				bulkHeaderList.addAll(qcHeaderList);
			}
		}
		
		BulkUploadMasterBean bean = new BulkUploadMasterBean();
		if(user != null){
			bean.setCurrentUser(user.getLoginId());
		}else{
			bean.setCurrentUser(sessionWebUserBean.getWebUser().getKey_s());
		}
		bean.setBulkMaster(bulkMaster);
		return bulkService.writeFile(bean, bulkHeaderList, fileType);
	}

	@RequestMapping(value="/error/{type}", method = RequestMethod.GET)
    public void downloadErrorFile(HttpServletResponse response, @PathVariable("type") String type) throws IOException {
        String fileType = null;
        User user = sessionUserBean.getUser();
        FileDirectory fileDirectory = FileDirectory.getFileDirectory(type);
        switch (fileDirectory) {
	        case STATEMASTER:
	        case CITYMASTER:
        	case COUNTRYMASTER:
        	case PINCODEMASTER:
        	case ORDER_CONVERTER:
			case PINCODEDIRECTORY:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case SERVICEABLEPINCODE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case STAGINGSALEORDER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case STAGINGBULKSALEORDER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case UPLOAD_3PL_REMMITTANCE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case THREEPL_STATUS_UPDATE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case UPLOADLBH:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case AWBSERIES:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case THREEPLCOURIERTOSALEORDER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case SALEORDER_PICKUP_REQUEST_MASTER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case BULK_INSCAN:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CLIENT_SKU_WEIGTH_LOOKER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CTOC_BULK:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case UPDATE_CLIENT_BILL:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case UPDATE_DELIVERED_PERSON_DETAILS:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case RECONNECT_BULK:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case UPDATE_COURIER_AWB:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case REDIRECT_BULK:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CHANGE_AWB_SERIES_PRODUCT_TYPE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CLIENT_CODE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case CLIENT_PRODUCT_SKU_RATE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case RAL_SALEORDER_UPDATE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CHANNEL_ORDER_BULK_UPLOAD:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CATALOGUEBUKLUPLOAD:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case STN_BULK_UPLOAD:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case MARKETPLACE_SKU_MAPPING:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case PO_UPLOAD:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			
			default:{
				break;
			}
		}
        if(GlobalConstant.BULK_TEMPLATE.equals(fileType)){
        	try {
        		String filename = null;
        		if(user != null){
        			filename = bulkService.getFileName(type, user.getLoginId(), GlobalConstant.ERROR_STRING);
        		}else{
        			filename = bulkService.getFileName(type, sessionWebUserBean.getWebUser().getKey_s(), GlobalConstant.ERROR_STRING);
        		}
        		downloadFile(new File(filename),response);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
	
	@RequestMapping(value="/success/{type}", method = RequestMethod.GET)
    public void downloadSuccessFile(HttpServletResponse response, @PathVariable("type") String type) throws IOException {
        String fileType = null;
        User user = sessionUserBean.getUser();
        FileDirectory fileDirectory = FileDirectory.getFileDirectory(type);
        switch (fileDirectory) {
	        case STATEMASTER:
	        case CITYMASTER:
        	case COUNTRYMASTER:
        	case PINCODEMASTER:
        	case ORDER_CONVERTER:
			case PINCODEDIRECTORY:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case SERVICEABLEPINCODE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case STAGINGSALEORDER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case STAGINGBULKSALEORDER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case UPLOAD_3PL_REMMITTANCE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case THREEPL_STATUS_UPDATE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case UPLOADLBH:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case AWBSERIES:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case THREEPLCOURIERTOSALEORDER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case SALEORDER_PICKUP_REQUEST_MASTER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case DOWNLOAD_AWBSERIES:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case BULK_INSCAN:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CLIENT_SKU_WEIGTH_LOOKER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CTOC_BULK:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case UPDATE_CLIENT_BILL:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case UPDATE_DELIVERED_PERSON_DETAILS:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case RECONNECT_BULK:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case UPDATE_COURIER_AWB:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case REDIRECT_BULK:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CHANGE_AWB_SERIES_PRODUCT_TYPE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CLIENT_CODE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CLIENT_PRODUCT_SKU_RATE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CHANNEL_ORDER_BULK_UPLOAD:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case RAL_SALEORDER_UPDATE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CATALOGUEBUKLUPLOAD:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case STN_BULK_UPLOAD:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case MARKETPLACE_SKU_MAPPING:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case PO_UPLOAD:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			default:{
				break;
			}
		}
        if(GlobalConstant.BULK_TEMPLATE.equals(fileType)){
        	try {
        		String filename = null;
        		if(user != null){
        			filename = bulkService.getFileName(type, user.getLoginId(), GlobalConstant.SUCCESS_STRING);
        		}else{
        			filename = bulkService.getFileName(type, sessionWebUserBean.getWebUser().getKey_s(), GlobalConstant.SUCCESS_STRING);
        			
        		}
        		downloadFile(new File(filename),response);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }

	private String createFileFile(FileDirectory fileDirectory,String fileType) throws Exception{
		User user = sessionUserBean.getUser();
		BulkMaster bulkMaster = bulkMasterService.getMasterByKey(fileDirectory.getFileDirectory());
		bulkMaster.getBulkHeaderMap().values();
		BulkUploadMasterBean bean = new BulkUploadMasterBean();
		if(user != null){
			bean.setCurrentUser(user.getLoginId());
		}else{
			bean.setCurrentUser(sessionWebUserBean.getWebUser().getKey_s());
		}
		bean.setBulkMaster(bulkMaster);
		return bulkService.writeFile(bean, new ArrayList<BulkHeader>(bulkMaster.getBulkHeaderMap().values()),fileType);
	}
	
	public void downloadFile(File file,HttpServletResponse response) throws IOException{
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
	}
	
	@RequestMapping(value="/download/{type}", method = RequestMethod.GET)
    public void downloadExcels(@PathVariable("type") String type,@RequestParam(value = "key") String key,@RequestParam(value = "awnbType") String awnbType, HttpServletRequest request,HttpServletResponse response) throws IOException {
        String fileType = null;
        FileDirectory fileDirectory = FileDirectory.getFileDirectory(type);
        String query = "";
        String entitytype = "";
        switch (fileDirectory) {
			case AWBSERIES:{
				fileType = GlobalConstant.BULK_TEMPLATE;
        		query = key;
        		entitytype = awnbType;
				break;
			}
			case SERVICEABLEPINCODE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case THREEPLREPORT:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case FINALIZED_REMITTANCE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case MANIFEST_EXCEL_REPORT:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case PENDING_COD_VERIFY:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case OPEN_CLOSE_PACKETS:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case OPEN_RTO_PACKET:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case ZONE_WISE_PACKET:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case RTO_REASON_PCKTS:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case RTO_RECEIVE_REPORT:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case REDIRECT_BULK:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CALL_MANIFEST_REPORT:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}case CALL_MANIFEST_CLOSED_REPORT:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case MANUAL_SMS_REPORT:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case CLIENT_CODE_REPORT:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case TELECALLING_MANIFEST_REPORT:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case ORDER_SKU_MAP:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case PENDING_FOR_DRS_REPORT:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case PENDING_FOR_COD_BRANCH_CLOSING:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				entitytype = awnbType;
				break;
			}
			case PENDING_FOR_COD_RECEIVE_REPORT:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case CITYMASTER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case COUNTRYMASTER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case PICKLISTREPORT:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case ORDERPICKLIST:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case ORDERPACKLIST:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case STATEMASTER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case PINCODEMASTER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			case CLIET_BILLING_REPORT:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			
			default:{
				break;//
			}
		}
        if(GlobalConstant.BULK_TEMPLATE.equals(fileType)){
        	try {
        		String filename = null;
        		if(fileDirectory.equals(FileDirectory.AWBSERIES)){
        			 filename = downloadExcelReport(fileDirectory, awbSeriesService.excelRecordMap(query,entitytype));
        		}
        		else if (fileDirectory.equals(FileDirectory.SERVICEABLEPINCODE)) {
        			filename = downloadExcelReport(fileDirectory, serviceablePincodeService.excelPincodeRecordMap(key));
				}
        		else if (fileDirectory.equals(FileDirectory.THREEPLREPORT)) {
        			filename = downloadExcelReport(fileDirectory, threePLDocketBeanService.excelRecordMap(key));
				}
        		else if (fileDirectory.equals(FileDirectory.FINALIZED_REMITTANCE)) {
        			filename = downloadExcelReport(fileDirectory, remittanceService.excelRecord(key));
				}
        		else if (fileDirectory.equals(FileDirectory.MANIFEST_EXCEL_REPORT)) {
        			filename = downloadExcelReport(fileDirectory, manifestService.manifestExcelReport(key));
				}
        		else if (fileDirectory.equals(FileDirectory.PENDING_COD_VERIFY)) {
        			filename = downloadExcelReport(fileDirectory, branchCashClosingService.saleOrderExcelReport(key));
				}
        		else if (fileDirectory.equals(FileDirectory.OPEN_CLOSE_PACKETS)) {
        			filename = downloadExcelReport(fileDirectory, clientDashboardService.openClosePacketExcelReport(key));
				}
        		else if (fileDirectory.equals(FileDirectory.OPEN_RTO_PACKET)) {
        			filename = downloadExcelReport(fileDirectory, clientDashboardService.openRtoPacketExcelReport(key));
				}
        		else if (fileDirectory.equals(FileDirectory.ZONE_WISE_PACKET)) {
        			filename = downloadExcelReport(fileDirectory, clientDashboardService.openZoneWisePacketExcelReport(key));
				}
        		else if (fileDirectory.equals(FileDirectory.RTO_REASON_PCKTS)) {
        			filename = downloadExcelReport(fileDirectory, clientDashboardService.rtoReasonPcktsExcelReport(key));
				}
        		else if (fileDirectory.equals(FileDirectory.RTO_RECEIVE_REPORT)) {
        			filename = downloadExcelReport(fileDirectory, saleOrderService.getReceivingRecordMap(key));
				}
        		else if (fileDirectory.equals(FileDirectory.CALL_MANIFEST_REPORT)) {
        			filename = downloadExcelReport(fileDirectory, callManifestService.getCallManifestReport(key));
				}
        		else if (fileDirectory.equals(FileDirectory.CALL_MANIFEST_CLOSED_REPORT)) {
        			filename = downloadExcelReport(fileDirectory, callManifestService.getCallManifestReport(key));
				}
        		else if (fileDirectory.equals(FileDirectory.MANUAL_SMS_REPORT)) {
        			filename = downloadExcelReport(fileDirectory, sendManualSmsService.getSendManualReport(key));
				}
        		else if (fileDirectory.equals(FileDirectory.CLIENT_CODE_REPORT)) {
        			filename = downloadExcelReport(fileDirectory, clientCodeService.getClientCodeReport());
				}
        		else if (fileDirectory.equals(FileDirectory.TELECALLING_MANIFEST_REPORT)) {
        			filename = downloadExcelReport(fileDirectory, saleOrderService.getTeleCallingManifestReport(key));
				}
        		else if (fileDirectory.equals(FileDirectory.ORDER_SKU_MAP)) {
        			filename = downloadExcelReport(fileDirectory, saleOrderService.getOrderSkuMapReport(key));
				}
        		else if(fileDirectory.equals(FileDirectory.PENDING_FOR_DRS_REPORT)) {
        			filename = downloadExcelReport(fileDirectory, saleOrderService.getPendingForDrsReport(key));
        		}
        		else if(fileDirectory.equals(FileDirectory.PENDING_FOR_COD_BRANCH_CLOSING)) {
        			filename = downloadExcelReport(fileDirectory, branchCashClosingService.getPendingForCODBranchClosingReport(key, entitytype));
        		}
        		else if(fileDirectory.equals(FileDirectory.PENDING_FOR_COD_RECEIVE_REPORT)) {
        			filename = downloadExcelReport(fileDirectory, saleOrderService.getPendingForCODReceiveReport(key));
        		}
        		else if(fileDirectory.equals(FileDirectory.CITYMASTER)) {
        			filename = downloadExcelReport(fileDirectory, countryService.getCountryStateCityPincodeReport(key));
        		}
        		else if(fileDirectory.equals(FileDirectory.STATEMASTER)) {
        			filename = downloadExcelReport(fileDirectory, countryService.getCountryStateCityPincodeReport(key));
        		}
        		else if(fileDirectory.equals(FileDirectory.COUNTRYMASTER)) {
        			filename = downloadExcelReport(fileDirectory, countryService.getCountryStateCityPincodeReport(key));
        		}
        		else if(fileDirectory.equals(FileDirectory.PICKLISTREPORT)) {
        			filename = downloadExcelReport(fileDirectory, stockTransferNoteService.pickListReport(key));
        		}
        		else if(fileDirectory.equals(FileDirectory.ORDERPICKLIST)) {
        			filename = downloadExcelReport(fileDirectory, orderService.orderPickList(key));
        		}
        		else if(fileDirectory.equals(FileDirectory.ORDERPACKLIST)) {
        			filename = downloadExcelReport(fileDirectory, orderService.orderPackList(key));
        		}
        		else if(fileDirectory.equals(FileDirectory.CLIET_BILLING_REPORT)) {
        			filename = downloadExcelReport(fileDirectory, clientBillingService.generateClientBillExcell(key));
        		}
        		//
        		downloadFile(new File(filename),response);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
	
	private String downloadExcelReport(FileDirectory fileDirectory, List<Map<String, Object>> records) throws Exception{
		User user = sessionUserBean.getUser();
		BulkMaster bulkMaster = bulkMasterService.getMasterByKey(fileDirectory.getFileDirectory());
		BulkUploadMasterBean bean = new BulkUploadMasterBean();
		bean.setCurrentUser(user.getLoginId());
		bean.setBulkMaster(bulkMaster);
		bean.setSuccessRecords(records);
		bean.setRecords(records);
		return bulkService.writeFile(bean, new ArrayList<BulkHeader>(bulkMaster.getBulkHeaderMap().values()),GlobalConstant.SUCCESS_STRING);
	}
	
	@RequestMapping(value="/downloadPDF/{type}", method = RequestMethod.GET)
    public void downloadPDF(@PathVariable("type") String type,@RequestParam(value = "key") String key, HttpServletRequest request,HttpServletResponse response) throws IOException {
        String fileType = null;
        FileDirectory fileDirectory = FileDirectory.getFileDirectory(type);
        String fileName = null;
        User user = sessionUserBean.getUser();
        switch (fileDirectory) {
			case PICKUPSHEET:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				fileName = "PickupSheetReports"+user.getKey_s()+".pdf";
				break;
			}
			case MANIFEST:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				fileName = "ManifestReports"+user.getKey_s()+".pdf";
				break;
			}
			case DRS:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				fileName = "DrsReports"+user.getKey_s()+".pdf";
				break;
			}
			case PENDINGPOD:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				fileName = "PendingPod"+user.getKey_s()+".pdf";
				break;
			}
			case MANIFEST_BAG_PACK:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				fileName = "ManifearBagPacket"+user.getKey_s()+".pdf";
				break;
			}
			case PICKUPSHEETQC:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				fileName = "PickupSheetQC"+user.getKey_s()+".pdf";
				break;
			}
			case CLIENT_INVOICE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				fileName = "clientInvoice"+user.getKey_s()+".pdf";
				break;
			}
			case RTO_RECEIVE:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				fileName = "rtoReceive"+user.getKey_s()+".pdf";
				break;
			}
		
			default:{
				break;
			}
		}
        if(GlobalConstant.BULK_TEMPLATE.equals(fileType)){
        	try {
        		response.setContentType("application/pdf");
    			response.setHeader("Content-disposition", "attachment; filename=" + fileName);
    			ByteArrayOutputStream baos = new ByteArrayOutputStream();
    			OutputStream os = response.getOutputStream();
    			String path = "";
        		if(fileDirectory.equals(FileDirectory.PICKUPSHEET)){
        			
        			path = messageSource.getMessage(MessageConstant.PICKUP_PATH, null, null);
        			path = path+"/"+fileName;
    				pickupSheetService.createPDF(path, key, request);
    				baos = pickupSheetService.convertPDFToByteArrayOutputStream(path);
        			
        		}else if (fileDirectory.equals(FileDirectory.PICKUPSHEETQC)) {
        			path = messageSource.getMessage(MessageConstant.QC_PATH, null, null);
        			path = path+"/"+fileName;
        			pickupSheetService.createQCPDF(path, key, request);
    				baos = pickupSheetService.convertPDFToByteArrayOutputStream(path);
    				
        		}else if (fileDirectory.equals(FileDirectory.MANIFEST)) {
        			path = messageSource.getMessage(MessageConstant.DRS_PATH, null, null);
        			path = path+"/"+fileName;
    				manifestService.createPDF(path,key, request);
    				baos = manifestService.convertPDFToByteArrayOutputStream(path);
        			
				}else if (fileDirectory.equals(FileDirectory.MANIFEST_BAG_PACK)) {
        			
    				manifestService.createPDFManifestBagShipment(fileName,key, request);
    				baos = manifestService.convertPDFToByteArrayOutputStream(fileName);
        			
				}else if (fileDirectory.equals(FileDirectory.DRS)) {
					path = messageSource.getMessage(MessageConstant.DRS_PATH, null, null);
        			path = path+"/"+fileName;
					drsService.createPDF(path,key, request);
					baos = drsService.convertPDFToByteArrayOutputStream(path);
						
				}else if (fileDirectory.equals(FileDirectory.PENDINGPOD)) {
					
					pickupSheetService.createPDF(fileName, key, request);
    				baos = pickupSheetService.convertPDFToByteArrayOutputStream(fileName);
						
				}else if (fileDirectory.equals(FileDirectory.CLIENT_INVOICE)) {
					path = messageSource.getMessage(MessageConstant.DRS_PATH, null, null);
        			path = path+"/"+fileName;
					clientService.createPDF(path, key, request);
    				baos = clientService.convertPDFToByteArrayOutputStream(path);
						
				} else if (fileDirectory.equals(FileDirectory.RTO_RECEIVE)) {
					path = messageSource.getMessage(MessageConstant.RTO_RECEIVE_PATH, null, null);
        			path = path+"/"+fileName;
        			saleOrderService.createPDF(path, key, request);
    				baos = clientService.convertPDFToByteArrayOutputStream(path);
						
				}
				baos.writeTo(os);
				os.flush();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
	
	@RequestMapping(value="/report/{type}", method = RequestMethod.GET)
    public void downloadReportFile(HttpServletResponse response, @PathVariable("type") String type,@RequestParam(value = "key") String key) throws IOException {
        String fileType = null;
        User user = sessionUserBean.getUser();
        FileDirectory fileDirectory = FileDirectory.getFileDirectory(type);
        switch (fileDirectory) {
			case SALEORDER:{
				fileType = GlobalConstant.BULK_TEMPLATE;
				break;
			}
			default:{
				break;
			}
		}
        if(GlobalConstant.BULK_TEMPLATE.equals(fileType)){
        	try {
        		String filename = bulkService.getFileName(type, user.getLoginId(), GlobalConstant.SUCCESS_STRING);
        		downloadFile(new File(filename),response);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
	
	@RequestMapping(value = "/getLastThreeStatusReport", method = RequestMethod.POST)
	public void uploadData(@RequestParam("type") String type,@RequestParam("filterType") String filterType, @RequestParam("awbNumber") String awbNumber, 
			HttpServletRequest request, HttpServletResponse response) {

		String filename = null;
		FileDirectory fileDirectory = FileDirectory.getFileDirectory(type);

		try {
			//filename = downloadExcelReport(fileDirectory, reportService.lastThreeStatusExcelRecordMap(awbNumber));
			filename = downloadExcelReport(fileDirectory, reportService.newlastThreeStatusExcelRecordMap(awbNumber,filterType));

			downloadFile(new File(filename), response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@RequestMapping(value = "/getPartnerPendency/{type}", method = RequestMethod.GET)
	public void getPartnerPendency(@PathVariable("type") DrsReportType drsReportType,@RequestParam(value="courier") String courier,HttpServletRequest request, HttpServletResponse response) {

		String filename = null;
		String type = "partnerPendencyReport";
		FileDirectory fileDirectory = FileDirectory.getFileDirectory(type);

		try {
			filename = downloadExcelReport(fileDirectory, reportService.getPartnerPendency(drsReportType,courier));

			downloadFile(new File(filename), response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@RequestMapping(value="/file/{type}", method = RequestMethod.GET)
    public void fileDownload(HttpServletResponse response, @PathVariable("type") String type, @RequestParam(value = "key") String key) throws IOException {
        String bulkDir = null;
        FileDirectory fileDirectory = FileDirectory.getFileDirectory(type);
        switch (fileDirectory) {
			case SYSTEMREPORTS:{
				bulkDir = messageSource.getMessage(GlobalConstant.REPORT_DIRECTORY, null, null);
				break;
			}
			default:{
				break;
			}
		}
    	try {
    		String filename = bulkDir+GlobalConstant.SEPERATOR_SLASH+key;
    		downloadFile(new File(filename),response);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	@RequestMapping(value="/c2cTemplate/{type}", method = RequestMethod.GET)
    public void downloadCTOCBulkTempleate( @PathVariable("type") String fileName, HttpServletResponse response, HttpServletRequest request) throws IOException {
    	try {
    		response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + fileName+".xls" +"\""));
            File file = new File(request.getSession().getServletContext().getRealPath("/static/doc/"+fileName+".xls"));
            response.setContentLength((int)file.length());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	@RequestMapping(value="/downloadSrcToDestBill", method = RequestMethod.GET)
	public void downloadClientDummyBill( HttpServletResponse response, HttpServletRequest request) throws IOException {
		try {
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=bill.pdf");
			clientBillingService.generateSrcToDestBillPdf(response.getOutputStream(),request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}