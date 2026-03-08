package com.bmp.oms.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bmp.bean.common.ResponseBean;
import com.bmp.bean.console.MongoConsoleBean;
import com.bmp.bean.console.RiakConsoleBean;
import com.bmp.bean.console.RiakConsoleBean.JsonResponceType;
import com.bmp.oms.service.console.RiakConsoleService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/console")
public class ConsoleController {

	@Autowired
	@Qualifier("riakConsoleServiceImpl")
	private RiakConsoleService riakConsoleService;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping("/riakConsole")
	public ModelAndView initRiakConsole(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//	ModelAndView view = new ModelAndView("console/riakConsole");
		ModelAndView view = new ModelAndView("console/riakConsoleNew");
		RiakConsoleBean riakConsoleBean = new RiakConsoleBean();
		return setRiakData(view, riakConsoleBean);
	}

	@RequestMapping("/getRiakSearch")
	public ModelAndView getRiakSearch(@ModelAttribute("riakConsoleBean") RiakConsoleBean riakConsoleBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView view = new ModelAndView("console/riakConsole");
		boolean isBucketSelected = false;
		boolean isBucketTypeSelected = false;
		boolean isKeySelected = false;
		
		if (riakConsoleBean.getBucketTypes() != null && riakConsoleBean.getBucketTypes().size() > 0) {
			riakConsoleBean.setSelectedBucketType(riakConsoleBean.getBucketTypes().get(0));
			isBucketTypeSelected = true;
		}
		if (riakConsoleBean.getBuckets() != null && riakConsoleBean.getBuckets().size() > 0) {
			riakConsoleBean.setSelectedBucket(riakConsoleBean.getBuckets().get(0));
			isBucketSelected = true;
		}
		if (riakConsoleBean.getKey() != null && !riakConsoleBean.getKey().trim().equals("")) {
			riakConsoleBean.setSelectedKey(riakConsoleBean.getKey());
			isKeySelected = true; 
		}
		
		riakConsoleBean.setOperation(RiakConsoleBean.Operation.valueOf(riakConsoleBean.getOperationStr()));
		
		if (riakConsoleBean.getJsonResponce() != null && !riakConsoleBean.getJsonResponce().equals("") ) {
			//riakConsoleBean.setJsonResponce(riakConsoleBean.getJsonResponce().replaceAll("\t", "").replaceAll("\n", "").replaceAll(" ", "%20").replaceAll("/", "%2F"));
			riakConsoleBean.setJsonResponce(riakConsoleBean.getJsonResponce().replaceAll("/", "%2F"));
		}
		
		String msg = "";
		switch (riakConsoleBean.getOperation()) {
		case SEARCH:
			if (isBucketTypeSelected && !isBucketSelected && !isKeySelected) {
				/* Get All Buckets from Selected bucket Type */
				riakConsoleBean.setJsonResponceType(JsonResponceType.ALL_BUCKETS);
			} else if (isBucketTypeSelected && isBucketSelected && !isKeySelected) {
				/* Get All Keys from Selected bucket */
				riakConsoleBean.setJsonResponceType(JsonResponceType.ALL_KEYS);
			} else {
				/* Get Data from Key */
				riakConsoleBean.setJsonResponceType(JsonResponceType.KEY_DATA);
			}
			/*try {
				riakConsoleBean.setJsonResponce(riakConsoleService.getData (riakConsoleBean));
				setOutput(riakConsoleBean);
			} catch(Exception e) {
				e.printStackTrace();
				view.addObject("errorMsg", "Something went wrong, please try again");
			}*/
			
			break;
			
		case ADD:
			//msg = riakConsoleService.insertRecord (riakConsoleBean);
			view.addObject("errorMsg", msg);
			break;
		case UPDATE:
			//msg = riakConsoleService.updateRecord (riakConsoleBean);
			view.addObject("errorMsg", msg);
			break;
			
		case DELETE:
			//msg = riakConsoleService.deleteData (riakConsoleBean);
			view.addObject("errorMsg", msg);
			break;

		default:
			break;
		}
		
		return setRiakData(view, riakConsoleBean);
	}
	
	private ModelAndView setRiakData(ModelAndView view, RiakConsoleBean riakConsoleBean) throws Exception {
		//List<String> allBucketTypes = riakConsoleService.getAllBucketTypes();
		//riakConsoleBean.setBucketTypes(allBucketTypes);
		//Map<String, List<String>> allBucketsTypeBucketMap = riakConsoleService.getAllBucketsTypeBucketMap(allBucketTypes);
		//riakConsoleBean.setBucketTypeBucketsStr(new Gson().toJson(allBucketsTypeBucketMap));
		//riakConsoleBean.setBucketTypeBuckets(allBucketsTypeBucketMap);
		//riakConsoleBean.setBuckets(riakConsoleService.getAllBuckets(allBucketsTypeBucketMap));
		view.addObject("riakConsoleBean", riakConsoleBean);
		return view;
	}
	
