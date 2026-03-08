package com.bmp.oms.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmp.bmpwims.SkuInventoryService;
import com.bmp.model.app.wms.PackageMaster;
import com.bmp.model.app.wms.SkuInventory;
import com.bmp.model.app.wms.Supplier;
import com.bmp.oms.service.wms.*;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.common.DatatableResponseBean;
import com.bmp.bean.common.ResponseBean;
import com.bmp.model.app.channel.ChannelAuthConfig;
import com.bmp.model.app.channel.ChannelMaster;
import com.bmp.model.app.channel.ClientChannel;
import com.bmp.model.app.client.ClientWarehouse;
import com.bmp.oms.service.api.marketplace.ShopifyService;
import com.bmp.oms.service.channel.ChannelAuthConfigService;
import com.bmp.oms.service.channel.ChannelMasterService;
import com.bmp.oms.service.channel.ClientChannelService;

@Controller
@RequestMapping("/channel")
public class ChannelMasterController {
	
	@Autowired
	@Qualifier("channelMasterServiceImpl")
	ChannelMasterService channelMasterService;
	
	@Autowired
	@Qualifier("channelAuthConfigServiceImpl")
	ChannelAuthConfigService channelAuthConfigService;
	
	@Autowired
	@Qualifier("clientChannelServiceImpl")
	ClientChannelService clientChannelService;

	@Autowired
	@Qualifier("supplierServiceImpl")
	SupplierService supplierService;
	
	@Autowired
	@Qualifier("shopifyServiceImpl")
	ShopifyService shopifyAuthService;
	
	@Autowired
	@Qualifier("skuInventoryImpl")
	SkuInventoryService skuInventoryService;

	@Autowired
	@Qualifier("poIdGeneratorServiceImpl")
	PoIdGeneratorService poIdGeneratorService;

	@Autowired
	@Qualifier("stnIdGeneratorServiceImpl")
	StnIdGeneratorService stnIdGeneratorService;

	@Autowired
	@Qualifier("orderIdGeneratorServiceImpl")
	OrderIdGeneratorService orderIdGeneratorService;

	@Autowired
	@Qualifier("generatorServiceImpl")
	GeneratorService generatorService;

	@Autowired
	@Qualifier("packageMasterServiceImpl")
	PackageMasterService packageMasterService;
	
