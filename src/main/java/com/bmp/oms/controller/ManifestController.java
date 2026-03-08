package com.bmp.oms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.model.app.manifest.Manifest;
import com.bmp.oms.service.manifest.ManifestService;

@RequestMapping("/manifest")
@Controller
public class ManifestController {
	
	@Autowired
	@Qualifier("manifestServiceImpl")
	private ManifestService manifestService;

	@RequestMapping(value = "/getCreatedManifest", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getCreatedManifest (@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return manifestService.getCreatedManifest (datatableRequestBean);
	}
	
	@RequestMapping(value = "/getAllIncominManifestList", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getAllIncominManifestList(@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return manifestService.getAllIncominManifestList(datatableRequestBean);
	}
	
	@RequestMapping(value = "/scanManifestBykey/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean inscanManifestBykey(@PathVariable("id") String key, HttpServletRequest request,	HttpServletResponse response) {
		return manifestService.inscanManifestBykey(key);
	}
	
	@RequestMapping(value = "/getIntransitManifest", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getIntransitManifest (@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return manifestService.getIntransitManifest (datatableRequestBean);
	}
	
	@RequestMapping(value = "/createManifest/{bagkeys}", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean createManifest(@PathVariable("bagkeys") String bagkeys, @RequestBody Manifest manifest,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return manifestService.createManifest(manifest,bagkeys);
	}
	
	@RequestMapping(value = "/editManifest/{bagkeys}", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean editManifest(@PathVariable("bagkeys") String bagkeys,@RequestBody Manifest manifest, HttpServletRequest request, HttpServletResponse response) {
		return manifestService.editManifest(manifest,bagkeys);
    }
	
	@RequestMapping(value = "/deleteManifest/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean deleteManifest(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return manifestService.deleteManifest(key);
    }
	
	@RequestMapping(value = "/markIntransitManifest/{key}", method = RequestMethod.GET)
    @ResponseBody
	public ResponseBean markIntransitManifest(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
	   return manifestService.markIntransitManifest(key);
    }
	
	@RequestMapping(value = "/getBagsOfManifest/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getBagsOfManifest(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return manifestService.getBagsOfManifest(key);
    }
	
	@RequestMapping(value = "/addBagInManifest/{bagSealNo}/{destinationBranchOfManifest}/{orginBranch}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean addBagInManifest(@PathVariable("bagSealNo") String bagSealNo,@PathVariable("destinationBranchOfManifest") String destinationBranchOfManifest,
    		@PathVariable("orginBranch") String orginBranch, HttpServletRequest request, HttpServletResponse response) {
		return manifestService.addBagInManifest(bagSealNo,destinationBranchOfManifest,orginBranch);
    }
	
	@RequestMapping(value = "/scanBagSealNo/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean scanBagSealNo(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return manifestService.scanBagSealNo(key);
    }
	
	@RequestMapping(value = "/scanBagFormManifest/{bagSealNo}/{manifestKey}/{isBagScan}", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean scanBagFromManifest(@PathVariable("bagSealNo") String bagSealNo, @PathVariable("manifestKey") String manifestKey, 
    		@PathVariable("isBagScan") Boolean isBagScan, HttpServletRequest request, HttpServletResponse response) {
		return manifestService.scanBagFromManifest(bagSealNo,manifestKey, isBagScan);
    }
	
	@RequestMapping(value = "/closeManifest", method = RequestMethod.POST)
  	@ResponseBody
	public  ResponseBean closeManifest(@RequestBody Manifest manifest,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return manifestService.closeManifest(manifest);
   }
	
	@RequestMapping(value = "/getMissingManifest", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getMissingManifest (@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return manifestService.getMissingManifest (datatableRequestBean);
	}
    
    @RequestMapping(value = "/getcloseManifestReport", method = RequestMethod.POST)
  	@ResponseBody
	public  DatatableResponseBean getcloseManifestReport (@RequestBody DatatableRequestBean datatableRequestBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		return manifestService.getcloseManifestReport (datatableRequestBean);
	}
    
    @RequestMapping(value = "/removeBagFromManifest/{bagkey}/{manifestKey}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean removeBagFromManifest(@PathVariable("bagkey") String bagkey,@PathVariable("manifestKey") String manifestKey, HttpServletRequest request, HttpServletResponse response) {
		return manifestService.removeBagFromManifest(bagkey,manifestKey);
    }
    
	
}
