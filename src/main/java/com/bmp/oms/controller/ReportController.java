package com.bmp.oms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.bean.report.ReportBean;
import com.bmp.model.app.masters.QCMaster;
import com.bmp.model.app.report.ReportMaster;
import com.bmp.model.app.report.ReportQueue;
import com.bmp.oms.service.saleorder.ReportMasterService;
import com.bmp.oms.service.saleorder.ReportService;
import com.bmp.model.app.report.ReportScheduler;

@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("reportServiceImpl")
	private ReportService reportService;
	
	@Autowired
	@Qualifier("reportMasterServiceImpl")
	private ReportMasterService reportMasterService;
	
	@RequestMapping(value = "/getAllReports", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllSaleOrderReport(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request,
			HttpServletResponse response) {
		return reportService.getAllSaleOrderReport(datatableRequestBean);
	}
	
	@RequestMapping(value = "/createReport", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createSaleOrderReport(@RequestBody ReportBean reportBean, HttpServletRequest request, HttpServletResponse response) {
		return reportService.createReport(reportBean);
    }
	
	/*@RequestMapping(value = "/createExcelReports", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean createExcelReports(HttpServletRequest request, HttpServletResponse response) {
		return reportService.createExcelReports();
	}
	
	@RequestMapping(value = "/createCSVReports", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean createCSVReports(HttpServletRequest request, HttpServletResponse response) {
		return reportService.createCSVReports();
	}
	*/
	
	/*@RequestMapping(value = "/createPendingReports", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean createPendingReports(HttpServletRequest request, HttpServletResponse response) {
		return reportService.createPendingReports();
	}*/
	
	/*@RequestMapping("/downloadExcel")
	public ModelAndView downloadExcel(@RequestParam(value = "key") String key,HttpServletResponse response, HttpServletRequest request) {
		   String sourceFile = key + ".xlsx";
			try {
				String reportDir = messageSource.getMessage(GlobalConstant.REPORT_DIRECTORY, null, null);
				FileInputStream inputStream = new FileInputStream(reportDir+"/"+sourceFile);
				String disposition = "attachment; fileName=" + sourceFile;
				response.setContentType("text/xlsx");
				response.setHeader("Content-Disposition", disposition);
				response.setHeader("content-Length",String.valueOf(reportService.stream(inputStream,response.getOutputStream())));
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}*/
	
	
	@RequestMapping(value = "/downloadExcel")
	public ModelAndView downloadFile(@RequestParam(value = "key") String key,HttpServletResponse response, HttpServletRequest request) {
		return reportService.downloadFile(key,response);
	}
	
	@RequestMapping(value = "/deleteExcelReports", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean deleteExcelReports(HttpServletRequest request, HttpServletResponse response) {
		return reportService.deleteExcelReports();
	}
	
	@RequestMapping(value = "/getAllReportMasters", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllReportMasters (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        
		return reportMasterService.getAllReportMasters(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getReportMasters", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getReportMasters (HttpServletRequest request, HttpServletResponse response) {
        
		return reportMasterService.getReportMasters();
    }

	@RequestMapping(value = "/createReportMaster", method = RequestMethod.POST)
	public @ResponseBody ResponseBean createReportMaster(@RequestBody ReportMaster reportMaster, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        return reportMasterService.createReportMaster(reportMaster);
	}
	
	@RequestMapping(value = "/updateReportMaster", method = RequestMethod.POST)
	public @ResponseBody ResponseBean updateReportMaster(@RequestBody ReportMaster reportMaster, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        return reportMasterService.updateReportMaster(reportMaster);
	}
	
	@RequestMapping(value = "/deleteReportMaster/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteReportMaster(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return reportMasterService.deleteReportMaster(key);
    }
	
	@RequestMapping(value = "/checkReportMasterKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkReportMasterKeyAvailable (@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return reportMasterService.checkReportMasterKeyAvailable(key);
    }
	
	@RequestMapping(value = "/getReportMaster/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getReportMaster (@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return reportMasterService.getReportMaster(key);
    }
	
	@RequestMapping(value = "/getFieldTypes", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getFieldTypes (HttpServletRequest request, HttpServletResponse response) {
		return reportMasterService.getFieldTypes();
    }
	
	@RequestMapping(value = "/getBeanClassIndexFields/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getBeanClassIndexFields (@PathVariable("key") String key) {
		return reportMasterService.getBeanClassIndexFields(key);
    }
	
	@RequestMapping(value = "/getBeanClassAllFields/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getBeanClassAllFields (@PathVariable("key") String key) {
		return reportMasterService.getBeanClassAllFields(key);
    }
	
	@RequestMapping(value = "/getFilterValues/{reportKey}/{filterKey}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getFilterValues (@PathVariable("reportKey") String reportKey, @PathVariable("filterKey") String filterKey, HttpServletRequest request, HttpServletResponse response) {
		return reportMasterService.getFilterValues(reportKey, filterKey);
    }
	
	/*@RequestMapping(value = "/createSystemReport", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createSystemReport(@RequestBody SystemReportBean reportBean, HttpServletRequest request, HttpServletResponse response) {
		return reportMasterService.createSystemReport(reportBean);
    }*/
	@RequestMapping(value = "/createSystemReport", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean prepareSystemReport(@RequestBody ReportQueue reportBean, HttpServletRequest request, HttpServletResponse response) {
		return reportMasterService.prepareSystemReport(reportBean);
    }
	
	@RequestMapping(value = "/getAllReportQueues", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllReportQueues(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
		return reportMasterService.getAllReportQueues(datatableRequestBean);
	}
	
	@RequestMapping(value = "/deleteReportQueue/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteReportQueue(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return reportMasterService.deleteReportQueue(key);
    }
	
	@RequestMapping(value = "/getReportPersentCount", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getReportPersentCount(HttpServletRequest request, HttpServletResponse response) {
		return reportService.getReportPersentCount();
    }
	
	@RequestMapping(value = "/getSystemReportPersentCount", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getSystemReportPersentCount(HttpServletRequest request, HttpServletResponse response) {
		return reportService.getSystemReportPersentCount();
    }
	
	@RequestMapping(value = "/createReportScheduler", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean createReportScheduler(@RequestBody ReportScheduler reportShedulerBean, HttpServletRequest request, HttpServletResponse response) {
		return reportMasterService.createReportScheduler(reportShedulerBean);
    }
	
	@RequestMapping(value = "/getAllReportScheduler", method = RequestMethod.POST)
	@ResponseBody
    public DatatableResponseBean getAllReportScheduler (@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
        return reportMasterService.getAllReportScheduler(datatableRequestBean);
    }
	
	@RequestMapping(value = "/updateReportSchedular", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean updateReportSchedular(@RequestBody ReportScheduler reportSheduler, HttpServletRequest request, HttpServletResponse response) {
		return reportMasterService.updateReportSchedular(reportSheduler);
    }
	
	@RequestMapping(value = "/deleteReportScheduler/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteReportScheduler(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return reportMasterService.deleteReportScheduler(key);
    }
	
}