	@RequestMapping(value = "/getAllChannelMaster", method = RequestMethod.POST)
   	@ResponseBody
    public DatatableResponseBean getAllChannelMaster(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
		return channelMasterService.getAllChannelMaster(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getUniqueChannelKey", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean getUniqueChannelKey(@RequestParam String key, HttpServletRequest request, HttpServletResponse response) {
		return channelMasterService.getUniqueChannelKey(key);
    }
	
	@RequestMapping(value = "/createChannelMaster", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean createChannelMaster( MultipartHttpServletRequest request, HttpServletResponse response) {
		Pair<ChannelMaster, Map<String, MultipartFile>>  data = channelMasterService.getObjectAndData(request);	
		return channelMasterService.createChannelMaster(data.getLeft(),data.getRight());
    }
	
	@RequestMapping(value = "/updateChannelMaster", method = RequestMethod.POST)
	public @ResponseBody ResponseBean updateChannelMaster(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		Pair<ChannelMaster, Map<String, MultipartFile>> data = channelMasterService.getObjectAndData(request);	
		return channelMasterService.updateChannelMaster(data.getLeft(),data.getRight());
	}
	
	@RequestMapping(value = "/deleteChannelMaster", method = RequestMethod.PUT)
	@ResponseBody
    public ResponseBean deleteChannelMaster(@RequestParam("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return channelMasterService.deleteChannelMaster(key);
    }
	
	@RequestMapping(value = "/checkChannelKeyAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkChannelKeyAvailable (@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return channelMasterService.checkChannelKeyAvailable(key);
    }
	
	@RequestMapping("/downloadChannelMasterdoc")
	@ResponseBody
		public void downloadChannelMasterdoc(@RequestParam(value="key") String fileName, HttpServletResponse response) throws Exception{
		channelMasterService.downloadDoc(fileName,response);
	}
	
	@RequestMapping(value = "/getAllChannelAuthConfig", method = RequestMethod.POST)
   	@ResponseBody
    public DatatableResponseBean getAllChannelAuthConfig(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
		return channelAuthConfigService.getAllChannelAuthConfig(datatableRequestBean);
    }
	
	@RequestMapping(value = "/getChannelAuthConfig", method = RequestMethod.GET)
   	@ResponseBody
    public ResponseBean getChannelAuthConfig(@RequestParam(value = "channel") String key_s, HttpServletRequest request, HttpServletResponse response) {
		return channelAuthConfigService.getChannelAuthConfig(key_s);
    }
	
	@RequestMapping(value = "/createChannelAuthConfig", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean createChannelAuthConfig(@RequestBody ChannelAuthConfig channelAuthConfig, HttpServletRequest request, HttpServletResponse response) {
		return channelAuthConfigService.createChannelAuthConfig(channelAuthConfig);
    }
	
	@RequestMapping(value = "/updateChannelAuthConfig", method = RequestMethod.POST)
	public @ResponseBody ResponseBean updateChannelAuthConfig(@RequestBody ChannelAuthConfig channelAuthConfig, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return channelAuthConfigService.updateChannelAuthConfig(channelAuthConfig);
	}
	
	@RequestMapping(value = "/deleteChannelAuthConfig", method = RequestMethod.PUT)
	@ResponseBody
    public ResponseBean deleteChannelAuthConfig(@RequestParam("courier") String key_s, HttpServletRequest request, HttpServletResponse response) {
		return channelAuthConfigService.deleteChannelAuthConfig(key_s);
    }
	
	@RequestMapping(value = "/checkChannelAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean checkChannelAvailable (@PathVariable("channel") String key, HttpServletRequest request, HttpServletResponse response) {
		return channelAuthConfigService.checkChannelAvailable(key);
    }
	
	@RequestMapping(value = "/getFieldTypes", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean getFieldTypes (HttpServletRequest request, HttpServletResponse response) {
		return channelAuthConfigService.getFieldTypes();
    }
	
	@RequestMapping(value = "/loadChannels", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadChannels (HttpServletRequest request, HttpServletResponse response) {
		return channelAuthConfigService.loadChannels();
    }
	
	@RequestMapping(value = "/loadFieldsMap", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadFieldsMap (HttpServletRequest request, HttpServletResponse response) {
		return clientChannelService.loadClientChannels();
    }

	@RequestMapping(value = "/loadFieldMapById/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean loadFieldMapById (@PathVariable String key, HttpServletRequest request, HttpServletResponse response) {
		return clientChannelService.loadFieldMapById(key);
	}
	
	@RequestMapping(value = "/loadChannelsData", method = RequestMethod.GET)
	@ResponseBody
    public ResponseBean loadChannelsData (HttpServletRequest request, HttpServletResponse response) {
		return clientChannelService.loadChannelsData();
    }
	
	@RequestMapping(value = "/createClientChannel", method = RequestMethod.POST)
   	@ResponseBody
    public ResponseBean createClientChannel(@RequestBody ClientChannel channel, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return clientChannelService.createClientChannel(channel);
    }
	
	@RequestMapping(value = "/updateClientChannel", method = RequestMethod.PUT)
   	@ResponseBody
    public ResponseBean updateClientChannel(@RequestBody ClientChannel channel, HttpServletRequest request, HttpServletResponse response) {
		return clientChannelService.updateClientChannel(channel);
    }
	
	@RequestMapping(value = "/deleteClientChannel", method = RequestMethod.DELETE)
   	@ResponseBody
    public ResponseBean deleteClientChannel(@RequestParam String key, HttpServletRequest request, HttpServletResponse response) {
		return clientChannelService.deleteClientChannel(key);
    }
	
	@RequestMapping(value = "/getAllClientChannel", method = RequestMethod.POST)
   	@ResponseBody
    public DatatableResponseBean getAllClientChannel(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
		return clientChannelService.getAllClientChannel(datatableRequestBean);
    }

	@RequestMapping(value = "/createSupplier", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean createSupplier(@RequestBody Supplier supplier, HttpServletRequest request, HttpServletResponse response) {
		return supplierService.createSupplier(supplier);
	}

	@RequestMapping(value = "/updateSupplier", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseBean updateSupplier(@RequestBody Supplier supplier, HttpServletRequest request, HttpServletResponse response) {
		return supplierService.updateSupplier(supplier);
	}

	@RequestMapping(value = "/deleteSupplier/{key}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseBean deleteSupplier(@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return supplierService.deleteSupplier(key);
	}

	@RequestMapping(value = "/getAllSupplier", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllSupplier(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
		return supplierService.getAllSuppliers(datatableRequestBean);
	}

	@RequestMapping(value = "/getAllUniqueSupplier", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getAllUniqueSupplier( HttpServletRequest request, HttpServletResponse response) {
		return supplierService.getAllUniqueSupplier();
	}

	@RequestMapping(value = "/getSuppliersByClientKey/{clientKey}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getSuppliersByClientKey( @PathVariable("clientKey") String clientKey,HttpServletRequest request, HttpServletResponse response) {
		return supplierService.getSuppliersByClientKey(clientKey);
	}
	@RequestMapping(value = "/checkSupplierAvailable/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean checkSupplierAvailable (@PathVariable("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return supplierService.checkSupplierAvailable(key);
	}

	@RequestMapping(value = "/getAllUniqueSkuRecords", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getAllUniqueSkuRecords( HttpServletRequest request, HttpServletResponse response) {
		return skuInventoryService.getAllUniqueSkuRecords();
	}
	@RequestMapping(value = "/getSkuInventoryById/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getSkuInventoryById(@PathVariable("key") String id,HttpServletRequest request, HttpServletResponse response) {
		return skuInventoryService.getSkuInventoryById(id);
	}
	@RequestMapping(value = "/addQuntity", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean addQuntity(@RequestBody SkuInventory skunInventory, HttpServletRequest request, HttpServletResponse response) {
		return skuInventoryService.addQuntity(skunInventory);
    }

	@RequestMapping(value = "/getAllSkuInventory", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllSkuInventory(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
		return skuInventoryService.getAllSkuInventory(datatableRequestBean);
	}
	@RequestMapping(value = "/getSkuInventoryByWarehouseAndClientKey/{warehouseKey}/{clientKey}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getSkuInventoryByWarehouseAndClientKey(@PathVariable("warehouseKey") String warehouseKey,@PathVariable("clientKey") String clientKey, HttpServletRequest request, HttpServletResponse response) {
		return skuInventoryService.getInventoryByWarehouseAndClientKey(warehouseKey, clientKey);
	}

	@RequestMapping(value = "/getSkuInventoryTableByClientAndWarehouseKey", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getSkuInventoryTableByClientAndWarehouseKey(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
		try {
			return skuInventoryService.getSkuInventoryTableByClientAndWarehouseKey(datatableRequestBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@RequestMapping(value = "/poIdGenerator", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean poIdGenerator(@RequestParam(value = "poPrefix" ) String poPrefix, @RequestParam(value = "poSequenceNo") String poSequenceNo, HttpServletRequest request, HttpServletResponse response) {
		Long poSequenceNo1 = Long.parseLong(poSequenceNo);
		return poIdGeneratorService.generateUniquePoId(poPrefix, poSequenceNo1);
    }

	/*@RequestMapping(value = "/stnIdGenerator", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean stnIdGenerator(@RequestParam(value = "stnPrefix" ) String stnPrefix, @RequestParam(value = "stnSequenceNo") String stnSequenceNo, HttpServletRequest request, HttpServletResponse resstnnse) {
		Long stnSequenceNo1 = Long.parseLong(stnSequenceNo);
		return stnIdGeneratorService.generateUniqueStnId(stnPrefix, stnSequenceNo1);
		
	}*/
    @RequestMapping(value = "/stnIdGenerator", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean stnIdGenerator(@RequestParam(value = "stnPrefix") String stnPrefix,@RequestParam(value = "stnSequenceNo") String stnSequenceNo, HttpServletRequest request,HttpServletResponse response) {
        Long stnSequenceNo1 = Long.parseLong(stnSequenceNo);
        return stnIdGeneratorService.generateUniqueStnId(stnPrefix, stnSequenceNo1);
    }


    @RequestMapping(value = "/orderIdGenerator", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean orderIdGenerator(@RequestParam(value = "orderPrefix" ) String orderPrefix, @RequestParam(value = "orderSequenceNo") String orderSequenceNo, HttpServletRequest request, HttpServletResponse resordernse) {
		Long orderSequenceNo1 = Long.parseLong(orderSequenceNo);
		return orderIdGeneratorService.generateUniqueOrderId(orderPrefix, orderSequenceNo1);

	}

	@RequestMapping(value = "/getAllGeneratorData", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getAllGeneratorData( HttpServletRequest request, HttpServletResponse response) {
		return generatorService.getAllData();
	}

	@RequestMapping(value = "/getAllPackages", method = RequestMethod.POST)
	@ResponseBody
	public DatatableResponseBean getAllPackages(@RequestBody DatatableRequestBean datatableRequestBean, HttpServletRequest request, HttpServletResponse response) {
		return packageMasterService.loadAllData(datatableRequestBean);
	}
	
	@RequestMapping(value = "/getPackage", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getPackage(@RequestParam("clientkey") String clientkey, HttpServletRequest request, HttpServletResponse response) {
		return packageMasterService.getPackage(clientkey);
	}

	@RequestMapping(value = "/createPackageMaster", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean createPackageMaster(@RequestBody PackageMaster packageMaster, HttpServletRequest request, HttpServletResponse response) {
		return packageMasterService.createPackage(packageMaster);
	}

	@RequestMapping(value = "/updatePackageMaster", method = RequestMethod.PUT)
	public @ResponseBody ResponseBean updatePackageMaster(@RequestBody PackageMaster packageMaster,@RequestParam(value = "key") String key,HttpServletRequest request, HttpServletResponse response) throws Exception {
		return packageMasterService.updatePackage(packageMaster,key);
	}

	@RequestMapping(value = "/deletePackageMaster", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseBean deletePackageMaster(@RequestParam("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return packageMasterService.deletePackage(key);
	}

	@RequestMapping(value = "/getPackageByClientKey", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getPackageByClientKey(@RequestParam("key") String key, HttpServletRequest request, HttpServletResponse response) {
		return packageMasterService.getPackage(key);
	}
	@RequestMapping(value = "/filtInvByClientKey", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean filtInvByClientKey(@RequestBody Map<String, Object> filterMap, HttpServletRequest request, HttpServletResponse response) {
		return skuInventoryService.filtInventoryByClientKey(filterMap);
	}

	@RequestMapping(value = "/filtInvByWarehouseAndClientKey", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean filtInventoryByWarehouseAndClientKey(@RequestBody Map<String, Object> filterMap, HttpServletRequest request, HttpServletResponse response) {
		return skuInventoryService.filtInventoryByWarehouseAndClientKey(filterMap);
	}

}