	private void setOutput(RiakConsoleBean riakConsoleBean) {
		switch (riakConsoleBean.getJsonResponceType()) {
		case ALL_BUCKETS :
			//Map<String, Object> map2 = new Gson().fromJson(riakConsoleBean.getJsonResponce(), Map.class);
			//List<String> list = new Gson().fromJson(map2.get("buckets").toString(), List.class);
			break;
			
		case ALL_KEYS:
			Map<String, Object> map = new Gson().fromJson(riakConsoleBean.getJsonResponce(), Map.class);
			List<String> list = new Gson().fromJson(map.get("keys").toString().replaceAll("/", "%2f"), List.class);
			riakConsoleBean.setAllKeys(list);
			break;
		
		case KEY_DATA:
			Map<String, String> map1 = new Gson().fromJson(riakConsoleBean.getJsonResponce(), Map.class);
			riakConsoleBean.setKeyData(map1);
			break;
			
		default:
			break;
		}
		
	}
	
	@RequestMapping("/queryScreen")
	public ModelAndView queryScreen(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView view = new ModelAndView("console/queryScreen");
		return view;
	}
	
	@RequestMapping(value = "/getQueryresult", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getQueryresult(@RequestParam(value="query") String query, @RequestParam(value="index") String solarIndex,HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean= null;
		try{
			responseBean = riakConsoleService.getKeysFromQuery(query, solarIndex);
		}catch(Exception e){
			e.printStackTrace();
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/getQueryresultNew", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getQueryresultNew(@RequestBody Map<String,String> queryMap, HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean= null;
		try{
			String query = queryMap.get("QUERY");
			String index = queryMap.get("INDEX");
			responseBean = riakConsoleService.getKeysFromQuery(query, index);
		}catch(Exception e){
			e.printStackTrace();
		}
		return responseBean;
	}

	@RequestMapping(value = "/updateResultByQuery", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateResultByQuery(@RequestBody HashMap<String,String>requestBody, HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean= null;
		try{
			JSONObject json = new JSONObject(requestBody.get("updateMap"));
			Map<String,Object> map = (Map<String, Object>) new Gson().fromJson(json.toString(), HashMap.class);
			responseBean = riakConsoleService.updateResultByQuery(requestBody.get("query"),requestBody.get("index") , map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/getAllIndex", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getAllIndex(HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean= null;
		try{
			responseBean = riakConsoleService.getAllIndex();
		}catch(Exception e){
			e.printStackTrace();
		}
		return responseBean;
	}
	
	/*@RequestMapping(value = "/getAllBucketAndType", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getAllBucketAndType(HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean= null;
		try{
			responseBean = riakConsoleService.getAllBucketAndType();
		}catch(Exception e){
			e.printStackTrace();
		}
		return responseBean;
	}*/
	
	/*@RequestMapping(value = "/getRiakSearch", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getRiakSearch11(@RequestBody RiakConsoleBean riakConsoleBean,HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean= null;
		try{
			responseBean = riakConsoleService.getRiakSearch(riakConsoleBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return responseBean;
	}*/
	
	/*@RequestMapping(value = "/updateRiakConsoleRecord", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateRiakConsoleRecord(@RequestBody RiakConsoleBean riakConsoleBean,HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean= null;
		try{
			responseBean = riakConsoleService.updateRecord(riakConsoleBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return responseBean;
	}*/
	
	@RequestMapping(value = "/updateRecord", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateRecord(@RequestBody MongoConsoleBean mongoConsoleBean,HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean= null;
		try{
			responseBean = riakConsoleService.updateRecord(mongoConsoleBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/addNewObject", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean addNewObject(@RequestBody MongoConsoleBean mongoConsoleBean,HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean= null;
		try{
			responseBean = riakConsoleService.addNewObject(mongoConsoleBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return responseBean;
	}
	
	@RequestMapping(value = "/getAllCollection", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getAllCollection(HttpServletRequest request, HttpServletResponse response) {
		return riakConsoleService.getAllCollection();
	}
	
	@RequestMapping(value = "/getObjById", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getObjById(@RequestBody MongoConsoleBean mongoConsoleBean, HttpServletRequest request, HttpServletResponse response) {
		return riakConsoleService.getObjById(mongoConsoleBean);
	}
	
	@RequestMapping(value = "/getAllKeys", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getAllKeys(@RequestBody MongoConsoleBean mongoConsoleBean, HttpServletRequest request, HttpServletResponse response) {
		return riakConsoleService.getAllKeys(mongoConsoleBean);
	}
	
	
}