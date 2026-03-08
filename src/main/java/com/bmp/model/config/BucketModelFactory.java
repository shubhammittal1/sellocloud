package com.bmp.model.config;

import com.bmp.model.app.api.VendorApiBean;
import com.bmp.model.app.api.VendorErrorLogs;
import com.bmp.model.app.api.VendorOrderReadyToPush;
import com.bmp.model.app.api.VendorStatusMappingBean;
import com.bmp.model.app.api.VendorSuccessLogs;
import com.bmp.model.app.bag.Bag;
import com.bmp.model.app.bulk.BulkHeader;
import com.bmp.model.app.bulk.BulkMaster;
import com.bmp.model.app.bulk.BulkValidation;
import com.bmp.model.app.client.Client;
import com.bmp.model.app.client.ClientAWBUnusedSeries;
import com.bmp.model.app.client.ClientAWBUsedSeries;
import com.bmp.model.app.client.ClientAccount;
import com.bmp.model.app.client.ClientAccountLog;
import com.bmp.model.app.client.ClientBilling;
import com.bmp.model.app.client.ClientCategoryMapping;
import com.bmp.model.app.client.ClientDashboard;
import com.bmp.model.app.client.ClientFinance;
import com.bmp.model.app.client.ClientRateList;
import com.bmp.model.app.client.ClientSKUWeigthLooker;
import com.bmp.model.app.client.ClientWarehouse;
import com.bmp.model.app.client.ComplaintBox;
import com.bmp.model.app.client.GatewayLog;
import com.bmp.model.app.client.RateListTemplate;
import com.bmp.model.app.coloader.Coloader;
import com.bmp.model.app.coloader.ColoaderRateList;
import com.bmp.model.app.config.Settings;
import com.bmp.model.app.courier.Courier;
import com.bmp.model.app.courier.CourierAWBUnusedSeries;
import com.bmp.model.app.courier.CourierAWBUsedSeries;
import com.bmp.model.app.courier.CourierPriority;
import com.bmp.model.app.courier.CourierPriorityTemplate;
import com.bmp.model.app.courier.CourierRateList;
import com.bmp.model.app.drs.BranchCashClosing;
import com.bmp.model.app.drs.Drs;
import com.bmp.model.app.facility.Branch;
import com.bmp.model.app.facility.BranchRoute;
import com.bmp.model.app.facility.Page;
import com.bmp.model.app.facility.PageAction;
import com.bmp.model.app.facility.Role;
import com.bmp.model.app.facility.User;
import com.bmp.model.app.incentive.Incentive;
import com.bmp.model.app.manifest.Manifest;
import com.bmp.model.app.masters.AWBSeries;
import com.bmp.model.app.masters.BranchStockRecon;
import com.bmp.model.app.masters.City;
import com.bmp.model.app.masters.Country;
import com.bmp.model.app.masters.Pincode;
import com.bmp.model.app.masters.PincodeDirectory;
import com.bmp.model.app.masters.PincodeGroup;
import com.bmp.model.app.masters.PincodeGroupZoneMatrix;
import com.bmp.model.app.masters.ProductType;
import com.bmp.model.app.masters.QCCheckList;
import com.bmp.model.app.masters.QCMaster;
import com.bmp.model.app.masters.RateZone;
import com.bmp.model.app.masters.ServiceablePincode;
import com.bmp.model.app.masters.ServiceablePincodeHistory;
import com.bmp.model.app.report.Report;
import com.bmp.model.app.report.ReportMaster;
import com.bmp.model.app.report.ReportQueue;
import com.bmp.model.app.saleorder.AlertErrorLogs;
import com.bmp.model.app.saleorder.AlertSuccessLogs;
import com.bmp.model.app.saleorder.DeletedSaleOrders;
import com.bmp.model.app.saleorder.OrderPushErrorLogs;
import com.bmp.model.app.saleorder.OrderPushSuccessLogs;
import com.bmp.model.app.saleorder.PickupSheet;
import com.bmp.model.app.saleorder.PushPacketStatusHistory;
import com.bmp.model.app.saleorder.PushStatusAPIHistory;
import com.bmp.model.app.saleorder.Receiving3plRto;
import com.bmp.model.app.saleorder.Remittance;
import com.bmp.model.app.saleorder.RemittanceFrom3PL;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.model.app.saleorder.SaleOrderExtra;
import com.bmp.model.app.saleorder.SaleOrderPickupRequest;
import com.bmp.model.app.saleorder.StagingSaleOrder;
import com.bmp.model.app.saleorder.StatusPushErrorLogs;
import com.bmp.model.app.saleorder.StatusPushSuccessLogs;
import com.bmp.model.app.status.StatusFlow;
import com.bmp.model.app.status.StatusMaster;
import com.bmp.model.app.status.StatusTransition;
import com.bmp.model.app.threePL.ThreePLDocketBean;
import com.bmp.model.app.utility.AlertMaster;
import com.bmp.model.app.utility.SmsMailMaster;
import com.bmp.model.bucket.AWBSeriesBucketModel;
import com.bmp.model.bucket.AlertErrorLogsBucketModel;
import com.bmp.model.bucket.AlertMasterBucketModel;
import com.bmp.model.bucket.AlertSuccessLogsBucketModel;
import com.bmp.model.bucket.BagBucketModel;
import com.bmp.model.bucket.BranchBucketModel;
import com.bmp.model.bucket.BranchCashClosingBucketModel;
import com.bmp.model.bucket.BranchRouteBucketModel;
import com.bmp.model.bucket.BranchStockReconBucketModel;
import com.bmp.model.bucket.BulkHeaderBucketModel;
import com.bmp.model.bucket.BulkMasterBucketModel;
import com.bmp.model.bucket.BulkValidationBucketModel;
import com.bmp.model.bucket.C2cPricingBucketModel;
import com.bmp.model.bucket.CityBucketModel;
import com.bmp.model.bucket.ClientAWBUnusedSeriesBucketModel;
import com.bmp.model.bucket.ClientAWBUsedSeriesBucketModel;
import com.bmp.model.bucket.ClientAccountBucketModel;
import com.bmp.model.bucket.ClientAccountLogBucketModel;
import com.bmp.model.bucket.ClientBillingBucketModel;
import com.bmp.model.bucket.ClientBucketModel;
import com.bmp.model.bucket.ClientCategoryMappingBucketModel;
import com.bmp.model.bucket.ClientDashboardBucketModel;
import com.bmp.model.bucket.ClientFinanceBucketModel;
import com.bmp.model.bucket.ClientRateListBucketModel;
import com.bmp.model.bucket.ClientSKUWeigthLookerBucketModel;
import com.bmp.model.bucket.ClientWarehouseBucketModel;
import com.bmp.model.bucket.ColoaderBucketModel;
import com.bmp.model.bucket.ColoaderRateListBucketModel;
import com.bmp.model.bucket.ComplaintBoxBucketModel;
import com.bmp.model.bucket.CountryBucketModel;
import com.bmp.model.bucket.CourierAWBUnusedSeriesBucketModel;
import com.bmp.model.bucket.CourierAWBUsedSeriesBucketModel;
import com.bmp.model.bucket.CourierBucketModel;
import com.bmp.model.bucket.CourierPriorityBucketModel;
import com.bmp.model.bucket.CourierPriorityTemplateBucketModel;
import com.bmp.model.bucket.CourierRateListBucketModel;
import com.bmp.model.bucket.DeletedSaleOrdersBucketModel;
import com.bmp.model.bucket.DrsBucketModel;
import com.bmp.model.bucket.EnquiryBucketModel;
import com.bmp.model.bucket.GatwayLogBucketModel;
import com.bmp.model.bucket.IncentiveBucketModel;
import com.bmp.model.bucket.ManifestBucketModel;
import com.bmp.model.bucket.OrderPushErrorLogsBucketModel;
import com.bmp.model.bucket.OrderPushSuccessLogsBucketModel;
import com.bmp.model.bucket.PacketBucketModel;
import com.bmp.model.bucket.PageActionBucketModel;
import com.bmp.model.bucket.PageBucketModel;
import com.bmp.model.bucket.PickupSheetBucketModel;
import com.bmp.model.bucket.PincodeBucketModel;
import com.bmp.model.bucket.PincodeDirectoryBucketModel;
import com.bmp.model.bucket.PincodeGroupBucketModel;
import com.bmp.model.bucket.PincodeGroupZoneMatrixBucketModel;
import com.bmp.model.bucket.ProductTypeBucketModel;
import com.bmp.model.bucket.PushPacketStatusHistoryBucketModel;
import com.bmp.model.bucket.PushStatusAPIHistoryBucketModel;
import com.bmp.model.bucket.QCCheckListBucketModel;
import com.bmp.model.bucket.QCMasterBucketModel;
import com.bmp.model.bucket.RateListTemplateBucketModel;
import com.bmp.model.bucket.RateZoneBucketModel;
import com.bmp.model.bucket.Receiving3plRtoBucketModel;
import com.bmp.model.bucket.RemittanceBucketModel;
import com.bmp.model.bucket.RemittanceFrom3PLBucketModel;
import com.bmp.model.bucket.ReportBucketModel;
import com.bmp.model.bucket.ReportMasterBucketModel;
import com.bmp.model.bucket.ReportQueueBucketModel;
import com.bmp.model.bucket.RoleBucketModel;
import com.bmp.model.bucket.SaleOrderBucketModel;
import com.bmp.model.bucket.SaleOrderExtraBuckModel;
import com.bmp.model.bucket.SaleOrderPickupRequestBucketModel;
import com.bmp.model.bucket.ServiceablePincodeBucketModel;
import com.bmp.model.bucket.ServiceablePincodeHistoryModel;
import com.bmp.model.bucket.SettingBucketModel;
import com.bmp.model.bucket.SmsMailMasterBucketModel;
import com.bmp.model.bucket.StagingSaleOrderBucketModel;
import com.bmp.model.bucket.StandardParcelBucketModel;
import com.bmp.model.bucket.StateBucketModel;
import com.bmp.model.bucket.StatusFlowBucketModel;
import com.bmp.model.bucket.StatusMasterBucketModel;
import com.bmp.model.bucket.StatusPushErrorLogsBucketModel;
import com.bmp.model.bucket.StatusPushSuccessLogsBucketModel;
import com.bmp.model.bucket.StatusTransitionBucketModel;
import com.bmp.model.bucket.ThreePLDocketBucketModel;
import com.bmp.model.bucket.UserBucketModel;
import com.bmp.model.bucket.VendorApiBeanBucketModel;
import com.bmp.model.bucket.VendorErrorLogsBucketModel;
import com.bmp.model.bucket.VendorOrderReadyToPushBucketModel;
import com.bmp.model.bucket.VendorStatusMappingBucketModel;
import com.bmp.model.bucket.VendorSuccessLogsBucketModel;
import com.bmp.model.bucket.WebUserAccountLogBucketModel;
import com.bmp.model.bucket.WebUserBucketModel;
import com.bmp.model.c2c.C2cPricing;
import com.bmp.model.c2c.Enquiry;
import com.bmp.model.c2c.Packet;
import com.bmp.model.c2c.StandardParcel;
import com.bmp.model.c2c.WebUser;
import com.bmp.model.c2c.WebUserAccountLog;
import com.google.common.util.concurrent.Service.State;

