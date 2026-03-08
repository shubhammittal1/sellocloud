package com.bmp.oms.service;

import java.util.List;

import com.bmp.bean.Test;
import com.bmp.bean.common.ResponseBean;

public interface TestService {

	List<Test> getAllTest() throws Exception;
	
	ResponseBean scanRtoReceivedPacket(String rtoAwbNumber, String currentBranchKey);
	ResponseBean updateSeries();
	ResponseBean deletePacketStatusSpacel(String awb, String statusCode);
	ResponseBean updateReconnectClient();
	ResponseBean reStoreCourierUnUsedSeries(String courierKey, Integer lastDate);
	ResponseBean updateAllOpenPacketStatusAsRtoDelivered(String awbNumbers);
	ResponseBean updatePushPacketStatusHistory(String awbNumbers);
	ResponseBean updateRtoDate();
	ResponseBean  testApi();
    ResponseBean testWooCommApi() throws Exception;
}
