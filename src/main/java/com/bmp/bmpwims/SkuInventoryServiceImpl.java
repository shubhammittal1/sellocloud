package com.bmp.bmpwims;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import com.bmp.constant.*;
import com.bmp.oms.service.api.marketplace.MarketplaceService;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.bmp.bean.ProductSearchResponseBean;
import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.bean.user.SessionUserBean;
import com.bmp.dao.wms.CatalogueDao;
import com.bmp.dao.wms.PurchaseOrderDao;
import com.bmp.dao.wms.SkuInventoryDao;
import com.bmp.dao.wms.WarehouseLocationDao;
import com.bmp.model.app.wms.Catalogue;
import com.bmp.model.app.wms.SkuInventory;
import com.bmp.model.app.wms.WarehouseLocationMaster;
import com.bmp.oms.service.api.VendorApiService;
import com.bmp.utility.apiUtility.HttpRequestBeanNew;
import com.bmp.utility.apiUtility.HttpUtilittyNew;
import java.sql.Connection;
import java.sql.Statement;

@Service
@Qualifier("skuInventoryImpl")
public class SkuInventoryServiceImpl implements SkuInventoryService {

	@Qualifier("skuInventoryRepo")
	@Autowired
	private SkuInventoryDao skuInventoryDao;

	@Qualifier("catalogueDaoImpl")
	@Autowired
	private CatalogueDao catalogueDao;

	@Qualifier("warehouseLocationDaoImpl")
	@Autowired
	private WarehouseLocationDao warehouseLocationDao;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;

	@Qualifier("purchaseOrderDaoImpl")
	@Autowired
	private PurchaseOrderDao purchaseOrderDao;

	
	@Qualifier("vendorApiServiceImpl")
	@Autowired
	private VendorApiService vendorApiService;

	@Autowired
	@Qualifier("marketplaceServiceImpl")
	private MarketplaceService marketplaceService;