public class BucketModelFactory {

	public static <T> BaseBucketModel getCustomBucketModel(final Class<T> classVal) {
		
		if(classVal == User.class){
			return new UserBucketModel(){};
		}
		if(classVal == PageAction.class){
			return new PageActionBucketModel() {};
		}
		if(classVal == Page.class){
			return new PageBucketModel() {};
		}
		if(classVal == Branch.class){
			return new BranchBucketModel() {};
		}
		if(classVal == Role.class){
			return new RoleBucketModel() {};
		}
		if(classVal == BulkHeader.class){
			return new BulkHeaderBucketModel(){};
		}
		if(classVal == BulkValidation.class){
			return new BulkValidationBucketModel(){};
		}
		if(classVal == BulkMaster.class){
			return new BulkMasterBucketModel() {};
		}
		if(classVal == Settings.class){
			return new SettingBucketModel() {};
		}
		if(classVal == StatusMaster.class){
			return new StatusMasterBucketModel() {};
		}
		if(classVal == StatusTransition.class){
			return new StatusTransitionBucketModel() {};
		}
		if(classVal == StatusFlow.class){
			return new StatusFlowBucketModel() {};
		}
		if(classVal == PincodeDirectory.class){
			return new PincodeDirectoryBucketModel() {};
		}
		if(classVal == Client.class){
			return new ClientBucketModel() {};
		}
		if(classVal == ClientRateList.class){
			return new ClientRateListBucketModel(){};
		}
		if(classVal == Coloader.class){
			return new ColoaderBucketModel(){};
		}
		if(classVal == ColoaderRateList.class){
			return new ColoaderRateListBucketModel(){};
		}
		if(classVal == Courier.class){
			return new CourierBucketModel(){};
		}
		if(classVal == CourierRateList.class){
			return new CourierRateListBucketModel(){};
		}
		if(classVal == Country.class){
			return new CountryBucketModel(){};
		}
		if(classVal == State.class){
			return new StateBucketModel(){};
		}
		if(classVal == City.class){
			return new CityBucketModel(){};
		}
		if(classVal == PincodeGroup.class){
			return new PincodeGroupBucketModel(){};
		}
		if(classVal == PincodeGroupZoneMatrix.class){
			return new PincodeGroupZoneMatrixBucketModel(){};
		}
		if(classVal == ProductType.class){
			return new ProductTypeBucketModel(){};
		}
		if(classVal == RateZone.class){
			return new RateZoneBucketModel(){};
		}
		if(classVal == RateListTemplate.class){
			return new RateListTemplateBucketModel(){};
		}
		if(classVal == AWBSeries.class){
			return new AWBSeriesBucketModel(){};
		}
		if(classVal == ServiceablePincode.class){
			return new ServiceablePincodeBucketModel(){};
		}
		if(classVal == ClientWarehouse.class){
			return new ClientWarehouseBucketModel(){};
		}
		if(classVal == Pincode.class){
			return new PincodeBucketModel(){};
		}
		if(classVal == BranchRoute.class){
			return new BranchRouteBucketModel(){};
		}
		if(classVal == SaleOrderPickupRequest.class){
			return new SaleOrderPickupRequestBucketModel(){};
		}
		if(classVal == StagingSaleOrder.class){
			return new StagingSaleOrderBucketModel(){};
		}
		if(classVal == SaleOrder.class){
			return new SaleOrderBucketModel(){};
		}
		if(classVal == PickupSheet.class){
			return new PickupSheetBucketModel(){};
		}
		if(classVal == Drs.class){
			return new DrsBucketModel(){};
		}
		if(classVal == Bag.class){
			return new BagBucketModel(){};
		}
		if(classVal == ThreePLDocketBean.class){
			return new ThreePLDocketBucketModel(){};
		}
		if(classVal == Manifest.class){
			return new ManifestBucketModel(){};
		}
		if(classVal == ServiceablePincodeHistory.class){
			return new ServiceablePincodeHistoryModel(){};
		}
		if(classVal == BranchCashClosing.class){
			return new BranchCashClosingBucketModel(){};
		}
		if(classVal == Report.class){
			return new ReportBucketModel(){};
		}
		if(classVal == VendorApiBean.class){
			return new VendorApiBeanBucketModel(){};
		}
		if(classVal == VendorStatusMappingBean.class){
			return new VendorStatusMappingBucketModel(){};
		}
		if(classVal == AlertMaster.class){
			return new AlertMasterBucketModel(){};
		}if(classVal == DeletedSaleOrders.class){
			return new DeletedSaleOrdersBucketModel(){};
		}
		if(classVal == Remittance.class){
			return new RemittanceBucketModel(){};
		}
		if(classVal == RemittanceFrom3PL.class){
			return new RemittanceFrom3PLBucketModel(){};
		}
		if(classVal == SaleOrderExtra.class){
			return new SaleOrderExtraBuckModel(){};
		}
		if(classVal == ClientDashboard.class){
			return new ClientDashboardBucketModel(){};
		}
		if(classVal == CourierPriority.class){
			return new CourierPriorityBucketModel(){};
		}
		if(classVal == CourierPriorityTemplate.class){
			return new CourierPriorityTemplateBucketModel(){};
		}
		if(classVal == QCMaster.class){
			return new QCMasterBucketModel(){};
		}
		if(classVal == QCCheckList.class){
			return new QCCheckListBucketModel(){};
		}
		if(classVal == BranchStockRecon.class){
			return new BranchStockReconBucketModel(){};
		}
		if(classVal == PushStatusAPIHistory.class){
			return new PushStatusAPIHistoryBucketModel(){};
		}
		if(classVal == ClientAWBUsedSeries.class){
			return new ClientAWBUsedSeriesBucketModel(){};
		}
		if(classVal == ClientAWBUnusedSeries.class){
			return new ClientAWBUnusedSeriesBucketModel(){};
		}
		if(classVal == CourierAWBUsedSeries.class){
			return new CourierAWBUsedSeriesBucketModel(){};
		}
		if(classVal == CourierAWBUnusedSeries.class){
			return new CourierAWBUnusedSeriesBucketModel(){};
		}
		if(classVal == VendorOrderReadyToPush.class){
			return new VendorOrderReadyToPushBucketModel(){};
		}
		if(classVal == VendorSuccessLogs.class){
			return new VendorSuccessLogsBucketModel(){};
		}
		if(classVal == VendorErrorLogs.class){
			return new VendorErrorLogsBucketModel(){};
		}
		if(classVal == ReportMaster.class){
			return new ReportMasterBucketModel(){};
		}
		if(classVal == ClientCategoryMapping.class){
			return new ClientCategoryMappingBucketModel(){};
		}
		if(classVal == ReportQueue.class){
			return new ReportQueueBucketModel(){};
		}
		if(classVal == OrderPushSuccessLogs.class){
			return new OrderPushSuccessLogsBucketModel(){};
		}
		if(classVal == OrderPushErrorLogs.class){
			return new OrderPushErrorLogsBucketModel(){};
		}
		
		if(classVal == AlertErrorLogs.class){
			return new AlertErrorLogsBucketModel(){};
		}
		if(classVal == AlertSuccessLogs.class){
			return new AlertSuccessLogsBucketModel(){};
		}
		if(classVal == StatusPushErrorLogs.class){
			return new StatusPushErrorLogsBucketModel(){};
		}
		if(classVal == StatusPushSuccessLogs.class){
			return new StatusPushSuccessLogsBucketModel(){};
		}
		if(classVal == PushPacketStatusHistory.class){
			return new PushPacketStatusHistoryBucketModel(){};
		}
		if(classVal == ClientFinance.class){
			return new ClientFinanceBucketModel(){};
		}
		if(classVal == ClientSKUWeigthLooker.class){
			return new ClientSKUWeigthLookerBucketModel(){};
		}
		if(classVal == ClientBilling.class){
			return new ClientBillingBucketModel(){};
		}
		if(classVal == ClientAccount.class){
			return new ClientAccountBucketModel(){};
		}
		if(classVal == ClientAccountLog.class){
			return new ClientAccountLogBucketModel(){};
		}
		if(classVal == GatewayLog.class){
			return new GatwayLogBucketModel(){};
		}
		if(classVal == Receiving3plRto.class){
			return new Receiving3plRtoBucketModel(){};
		}
		if(classVal == ComplaintBox.class){
			return new ComplaintBoxBucketModel(){};
		}
		if(classVal == Incentive.class){
			return new IncentiveBucketModel(){};
		}
		if(classVal == C2cPricing.class){
			return new C2cPricingBucketModel(){};
		}
		if(classVal == Packet.class){
			return new PacketBucketModel(){};
		}
		if(classVal == WebUserAccountLog.class){
			return new WebUserAccountLogBucketModel(){};
		}
		if(classVal == WebUser.class){
			return new WebUserBucketModel(){};
		}
		if(classVal == StandardParcel.class){
			return new StandardParcelBucketModel(){};
		}
		if(classVal == Enquiry.class){
			return new EnquiryBucketModel(){};
		}
		if(classVal == SmsMailMaster.class){
			return new SmsMailMasterBucketModel(){};
		}
		
		
		return null;
    }
}