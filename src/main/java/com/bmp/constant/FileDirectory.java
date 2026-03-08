package com.bmp.constant;

public enum FileDirectory {

	PINCODEDIRECTORY("PincodeDirectory"),PINCODEMASTER("Pincode"),COUNTRYMASTER("Country"),STATEMASTER("State"),CITYMASTER("City"),SERVICEABLEPINCODE("ServiceablePincode"),
	AWBSERIES("AwbSeries"),UPLOADLBH("UploadLbh"),THREEPLCOURIERTOSALEORDER("3PlAssignCourierToSaleOrder"),UPLOAD_3PL_REMMITTANCE("upload3PLRemmittance"),CHANNEL_ORDER_BULK_UPLOAD("channelOrderBulkUpload"),
	STAGINGSALEORDER("StagingSaleOrder"), THREEPLREPORT("3PlReport"),PICKLISTREPORT("PickListReport"),ORDERPICKLIST("OrderPickList"),ORDERPACKLIST("OrderPackList"), PICKUP_REQUEST_MASTER("pickupRequest"),PICKUPSHEET("pickupSheet"),PICKUPSHEETQC("pickupSheetQC"),
	MANIFEST("manifest"),MANIFEST_BAG_PACK("manifest_bag_pack"),DRS("drs"),PENDINGPOD("pendingPod"),SALEORDER("saleOrder"),THREEPL_STATUS_UPDATE("3plStatusUpdate"),FINALIZED_REMITTANCE("finalizedRemitance"),
	LASTTHREESTATUSREPORT("lastThreeStatusReport"),MANIFEST_EXCEL_REPORT("manifestExcelReport"),SALEORDER_PICKUP_REQUEST_MASTER("SaleOrderPickupRequest"),
	DOWNLOAD_AWBSERIES("AWBSERIES"),BULK_INSCAN("bulkInscan"),PENDING_COD_VERIFY("pendingCodVerify"),SYSTEMREPORTS("systemReports"),CLIENT_SKU_WEIGTH_LOOKER("clientSKUWeigthLookerUpload"),CLIENT_INVOICE("clientInvoice"),
	CLIENT_BILLING_LBH_UPLOAD("clientBillingLbhUpload"), RTO_RECEIVE("rtoReceive"),OPEN_CLOSE_PACKETS("openClosePackets"),OPEN_RTO_PACKET("openRTOPacket"),UPDATE_CLIENT_BILL("updateClientBill"),
	ZONE_WISE_PACKET("zoneWisePacket"),RTO_REASON_PCKTS("rtoReasonPckts"),RTO_RECEIVE_REPORT("rtoReceiveReport"),CTOC_BULK("C2CBULK"),PARTNER_PENDENCY("partnerPendencyReport"),
	UPDATE_DELIVERED_PERSON_DETAILS("updateDeliveredPersonDetails"),RECONNECT_BULK("reconnectBulk"),UPDATE_COURIER_AWB("updateCourierAwb"),REDIRECT_BULK("redirectBulk"),
	CALL_MANIFEST_REPORT("callManifestReport"),CALL_MANIFEST_CLOSED_REPORT("callManifestClosedReport"),CHANGE_AWB_SERIES_PRODUCT_TYPE("changeSeriesProductType"),
	CLIENT_CODE("ClientCode"),ORDER_CONVERTER("OrderConverter"),MANUAL_SMS_REPORT("manualSmsReport"),CLIENT_CODE_REPORT("clientCodeReport"),MARKETPLACE_SKU_MAPPING("MarketplaceSkuMapping"),
	TELECALLING_MANIFEST_REPORT("teleCallingManifestReport"),ORDER_SKU_MAP("orderSkuMap"),RAL_SALEORDER_UPDATE("ralSaleOrderUpdate"),CLIENT_PRODUCT_SKU_RATE("clientProductSkuRate"),
	PENDING_FOR_DRS_REPORT("pendingForDrsReport"),PENDING_FOR_COD_BRANCH_CLOSING("pendingForCodBranchClosingReport"),PENDING_FOR_COD_RECEIVE_REPORT("pendingForCodReceiveReport"),

	CLIET_BILLING_REPORT("clientBillingReport"),STAGINGBULKSALEORDER("StagingBulkSaleOrder"),PO_UPLOAD("PurchaseOrderBulkUpload"),CATALOGUEBUKLUPLOAD("CatalogueBulkUpload"),STN_BULK_UPLOAD("stnBulkUpload");

	
	private String fileDirectory;

	private FileDirectory(String fileDirectory) {
		this.fileDirectory = fileDirectory;
	}

	public static FileDirectory getFileDirectory(String fileDirectoryString) {
		if (fileDirectoryString != null) {
			for (FileDirectory fileDirectory : values()) {
				if (fileDirectoryString.equalsIgnoreCase(fileDirectory.getFileDirectory())) {
					return fileDirectory;
				}
			}
		}
		return null;
	}

	public String getFileDirectory() {
		return fileDirectory;
	}

	public void setFileDirectory(String fileDirectory) {
		this.fileDirectory = fileDirectory;
	}
}