	@Override
	public DatatableResponseBean getAllSkuInventory(DatatableRequestBean datatableRequestBean) {
		DatatableResponseBean datatableResponseBean = new DatatableResponseBean();
		try {
			/*
			 * List<String> skuName = null; List<String> warehouseLocation = null; if
			 * (datatableRequestBean.getData() != null &&
			 * !datatableRequestBean.getData().isEmpty()) { if
			 * (datatableRequestBean.getData().get("skuName") != null &&
			 * !"".equals(datatableRequestBean.getData().get("skuName"))) { skuName =
			 * Arrays.asList(datatableRequestBean.getData().get("skuName").split(",")); } if
			 * (datatableRequestBean.getData().get("warehouseLocation") != null &&
			 * !"".equals(datatableRequestBean.getData().get("warehouseLocation"))) {
			 * warehouseLocation =
			 * Arrays.asList(datatableRequestBean.getData().get("warehouseLocation").split(
			 * ",")); }
			 * 
			 * }
			 * 
			 * Query query = new Query(); if (skuName != null) {
			 * query.addCriteria(Criteria.where("skuName").in(skuName)); } if
			 * (warehouseLocation != null) {
			 * query.addCriteria(Criteria.where("warehouseKey").in(warehouseLocation)); }
			 * 
			 * int count = 0; if (datatableRequestBean.getRecordsTotal() <= 0) { count =
			 * skuInventoryDao.getAllObjectCount(SkuInventory.class); } else { count =
			 * datatableRequestBean.getRecordsTotal(); }
			 * 
			 * 
			 * query.skip(datatableRequestBean.getStart());
			 * query.limit(datatableRequestBean.getLength());
			 * 
			 * if (datatableRequestBean.getSearch() != null &&
			 * !datatableRequestBean.getSearch().trim().isEmpty()) { String search =
			 * datatableRequestBean.getSearch().trim();
			 * 
			 * List<Criteria> orCriteria = new ArrayList<Criteria>();
			 * orCriteria.add(Criteria.where("_id").regex(search,
			 * GlobalConstant.CASE_SENSITIVE));
			 * orCriteria.add(Criteria.where("skuCode").regex(search,
			 * GlobalConstant.CASE_SENSITIVE));
			 * orCriteria.add(Criteria.where("skuName").regex(search,
			 * GlobalConstant.CASE_SENSITIVE));
			 * orCriteria.add(Criteria.where("warehouseKey").regex(search,
			 * GlobalConstant.CASE_SENSITIVE));
			 * 
			 * Criteria[] criteriaArray = new Criteria[orCriteria.size()]; criteriaArray =
			 * orCriteria.toArray(criteriaArray);
			 * 
			 * query.addCriteria(new Criteria().orOperator(criteriaArray)); }
			 * 
			 * if (datatableRequestBean.getOrder() != null &&
			 * !datatableRequestBean.getOrder().isEmpty()) { List<String> list =
			 * datatableRequestBean.getOrder().get(0); int columnNumber =
			 * Integer.parseInt(list.get(0)); String orderBy = list.get(1); switch
			 * (columnNumber) { case 0: if (orderBy.equals(GlobalConstant.ASC)) {
			 * query.with(Sort.by(Sort.Direction.ASC, "createdDate_l")); } else {
			 * query.with(Sort.by(Sort.Direction.DESC, "createdDate_l")); } break; } }
			 */
			int skip = datatableRequestBean.getLength() * datatableRequestBean.getPage();
			// List<Map<String,Object>> skuMapList = new ArrayList<>();
			// List<SkuInventory> resultList = skuInventoryDao.getObjectByQuery(query,
			// SkuInventory.class);
			List<Map<String, Object>> resultList = skuInventoryDao.getAllSkuInventory(skip,
					datatableRequestBean.getSearch().trim());
			int totalCount = skuInventoryDao.getAllSkuInventoryCount();
			/*
			 * for (SkuInventory skuInventory : resultList) { Catalogue catalogue =
			 * catalogueDao.getCatalogueBySkuCode(skuInventory.getSkuCode());
			 * if(!catalogue.isApproved()) { continue; } WarehouseLocationMaster
			 * locationMaster =
			 * warehouseLocationDao.getObjectById(skuInventory.getWarehouseLocationKey(),
			 * WarehouseLocationMaster.class); if(locationMaster!=null &&
			 * locationMaster.isVirtualLocation()) { continue; }
			 * 
			 * Map<String,Object>map = new HashMap<>(); map.put("key_s",
			 * skuInventory.getKey_s()); map.put("skuCode", skuInventory.getSkuCode());
			 * map.put("skuName", skuInventory.getSkuName()); map.put("skuImageUrls",
			 * skuInventory.getSkuImageUrls()); map.put("warehouseKey",
			 * skuInventory.getWarehouseKey()); map.put("goodQty",
			 * skuInventory.getGoodQty()); map.put("badQty", skuInventory.getBadQty());
			 * map.put("totalQty", skuInventory.getTotalQty()); map.put("clientKey",
			 * skuInventory.getClientKey()); if(locationMaster!=null){
			 * map.put("warehouseLocationKey", locationMaster.getLocationName());
			 * map.put("warehouseLocationType", locationMaster.getLocationType()); }else {
			 * map.put("warehouseLocationKey", ""); map.put("warehouseLocationType", ""); }
			 * skuMapList.add(map);
			 * 
			 * }
			 */
			if (resultList != null && resultList.size() > 0) {
				datatableResponseBean.setData(resultList);
				datatableResponseBean.setDraw(datatableRequestBean.getDraw());
				datatableResponseBean.setRecordsFiltered(totalCount);
				datatableResponseBean.setRecordsTotal(totalCount);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return datatableResponseBean;
	}

	@Override
	public DatatableResponseBean getSkuInventoryTableByClientAndWarehouseKey(
			DatatableRequestBean datatableRequestBean) {
		DatatableResponseBean datatableResponseBean = new DatatableResponseBean();
		try {
			String clientKey = "", warehouseKey = "", skuCode = "", location = "", locationType = "",
					isVirtualLocation = "";

			if (datatableRequestBean.getData() != null && !datatableRequestBean.getData().isEmpty()) {
				clientKey = datatableRequestBean.getData().get("clientKey");
				warehouseKey = datatableRequestBean.getData().get("warehouseKey");
				skuCode = datatableRequestBean.getData().get("skuCode");
				location = datatableRequestBean.getData().get("location");
				locationType = datatableRequestBean.getData().get("locationType");
				isVirtualLocation = datatableRequestBean.getData().get("isVirtualLocation");
				// Boolean isVirtualLocation = Boolean.parseBoolean(locationTypeStr);
			}

			Query query = new Query();
			if (sessionUserBean.getUser() != null && sessionUserBean.getUser().getType().equals(UserType.CLIENT)) {
				query.addCriteria(Criteria.where("clientKey").is(sessionUserBean.getUser().getThirdPartyKey()));

			} else {
				if (clientKey != null) {
					query.addCriteria(Criteria.where("clientKey").in(clientKey));
				}
			}

			if (warehouseKey != null) {
				query.addCriteria(Criteria.where("warehouseKey").in(warehouseKey));
			}
			if (location != null && !location.isEmpty()) {
				query.addCriteria(Criteria.where("warehouseLocationKey").in(location));
			} else {
				if ((isVirtualLocation != null && !isVirtualLocation.isEmpty())
						|| (locationType != null && !locationType.isEmpty())) {
					List<String> locationKeyList = warehouseLocationDao.getWarehouseLocationByKeyAndType(clientKey,
							warehouseKey, locationType, isVirtualLocation);
					query.addCriteria(Criteria.where("warehouseLocationKey").in(locationKeyList));
				}
			}

			if (skuCode != null && !skuCode.isEmpty()) {
				query.addCriteria(Criteria.where("skuCode").in(Arrays.asList(skuCode.split(","))));
			}

			query.skip(datatableRequestBean.getStart());

			if (datatableRequestBean.getSearch() != null && !datatableRequestBean.getSearch().trim().isEmpty()) {
				query.addCriteria(
						Criteria.where("_id").regex(datatableRequestBean.getSearch(), GlobalConstant.CASE_SENSITIVE));
			}

			if (datatableRequestBean.getOrder() != null && !datatableRequestBean.getOrder().isEmpty()) {
				List<String> list = datatableRequestBean.getOrder().get(0);
				int columnNumber = Integer.parseInt(list.get(0));
				String orderBy = list.get(1);
				switch (columnNumber) {
					case 0:
						if (orderBy.equals(GlobalConstant.ASC)) {
							query.with(Sort.by(Sort.Direction.ASC, "createdDate_l"));
						} else {
							query.with(Sort.by(Sort.Direction.DESC, "createdDate_l"));
						}
						break;
				}
			}

			List<SkuInventory> resultList = skuInventoryDao.getObjectByQuery(query, SkuInventory.class);
			Map<String, Map<String, Object>> mergedMap = new HashMap<>();
			for (SkuInventory skuInventory : resultList) {
				WarehouseLocationMaster locationMaster = warehouseLocationDao
						.getObjectById(skuInventory.getWarehouseLocationKey(), WarehouseLocationMaster.class);
				String locationName = (locationMaster != null) ? locationMaster.getLocationName() : "N/A";
				String type = (locationMaster != null) ? locationMaster.getLocationType().toString() : "N/A";

				if (skuInventory.getTotalQty() > 0) {
					String key = skuInventory.getSkuCode() + "-" + locationName;
					Map<String, Object> map;
					if (mergedMap.containsKey(key)) {
						map = mergedMap.get(key);
						map.put("totalQty", (Integer) map.get("totalQty") + skuInventory.getTotalQty());
						map.put("goodQty", (Integer) map.get("goodQty") + skuInventory.getGoodQty());
						map.put("badQty", (Integer) map.get("badQty") + skuInventory.getBadQty());
					} else {
						map = new HashMap<>();
						Catalogue catalogue = catalogueDao.getCatalogueBySkuCode(skuInventory.getSkuCode());
						String imgUrl = (skuInventory.getSkuImageUrls() != null
								&& !skuInventory.getSkuImageUrls().isEmpty())
										? skuInventory.getSkuImageUrls()
										: (catalogue != null) ? catalogue.getProductImageUrls() : "N/A";

						map.put("skuCode", skuInventory.getSkuCode());
						map.put("totalQty", skuInventory.getTotalQty());
						map.put("goodQty", skuInventory.getGoodQty());
						map.put("badQty", skuInventory.getBadQty());
						map.put("warehouseLocationKey", skuInventory.getWarehouseLocationKey());
						map.put("warehouseLocationName", locationName);
						map.put("locationType", type);
						map.put("skuImageUrls", imgUrl);

						mergedMap.put(key, map);
					}
				}
			}
			List<Map<String, Object>> resultListMap = new ArrayList<>(mergedMap.values());
			int count = resultListMap.size();
			datatableResponseBean.setData(resultListMap);
			datatableResponseBean.setDraw(datatableRequestBean.getDraw());
			datatableResponseBean.setRecordsFiltered(count);
			datatableResponseBean.setRecordsTotal(count);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return datatableResponseBean;
	}

	@Override
	public ResponseBean getAllUniqueSkuRecords() {
		ResponseBean responseBean = new ResponseBean();
		try {
			// Fetch distinct parent keys from the database
			Set<String> skuNamesSet = skuInventoryDao.findDistinctSkuNames();
			Set<String> warehouseSet = skuInventoryDao.findDistinctWarehouseKey();
			List<Set<String>> setList = new ArrayList<>();
			setList.add(skuNamesSet);
			setList.add(warehouseSet);

			// Set the response with the list of distinct parent keys
			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setResponse(setList);

		} catch (Exception e) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage(messageSource.getMessage(MessageConstant.ERROR_FETCHING, null, null));
			e.printStackTrace();
		}
		return responseBean;
	}

	@Override
	public ResponseBean updateSkuInventory() {
		ResponseBean responseBean = new ResponseBean();
		try {
			// Creating the connection
			String url = "jdbc:mysql://43.252.89.60:3306/bmp_wims_live";
			String dbusername = "root";
			String dbpassword = "lcms@uat@098";
			String requestUsername = "Aayush@indiasocks.com";
			String requestAuthString = "409a0e27aa45da423f5a7ed4b76f31c92116ba18";
			String requestUrlUat = "http://app.browntape.com/0.1/skus/edit.json?username=" + requestUsername
					+ "&auth_string=" + requestAuthString;
			String requestMethod = "POST";
			String query = "SELECT ms.id, ms.`name`, wi.availablequantity, wi.netquantity "
					+ "FROM mst_skumaster ms "
					+ "JOIN wh_inventory wi ON ms.id = wi.fkskuid "
					+ "WHERE ms.fkclient = 14 "
					+ "GROUP BY ms.`name`";

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, dbusername, dbpassword);

			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			HttpRequestBeanNew httpRequestBean = new HttpRequestBeanNew();
			httpRequestBean.setRequestURL(requestUrlUat);
			httpRequestBean.setRequestMethod(requestMethod);
			Map<String, Object> requestParams = new HashMap<>();
			Map<String, StringBuffer> requestResponse = null;

			Map<String, String> requestHeaders = new LinkedHashMap<String, String>();
			requestHeaders.put("Content-Type", "application/json");
			httpRequestBean.setHeaderParams(requestHeaders);

			while (rs.next()) {
				List<Map<String, Object>> skuData = new ArrayList<>();
				Map<String, Object> skuDataParams = new HashMap<>();
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
				skuDataParams.put("custom_code", rs.getString(2));
				skuDataParams.put("stock", rs.getString(3));
				skuData.add(skuDataParams);

				requestParams.put("data", skuData);
				System.out.println("Request :" + requestParams);
				httpRequestBean.setRequestParams(requestParams);
				requestResponse = new HttpUtilittyNew().call(httpRequestBean);
				StringBuffer response = requestResponse.get("response");
				if (response == null || "".equals(response.toString().trim())) {
					System.out.println("No Response From Api");
				}
				System.out.println("Response :" + response);
			}

			con.close();
			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setMessage("Success");
		} catch (Exception e) {
			System.out.println(e);
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage("Error In Api");
			return responseBean;
		}
		return responseBean;
	}

	@Override
	public ResponseBean getInventoryByWarehouseAndClientKey(String warehouseKey, String clientKey) {
		ResponseBean responseBean = new ResponseBean();
		try {
			List<SkuInventory> listObj = skuInventoryDao.findSkuInventoryByWarehouseAndClientKey(warehouseKey,
					clientKey);
			Map<String, SkuInventory> resultMap = new HashMap<String, SkuInventory>();
			if (listObj != null) {
				for (SkuInventory skuInventory : listObj) {
					Catalogue catalogue = catalogueDao.getCatalogueBySkuCode(skuInventory.getSkuCode());
					skuInventory.setWarehouseKey(String.valueOf(catalogue.getSellingPrice()));
					resultMap.put(skuInventory.getSkuCode(), skuInventory);
				}
				responseBean.setStatus(ResponseStatus.SUCCESS);
				responseBean.setResponse(resultMap);
			}
			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setResponse(resultMap);

		} catch (Exception e) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage(messageSource.getMessage(MessageConstant.ERROR_FETCHING, null, null));
			e.printStackTrace();
		}
		return responseBean;
	}

	@Override
	public void generateInventoryReport(HttpServletResponse response, String clientKey, String warehouseKey) {
		if (sessionUserBean.getUser().getThirdPartyKey().equals("CLIENT")) {
			clientKey = sessionUserBean.getUser().getThirdPartyKey();
		}
		List<SkuInventory> skuObj = skuInventoryDao.findByWarehouseAndClientKey(warehouseKey, clientKey);

		SXSSFWorkbook workbook = new SXSSFWorkbook();
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);

		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);
		headerStyle.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
		Font boldFont = workbook.createFont();
		boldFont.setBold(true);
		headerStyle.setFont(boldFont);
		SXSSFSheet excelSheet = (SXSSFSheet) workbook.createSheet("Available Inventory");
		SXSSFRow excelHeader = (SXSSFRow) excelSheet.createRow(0);

		excelHeader.createCell(0).setCellValue("Client Name");
		excelHeader.createCell(1).setCellValue("Warehouse Name");
		excelHeader.createCell(2).setCellValue("Location Name");
		excelHeader.createCell(3).setCellValue("Location Type");
		excelHeader.createCell(4).setCellValue("SKU Code");
		excelHeader.createCell(5).setCellValue("Good Qty");
		excelHeader.createCell(6).setCellValue("Bad Qty");
		excelHeader.createCell(7).setCellValue("Total Qty");
		for (int i = 0; i < 8; i++) {
			excelHeader.getCell(i).setCellStyle(headerStyle);
		}

		int rowCount = 1;
		String locationName = "";
		LocationType locationType = LocationType.GOOD;
		try {
			for (SkuInventory skuInventory : skuObj) {
				WarehouseLocationMaster locationmaster = warehouseLocationDao
						.getObjectById(skuInventory.getWarehouseLocationKey(), WarehouseLocationMaster.class);
				if (skuInventory.getTotalQty() > 0 && locationmaster != null
						&& !locationmaster.getLocationName().contains("VIRTUAL_LOCATION")) {
					SXSSFRow excelRow = (SXSSFRow) excelSheet.createRow(rowCount++);
					excelRow.createCell(0).setCellValue(skuInventory.getClientKey());
					excelRow.createCell(1).setCellValue(skuInventory.getWarehouseKey());
					excelRow.createCell(2).setCellValue(locationmaster.getLocationName());
					excelRow.createCell(3).setCellValue(locationmaster.getLocationType().toString());
					excelRow.createCell(4).setCellValue(skuInventory.getSkuCode());
					excelRow.createCell(5).setCellValue(skuInventory.getGoodQty());
					excelRow.createCell(6).setCellValue(skuInventory.getBadQty());
					excelRow.createCell(7).setCellValue(skuInventory.getTotalQty());
					for (int i = 0; i < 8; i++) {
						excelRow.getCell(i).setCellStyle(cellStyle);
					}
				}
			}
			String userHome = System.getProperty("user.home");
			String downloadsFolder = "";
			if (System.getProperty("os.name").toLowerCase().contains("win")) {
				downloadsFolder = userHome + "\\Downloads"; // Windows
			} else {
				downloadsFolder = userHome + "/Downloads"; // macOS/Linux
			}
			int fileIdx = 1;
			File downloadsDir = new File(downloadsFolder);
			if (!downloadsDir.exists()) {
				downloadsDir.mkdirs();
			}
			/* File outputFile = new File(downloadsFolder, clientKey + ".xlsx"); */
			String newFileName = clientKey + ".xlsx";
			/*
			 * while (outputFile.exists()) {
			 * newFileName = clientKey + "_" + fileIdx + ".xlsx";
			 * outputFile = new File(downloadsFolder, newFileName);
			 * fileIdx++;
			 * }
			 */
			/*
			 * try (FileOutputStream out = new FileOutputStream(outputFile)) {
			 * workbook.write(out);
			 * }
			 */
			String encoded = URLEncoder.encode(newFileName, StandardCharsets.UTF_8.name());
			String contentDisposition = "attachment; filename=\"" + encoded + "\"; filename*=UTF-8''" + encoded;
			response.setHeader(HttpHeaders.CONTENT_DISPOSITION, contentDisposition);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			try (OutputStream outputStream = response.getOutputStream()) {
				workbook.write(response.getOutputStream());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResponseBean filtInventoryByWarehouseAndClientKey(Map<String, Object> filterMap) {
		ResponseBean responseBean = new ResponseBean();
		try {
			List<ProductSearchResponseBean> listObj = skuInventoryDao.filtInvByWarehouseAndClientKey(filterMap);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			double sellingPrice = 0.0;
			if (listObj != null) {
				if (listObj.size() > 0) {
					for (ProductSearchResponseBean skuInventory : listObj) {
						Catalogue catalogue = catalogueDao.getCatalogueBySkuCode(skuInventory.getSkuCode());
						if (catalogue != null && catalogue.getSellingPrice() != null) {
							sellingPrice = catalogue.getSellingPrice();
							skuInventory.setSellingPrice(sellingPrice);
						} else {
							skuInventory.setSellingPrice(0.0);
						}
						resultMap.put(skuInventory.getSkuCode(), skuInventory);
					}
				} else {
					responseBean.setStatus(ResponseStatus.FAIL);
					responseBean.setMessage(messageSource.getMessage(MessageConstant.RECORD_NOT_FOUND, null, null));
					return responseBean;
				}
				responseBean.setStatus(ResponseStatus.SUCCESS);
				responseBean.setResponse(resultMap);
			}
			if (filterMap.get("limit") != null) {
				resultMap.put("limit", filterMap.get("limit"));
			}
			if (filterMap.get("total") != null) {
				resultMap.put("total", filterMap.get("total"));
			}
			if (filterMap.get("skip") != null) {
				resultMap.put("skip", filterMap.get("skip"));
			}
			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setResponse(resultMap);

		} catch (Exception e) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage(messageSource.getMessage(MessageConstant.ERROR_FETCHING, null, null));
			e.printStackTrace();
		}
		return responseBean;
	}

	@Override
	public ResponseBean filtInventoryByClientKey(Map<String, Object> filterMap) {
		ResponseBean responseBean = new ResponseBean();
		try {
			List<ProductSearchResponseBean> listObj = skuInventoryDao.filtInvByClientKey(filterMap);
			Map<String, ProductSearchResponseBean> resultMap = new HashMap<String, ProductSearchResponseBean>();
			if (listObj != null) {
				if (listObj.size() > 0) {
					for (ProductSearchResponseBean skuInventory : listObj) {
						Catalogue catalogue = catalogueDao.getCatalogueBySkuCode(skuInventory.getSkuCode());
						skuInventory.setSellingPrice(0.0);
						if (catalogue != null && catalogue.getSellingPrice() != null) {
							skuInventory.setSellingPrice(catalogue.getSellingPrice());
						}
						resultMap.put(skuInventory.getSkuCode(), skuInventory);
					}
				} else {
					responseBean.setStatus(ResponseStatus.FAIL);
					responseBean.setMessage(messageSource.getMessage(MessageConstant.RECORD_NOT_FOUND, null, null));
					return responseBean;
				}
				responseBean.setStatus(ResponseStatus.SUCCESS);
				responseBean.setResponse(resultMap);
			}
			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setResponse(resultMap);

		} catch (Exception e) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage(messageSource.getMessage(MessageConstant.ERROR_FETCHING, null, null));
			e.printStackTrace();
		}
		return responseBean;
	}

	@Override
	public ResponseBean getSkuInventoryById(String Id) {
		ResponseBean responseBean = new ResponseBean();
		try {
			SkuInventory skunInventory = skuInventoryDao.getObjectById(Id, SkuInventory.class);
			if (skunInventory == null) {
				responseBean.setStatus(ResponseStatus.FAIL);
				return responseBean;
			}
			responseBean.setStatus(ResponseStatus.SUCCESS);
			responseBean.setResponse(skunInventory);

		} catch (Exception e) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage(messageSource.getMessage(MessageConstant.ERROR_FETCHING, null, null));
			e.printStackTrace();
		}
		return responseBean;
	}

	@Override
	public ResponseBean addQuntity(SkuInventory skunInventory) {
		ResponseBean responseBean = new ResponseBean();
		try {
			SkuInventory skunInventoryDB = skuInventoryDao.getObjectById(skunInventory.getKey_s(), SkuInventory.class);
			if (skunInventoryDB == null) {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setMessage(messageSource.getMessage(MessageConstant.ERROR_FETCHING, null, null));
				return responseBean;
			}
			if (skunInventory.getWarehouseKey() != null && !skunInventory.getWarehouseKey().equals("")) {
				skunInventoryDB.setWarehouseKey(skunInventory.getWarehouseKey());
			}

			if (skunInventory.getWarehouseLocationKey() != null
					&& !skunInventory.getWarehouseLocationKey().equals("")) {
				skunInventoryDB.setWarehouseLocationKey(skunInventory.getWarehouseLocationKey());

				WarehouseLocationMaster warehouseLocationMaster = warehouseLocationDao
						.getObjectById(skunInventory.getWarehouseLocationKey(), WarehouseLocationMaster.class);

				if (LocationType.GOOD.equals(warehouseLocationMaster.getLocationType())) {

					skunInventoryDB.setGoodQty(skunInventory.getTotalQty());
					skunInventoryDB.setTotalQty(skunInventory.getTotalQty());
				} else {
					skunInventoryDB.setBadQty(skunInventory.getTotalQty());
					skunInventoryDB.setTotalQty(skunInventory.getTotalQty());
				}
			} else {
				WarehouseLocationMaster warehouseLocationMaster = warehouseLocationDao
						.getObjectById(skunInventoryDB.getWarehouseLocationKey(), WarehouseLocationMaster.class);

				if (LocationType.GOOD.equals(warehouseLocationMaster.getLocationType())) {

					skunInventoryDB.setGoodQty(skunInventory.getTotalQty());
					skunInventoryDB.setTotalQty(skunInventory.getTotalQty());
				} else {
					skunInventoryDB.setBadQty(skunInventory.getTotalQty());
					skunInventoryDB.setTotalQty(skunInventory.getTotalQty());
				}
			}
			ResponseBean vendorResponseBean = marketplaceService.updateMarketPlaceInventory(CatalogueSource.AMAZON,
					skunInventoryDB);
			if (vendorResponseBean.getStatus().equals(ResponseStatus.SUCCESS)) {
				skuInventoryDao.updateObject(skunInventoryDB);
				responseBean.setStatus(ResponseStatus.SUCCESS);
				responseBean.setResponse(skunInventoryDB);
			} else {
				responseBean.setStatus(ResponseStatus.FAIL);
				responseBean.setResponse(skunInventoryDB);
			}

		} catch (Exception e) {
			responseBean.setStatus(ResponseStatus.FAIL);
			responseBean.setMessage(messageSource.getMessage(MessageConstant.ERROR_FETCHING, null, null));
			e.printStackTrace();
		}
		return responseBean;
	}
}
