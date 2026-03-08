package com.bmp.constant;

import java.util.Arrays;
import java.util.List;

public class GlobalConstant {
    public static String COUNT = "count";
	public static String SESSION_BEAN = "SESSION_BEAN";
	public static final String RIAK_SERVERS = "riak.servers";
	public static final String RIAK_HTTP_URL = "riak.http.url";
	public static final String SOLR_SERVERS = "solr.server.address";
	public static final String INDEXED_MAX_RESULTS = "INDEXED_MAX_RESULTS";

	public static final String BULK_DIRECTORY = "BULK_DIRECTORY";
	public static final String BULK_TEMPLATE = "BULK_TEMPLATE";
	public static final String REPORT_DIRECTORY = "REPORT_DIRECTORY";

	public static final int SUCCESS = 0;
	public static final int ERROR = 2;
	public static final int EXPIRED = 9;
	public static final String YES_STRING = "YES";
	public static final String NO_STRING = "NO";
	public static final String ASC = "asc";
	public static final String CASE_SENSITIVE = "i";

	public static final String APPLICATION_JSON = "application/json";

	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final String NULL_STRING = "";
	public static final int SOLR_MAX_COUNT = 9999999;
	public static final String COMMA = ",";
	public static final char SEPERATOR_COMMA = ',';
	public static final String ENCODING_UTF = "UTF-8";
	public static final String EXTENSION_XLS = ".xls";
	public static final String EXCELSHEET_NAME = "Excel";
	public static final String SUCCESS_STRING = "Success";
	public static final String ERROR_STRING = "Error";
	public static final String TEMPLATE_STRING = "Template";
	public static final String DUMP_STRING = "Dump";
	public static final char SEPERATOR_AND = '&';
	public static final char EQUAL_CHAR = '=';
	public static final String SEPERATOR_COLAN = ":";
	public static final String SEPERATOR_SPACE = " ";
	public static final String SEPERATOR_SLASH = "/";
	public static final String SEPERATOR_STAR = "*";
	public static final String SEPERATOR_UNDERSCORE = "_";

	public static final String SOLAR_FL = "fl";
	public static final String SOLAR_START = "start";
	public static final String SOLAR_ROWS = "rows";
	public static final String SOLAR_SORT = "sort";
	public static final String SOLAR_QT = "qt";
	public static final String SOLAR_Q = "q";
	public static final String SOLAR_QUERY_ALL = "*:*";
	public static final String SOLAR_SELECT = "/select";
	public static final String SOLAR_KEY_NAME = "_yz_rk";

	public static final String DELIVERY_BOY = "DELIVERY_BOY";
	public static final String SALEORDER_STATUS_GROUP_NAME = "SALEORDER_STATUS_GROUP_NAME";

	public static final String DATE_FORMATE = "yyyy/MM/dd HH:mm:ss"; 
	public static final String REPORT_DATE_FORMATE = "yyyy/MM/dd";
	public static final String API_DATE_FORMATE = "yyyy-MM-dd";
	public static final String API_DATE_FORMATE2 = "dd-MM-yyyy";
	public static final String DATE_FORMATE2 = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME_FORMAT = "HH:mm:ss";
	public static final String API_DATE_FORMATE3 = "dd-MMM-yyyy";

	public static final String PICKUP_REQUEST_OPEN = "PICKUP_REQUEST_OPEN";
	public static final String PICKUP_REQUEST_SHEET_GENERATED = "PICKUP_REQUEST_SHEET_GENERATED";
	public static final String PICKUP_REQUEST_INTRANSIT = "PICKUP_REQUEST_INTRANSIT";
	public static final String PICKUP_REQUEST_CLOSE = "PICKUP_REQUEST_CLOSE";
	public static final String PICKUP_REQUEST_FLOW_KEY = "PICKUP_REQUEST_FLOW_KEY";
	public static final String PICKUP_REQUEST_CANCEL = "PICKUP_REQUEST_CANCEL";

	public static final String PICKUP_SHEET_OPEN = "PICKUP_SHEET_OPEN";
	public static final String PICKUP_SHEET_INTRANSIT = "PICKUP_SHEET_INTRANSIT";
	public static final String PICKUP_SHEET_CLOSED = "PICKUP_SHEET_CLOSE";
	public static final String PICKUP_SHEET_CLOSED_STATUS = "PICKUP_SHEET_CLOSED_STATUS";
	public static final String PICKUP_SHEET_FLOW_KEY = "PICKUP_SHEET_FLOW_KEY";

	public static final String DEFAULT_ROUTE = "Default";

	public static final String DRS = "DRS";
	public static final String NEW_DRS = "NEW_DRS";
	public static final String INTRANSIT_DRS = "INTRANSIT_DRS";
	public static final String PENDING_FOR_POD_DRS = "PENDING_FOR_POD_DRS";
	public static final String CLOSE_DRS = "CLOSE_DRS";

	// public static final String OUT_FOR_DELIVERY = "OUT_FOR_DELIVERY";

	public static final String DRS_CLOSE_STATUS = "DRS_CLOSE_STATUS";
	public static final String RTO_DECLARE_REASON = "RTO_DECLARE_REASON";
	// public static final String MANIFEST_GENERATED = "MANIFEST_GENERATED";
	public static final String MANIFEST_INTRANSIT = "MANIFEST_INTRANSIT";
	public static final String MANIFEST_CLOSE = "MANIFEST_CLOSE";

	public static final String DATE_REGEX = "yyyy/MM/dd HH:mm:ss";

	public static final String DEBAGED = "DEBAGED";
	public static final String BAG_INTRANSIT = "BAG_INTRANSIT";
	public static final String BAG_RECEIVED_AT_OPERATION_FACILITY = "BAG_RECEIVED_AT_OPERATION_FACILITY";
	// public static final String BAG_CLOSED = "BAG_CLOSED";
	// public static final String BAG_IN_MANIFEST = "BAG_IN_MANIFEST";

	public static final String PICKED_UP = "PICKED_UP";
	public static final String BAGGING = "BAGGING";
	public static final String PACKET_RECEIVED_AT_OPERATION_FACILITY = "PACKET_RECEIVED_AT_OPERATION_FACILITY";
	// public static final String INSCANNED_BAGS_PACKET_NOT_RECEIVED =
	// "INSCANNED_BAGS_PACKET_NOT_RECEIVED";
	public static final String INTERNAL_TRANSFER = "INTERNAL_TRANSFER";
	public static final String INSCANNED_BAGS_NOT_RECEIVED = "INSCANNED_BAGS_NOT_RECEIVED";
	public static final String HANDOVER_TO_3PL = "HANDOVER_TO_3PL";
	public static final String RTO_PACKET_GENETARE = "RTO_PACKET_GENETARE";
	// public static final String RETURN_TO_ORIGIN = "RETURN_TO_ORIGIN";
	public static final String RETURN_TO_DELIVERY = "RETURN_TO_DELIVERY";

	public static final String SELF_LOGISTIC_KEY = "SELF_LOGISTIC_KEY";
	public static final String SELF_PORTAL_KEY = "SELF_PORTAL_KEY";

	public static final String CURRENT_PACKET_FLOW = "CURRENT_PACKET_FLOW";
	public static final String CURRENT_BAG_FLOW = "CURRENT_BAG_FLOW";
	public static final String CURRENT_MANIFEST_FLOW = "CURRENT_MANIFEST_FLOW";

	public static final String THREEPL_OPEN = "THREEPL_OPEN";
	public static final String THREEPL_INTRANSIT = "THREEPL_INTRANSIT";

	// Sale Order status
	public static final String DATA_RECEIVED = "DATA_RECEIVED";
	public static final String SHIPMENT_YET_TO_PICK = "SHIPMENT_YET_TO_PICK";
	public static final String SHIPMENT_PICKUP_IN_PROCESS = "SHIPMENT_PICKUP_IN_PROCESS";
	public static final String INSCANNED_AWAITING_FOR_INTERNAL_TRANSFER = "INSCANNED_AWAITING_FOR_INTERNAL_TRANSFER";
	public static final String INSCANNED_AWAITING_FOR_3PL_TRANSFER = "INSCANNED_AWAITING_FOR_3PL_TRANSFER";
	public static final String INSCANNED_AWAITING_FOR_CUSTOMER_TRANSFER = "INSCANNED_AWAITING_FOR_CUSTOMER_TRANSFER";
	public static final String SHIPMENT_BAG_GENERATED_AND_SEALED = "SHIPMENT_BAG_GENERATED_AND_SEALED";
	public static final String SHIPMENT_MANIFEST_GENERATED = "SHIPMENT_MANIFEST_GENERATED";
	public static final String MANIFESTO_OUTSCANNED = "MANIFESTO_OUTSCANNED";
	public static final String INSCANNED_BAGS_AWAITING_MANIFEST = "INSCANNED_BAGS_AWAITING_MANIFEST";
	public static final String INSCANNED_BAGS_AWAITING_DEBAGGING = "INSCANNED_BAGS_AWAITING_DEBAGGING";
	public static final String INSCANNED_BAGS_PACKET_NOT_RECEIVED = "INSCANNED_BAGS_PACKET_NOT_RECEIVED";
	public static final String THREEPL_MANIFEST_GENERATED = "3PL_MANIFEST_GENERATED";
	public static final String THREEPL_MANIFEST_OUTSCANNED = "3PL_MANIFEST_OUTSCANNED";
	public static final String OUT_FOR_DELIVERY = "OUT_FOR_DELIVERY";
	public static final String DELIVERED = "DELIVERED";
	public static final String LOST_IN_TRANSIT = "LOST_IN_TRANSIT";
	public static final String DAMAGED_IN_TRANSIT = "DAMAGED_IN_TRANSIT";
	public static final String UNDELIVERD_RETURN = "UNDELIVERD_RETURN";
	public static final String NON_ATTEMPT_RETURN = "NON_ATTEMPT_RETURN";
	public static final String CUSTOMER_REJECTED_RETURN = "CUSTOMER_REJECTED_RETURN";
	public static final String RETURN_TO_ORIGIN_INITIATED = "RETURN_TO_ORIGIN_INITIATED";
	public static final String SHIPMENT_BAG_GENERATED = "SHIPMENT_BAG_GENERATED";
	public static final String CONFIRM_RTO = "CONFIRM_RTO";
	public static final String ADDRESS_CHANGE_SHIPMENT_REDIRECT = "ADDRESS_CHANGE_SHIPMENT_REDIRECT";
	public static final String OLD_STATUS_PACKET_RECEIVED = "OLD_PACKET_RECEIVED_OPERATION_FACILITY";
	public static final String OLD_STATUS_PACKET_FORWARDED = "OLD_PACKET_FORWARDED_DESTINATION";
	public static final String OLD_STATUS_DELIVERED = "OLD_DELIVERED";
	public static final String OLD_STATUS_RTO_INTRANSIT = "OLD_RTO_INTRANSIT";
	public static final String OLD_STATUS_RTO_INTRANSIT_KEY = "OLD_RTO_INTRANSIT_KEY";
	public static final String OLD_STATUS_RTO_DELIVERED = "OLD_RTO_DELIVERED";
	public static final String OLD_STATUS_RTO_DELIVERED_KEY = "OLD_RTO_DELIVERED_KEY";
	public static final String OLD_STATUS_RTO_RECEIVED = "OLD_RTO_RECEIVED";
	public static final String OLD_STATUS_RTO_RECEIVED_KEY = "OLD_RTO_RECEIVED_KEY";
	public static final String SHIPMENT_PICKED_UP = "SHIPMENT_PICKED_UP";
	public static final String SHIPMENT_PICKUP_FAILED = "SHIPMENT_PICKUP_FAILED";
	public static final String INITIATE_BOOKING_CANCEL = "INITIATE_BOOKING_CANCEL";
	public static final String CLIENT_REQUEST_PICKUP_REATTEMPT = "CLIENT_REQUEST_PICKUP_REATTEMPT";
	public static final String DELIVERED_SHORT_SHIPMENT = "DELIVERED_SHORT_SHIPMENT";
	public static final String PACKET_ON_HOLD = "PACKET_ON_HOLD";
	public static final String DELIVERED_SNATCHED = "DELIVERED_SNATCHED";
	public static final String REJECTED = "REJECTED";
	public static final String PICKSHEET_GENERATED = "PICKSHEET_GENERATED";
	public static final String VERIFIED = "VERIFIED";
	public static final String COMPLAINT_FILED="COMPLAINT_FILED";
	public static final String PACKET_RECEIVED_OPERATION_FACILITY="PACKET_RECEIVED_OPERATION_FACILITY";
	public static final String CLIENTS_SMS_TEMPLATES = "CLIENTS_SMS_TEMPLATES";
	
	
	public static final String PAYMENT_AUTHORIZED = "PAYMENT_AUTHORIZED";
	public static final String PAYMENT_FAILURE = "PAYMENT_FAILURE";
	public static final String CONTACT_CUSTOMER_SERVICE = "CONTACT_CUSTOMER_SERVICE";
	public static final String SHIPMENT_DESTROYED_DISPOSED = "SHIPMENT_DESTROYED_DISPOSED";
	public static final String PACKET_MISROUTE = "PACKET_MISROUTE";
	public static final String DELIVERY_DELAYED_CONTACT_CUSTOMER_SERVICE = "DELIVERY_DELAYED_CONTACT_CUSTOMER_SERVICE";
	public static final String SHIPMENT_DELAYED_DUETO_BAD_WEATHER = "SHIPMENT_DELAYED_DUETO_BAD_WEATHER";
	public static final String PACKET_IN_TRANSIT = "PACKET_IN_TRANSIT";
	public static final String COD_AWAITED_BRANCH_END = "COD_AWAITED_BRANCH_END";
	public static final String BOOKING_CONFIRMED = "BOOKING_CONFIRMED";
	public static final String BOOKING_CANCELLED = "BOOKING_CANCELLED";
	public static final String PAYMENT_REFUNDED = "PAYMENT_REFUNDED";
	public static final String CLAIM_PROCESSED = "CLAIM_PROCESSED";
	public static final String INSTRUCTION_AWAITED_BRANCH_END = "INSTRUCTION_AWAITED_BRANCH_END";
	public static final String SDC_DELIVERY_REQUIRED_SELF_COLLECT = "SDC_DELIVERY_REQUIRED_SELF_COLLECT";
	public static final String UNCLAIMED_SHIPMENT = "UNCLAIMED_SHIPMENT";
	public static final String PACKET_IN_HAND_STATUS = "PACKET_IN_HAND_STATUS";
	public static final String PACKET_TERMINAL_STATUS = "PACKET_TERMINAL_STATUS";
	public static final String POH_REASON = "POH_REASON";
	public static final String NOT_PICK = "NOT_PICK";
	
	public static final String APOLLO_IN_TRANSIT_INFORMTION_SMS = "APOLLO_IN_TRANSIT_INFORMTION_SMS";
	public static final String APOLLO_REACHED_DESTINATION_HUB_SMS = "APOLLO_REACHED_DESTINATION_HUB_SMS";
	public static final String APOLLO_DELAY_IN_DELIVERY_SMS = "APOLLO_DELAY_IN_DELIVERY_SMS";
	public static final String APOLLO_UNDELIVERED_RTO_BANKS_WILLING_TO_MANAGE_SMS = "APOLLO_UNDELIVERED_RTO_BANKS_WILLING_TO_MANAGE_SMS";
	public static final String APOLLO_UNDELIVERED_RTO_BANK_NOT_WILLING_SMS = "APOLLO_UNDELIVERED_RTO_BANK_NOT_WILLING_SMS";
	public static final String APOLLO_UNDELIVERED_RTO_RETAIL_SMS = "APOLLO_UNDELIVERED_RTO_RETAIL_SMS";
	
	
	public static final String PACKET_INTRANSIT_STATUS = "PACKET_INTRANSIT_STATUS";
	public static final String PACKET_INPROCESS_STATUS = "PACKET_INPROCESS_STATUS";
	public static final String RTO_PACKET_INPROCESS_STATUS = "RTO_PACKET_INPROCESS_STATUS";
	public static final String PACKET_DELIVERED_STATUS = "PACKET_DELIVERED_STATUS";
	
	public static final String RTO_GENERATED = "RTO_GENERATED";
	public static final String DRS_GENERATED = "DRS_GENERATED";
	public static final String RTO_REFUSED_BY_SHIPPER = "RTO_REFUSED_BY_SHIPPER";
	public static final String PICKUP_INITIATE_CANCEL_STATUS = "PICKUP_INITIATE_CANCEL_STATUS";
	public static final String RECONNECT_REQUEST = "RECONNECT_REQUEST";
	public static final String RECONNECTED = "RECONNECTED";
	
	// Bag Status
	public static final String BAG_GENERATED = "BAG_GENERATED";
	public static final String BAG_GENERATED_AND_SEALED = "BAG_GENERATED_AND_SEALED";
	public static final String BAG_IN_MANIFEST = "BAG_IN_MANIFEST";
	public static final String BAG_IN_TRANSIT = "BAG_IN_TRANSIT";
	public static final String BAG_AWAITING_MANIFEST = "BAG_AWAITING_MANIFEST";
	public static final String BAG_AWAITING_DEBAGGING = "BAG_AWAITING_DEBAGGING";
	public static final String BAG_CLOSED = "BAG_CLOSED";
	public static final String INSCANNED_MANIFEST_BAG_NOT_RECEIVED = "INSCANNED_MANIFEST_BAG_NOT_RECEIVED";
	public static final String BAG_LOST_IN_TRANSIT = "BAG_LOST_IN_TRANSIT";

	// manifest Status
	public static final String MANIFEST_GENERATED = "MANIFEST_GENERATED";
	public static final String MANIFEST_IN_TRANSIT = "MANIFEST_IN_TRANSIT";
	public static final String MANIFEST_CLOSED = "MANIFEST_CLOSED";

	// DRS Status
	public static final String DRS_OPEN = "DRS_OPEN";
	public static final String DRS_IN_TRANSIT = "DRS_IN_TRANSIT";
	public static final String DRS_CLOSE = "DRS_CLOSE";
	public static final String DRS_CASH_CLOSE = "DRS_CASH_CLOSE";
	public static final String CASH_WITH_BRANCH = "CASH_WITH_BRANCH";
	public static final String CASH_DEPOSITED_AWAITING_RECONCILIATION = "CASH_DEPOSITED_AWAITING_RECONCILIATION";
	public static final String CASH_RECONCILED = "CASH_RECONCILED";
	public static final String CASH_UNDER_DISPUTE = "CASH_UNDER_DISPUTE";
	public static final String CASH_TRANSACTION_CLOSED = "CASH_TRANSACTION_CLOSED";
	public static final String DRS_FLOW_KEY = "DRS_FLOW_KEY";
	public static final String BANK_ACC_DETAILS = "BANK_ACC_DETAILS";
	public static final String DRS_RESCHEDULE_DATE = "DRS_RESCHEDULE_DATE";

	// Settings
	public static final String DEFUALT_PREPAID_KEY = "DEFUALT_PREPAID_KEY";
	public static final String DEFUALT_COD_KEY = "DEFUALT_PREPAID_KEY";
	public static final String SHIPPER_REFUSED = "SHIPPER_REFUSED";

	// Report Status
	public static final int PROCESS = 0;
	public static final int DONE = 1;
	public static final int PENDING = 2;
	public static final String CLIENT = "CLIENT";
	public static final String STATUS = "STATUS";
	public static final String COURIER = "COURIER";
	public static final String BMP_CLIENT_KEY = "BMP_CLIENT_KEY";
	// Mail Constant
	public static final String MAIL_ACCOUNT_PASSWORD = "mail.account.password";
	public static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
	public static final String MAIL_INBOUND_FROM = "mail.inbound.from";
	public static final String MAIL_INBOUND_TO = "mail.inbound.to";
	public static final String MAIL_OUTBOUND_FROM = "mail.outbound.from";
	public static final String MAIL_OUTBOUND_TO = "mail.outbound.to";
	public static final String MAIL_PASSWORD_AUTHENTICATOR_APIKEY = "mail.password.authenticator.apikey";
	public static final String MAIL_PASSWORD_AUTHENTICATOR_USERNAME = "mail.password.authenticator.username";
	public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	public static final String MAIL_SMTP_PORT = "mail.smtp.port";
	public static final String MAIL_SMTP_HOST = "mail.smtp.host";

	// Mail Templates
	public static final String FORGET_PASSWORD_ALERT_KEY = "forget.password.alert.key";

	// SMS Service Configuration Constant
	public static final String SMS_USERNAME = "sms.username";
	public static final String SMS_PASSWORD = "sms.password";
	public static final String SMS_API_URL = "sms.api.url";
	public static final String SMS_SENDER_ID = "sms.sender.id";

	// remittance Status
	public static final String REMITTANCE_FLOW_KEY = "REMITTANCE_FLOW_KEY";
	public static final String REMITTANCE_GENERATED = "REMITTANCE_GENERATED";
	public static final String REMITTANCE_PARTIALLY_DEPOSIT = "REMITTANCE_PARTIALLY_DEPOSIT";
	public static final String REMITTANCE_CLOSE = "REMITTANCE_CLOSE";
	public static final String REMITTANCE_DISPUTE = "REMITTANCE_DISPUTE";

	// api Vendor service impl Class
	public static final String GATIAIR_VENDOR_SERVICEIMPL = "GatiairVendorServiceImpl";
	public static final String GOJAVAS_VENDOR_SERVICEIMPL = "GojavasVendorServiceImpl";
	public static final String DELIVERY_VENDOR_SERVICEIMPL = "DeliveryVendorServiceImpl";
	public static final String DELIVERY_B2B_VENDOR_SERVICEIMPL = "DeliveryB2bVendorServiceImpl";
	public static final String SHIPWAY_VENDOR_SERVICEIMPL = "ShipwayVendorServiceImpl";
	public static final String ZODIAC_VENDOR_SERVICEIMPL = "ZodiacVendorServiceImpl";
	public static final String XPRESSBEES_VENDOR_SERVICEIMPL = "XpressbeesVendorServiceImpl";
	public static final String RAJDHANIEXPRESS_VENDOR_SERVICEIMPL = "RajdhaniexpressVendorServiceImpl";
	public static final String PROFESSIONAL_VENDOR_SERVICEIMPL = "ProfessionalVendorServiceImpl";
	public static final String BLUEDART_VENDOR_SERVICEIMPL = "BluedartVendorServiceImpl";
	public static final String SHADOWFAX_VENDOR_SERVICEIMPL= "shadowfaxVendorServiceImpl";
	public static final String WOWSHIP_VENDOR_SERVICEIMPL= "WowshipVendorServiceImpl";
	public static final String SECURAEX_VENDOR_SERVICEIMPL= "SecuraexVendorServiceImpl";
	public static final String ECOMEXPRESS_VENDOR_SERVICEIMPL= "ecomexpressVendorServiceImplNew";
	public static final String EKART_VENDOR_SERVICEIMPL= "ekartVendorServiceImpl";
	public static final String AMAZON_PURCHASE_SERVICE_IMPL= "amazonPurchaseServiceImpl";
	public static final String DTDC_VENDOR_SERVICE_IMPL= "DtdcVendorServiceImpl";

	public static final String DEFAULT_PRODUCT_TYPE = "DEFAULT_PRODUCT_TYPE";
	public static final String IS_COLOADER_MANIUAL = "IS_COLOADER_MANIUAL";
	
	public static final String API_USER = "API_USER";
	
	//Client dashBoard Report Days
	public static final String THREE_DAYS = "_3_DAYS";
	public static final String WEEKELY = "_7_DAYS";
	public static final String FORTNIGHTLY = "_15_DAYS";
	public static final String MONTHLY = "_30_DAYS";
	public static final String THREE_MONTHLY = "_90_DAYS";
	public static final String ONE_YEAR = "_365_DAYS";
	
	//QC
	public static final String DEFAULT_QC_CATEGORY = "defaultCategory";
	public static final String DEFAULT_QC_REASON = "other";
	public static final String QC_PRODUCT = "checkProductMatch";
	public static final String QC_CONTENTS = "checkBoxContents";
	public static final String QC_BRAND = "checkBrand";
	public static final List<String> QC_VALUE_POSITIVE = Arrays.asList("true,yes".split(","));
	public static final String 	CLIENT_PRODUCT_CATEGORY = "CLIENT_PRODUCT_CATEGORY";
	public static final String 	PRODUCT_RETURN_REASON = "PRODUCT_RETURN_REASON";
	
	public static final String ORDER_UPLOAD_COUNT_FIRST_CALL = "ORDER_UPLOAD_COUNT_FIRST_CALL";
	public static final String ORDER_UPLOAD_COUNT_TOTAL_COUNT = "ORDER_UPLOAD_COUNT_TOTAL_COUNT";
	public static final String ORDER_UPLOAD_COUNT_CURRENT_COUNT = "ORDER_UPLOAD_COUNT_CURRENT_COUNT";
	
	public static final String THREEPL_ASSIGN_TO_SALEORDER_UPLOAD_COUNT_FIRST_CALL = "THREEPL_ASSIGN_TO_SALEORDER_UPLOAD_COUNT_FIRST_CALL";
	public static final String THREEPL_ASSIGN_TO_SALEORDER_UPLOAD_TOTAL_COUNT = "THREEPL_ASSIGN_TO_SALEORDER_UPLOAD_TOTAL_COUNT";
	public static final String THREEPL_ASSIGN_TO_SALEORDER_UPLOAD_CURR_COUNT = "THREEPL_ASSIGN_TO_SALEORDER_UPLOAD_CURR_COUNT"; 
	
	public static final String RTO_REASON_REACHED_MAXIMUM_ATTEMPT = "RTO_REASON_REACHED_MAXIMUM_ATTEMPT";
	public static final String RTO_REASON_CONSIGNEE_REFUSED_TO_ACCEPT_SHIPMENT = "RTO_REASON_CONSIGNEE_REFUSED_TO_ACCEPT_SHIPMENT";
	public static final String DRS_RTO_INITIATE_REASON = "DRS_RTO_INITIATE_REASON";
	public static final String DRS_RTO_INITIATE_REASON_RTOCOADE = "DRS_RTO_INITIATE_REASON_RTOCOADE";
	public static final String RTO_REASON_NSS = "RTO_REASON_NSS";
	public static final String RTO_REASON_ODA = "RTO_REASON_ODA";
	public static final String SNATCHED_BY_CONSIGNEE = "SNATCHED_BY_CONSIGNEE";
	
	public static final String BRANCH_STOCK_RECON_OPEN = "BRANCH_STOCK_RECON_OPEN";
	public static final String BRANCH_STOCK_RECON_CLOSED = "BRANCH_STOCK_RECON_CLOSED";
	public static final String PICKUP_FAIL_QC_FAIL = "PICKUP_FAIL_QC_FAIL";
	public static final String PICKUP_FAILED_PICKUP_REFUSED_BY_CUSTOMER = "PICKUP_FAILED_PICKUP_REFUSED_BY_CUSTOMER";
	public static final String EXCEL_FORMAT = "EXCEL";
	public static final String CSV_FORMAT = "CSV";
	
	public static final String SERVICIBLE_PINCODE_UPLOAD_COUNT_FIRST_CALL = "SERVICIBLE_PINCODE_UPLOAD_COUNT_FIRST_CALL";
	public static final String SERVICIBLE_PINCODE_UPLOAD_CURRENT_COUNT = "SERVICIBLE_PINCODE_UPLOAD_CURRENT_COUNT";
	public static final String SERVICIBLE_PINCODE_UPLOAD_TOTAL_COUNT = "SERVICIBLE_PINCODE_UPLOAD_TOTAL_COUNT";
	
	public static final String PICKUP_REQUEST_UPLOAD_TOTAL_COUNT = "PICKUP_REQUEST_UPLOAD_TOTAL_COUNT";
	public static final String PICKUP_REQUEST_UPLOAD_CURRENT_COUNT = "PICKUP_REQUEST_UPLOAD_CURRENT_COUNT";
	public static final String PICKUP_REQUEST_UPLOAD_COUNT_FIRST_CALL = "PICKUP_REQUEST_UPLOAD_COUNT_FIRST_CALL";
	
	public static final String AWBSERIES_UPLOAD_COUNT_FIRST_CALL = "AWBSERIES_UPLOAD_COUNT_FIRST_CALL";
	public static final String AWBSERIES_UPLOAD_COUNT_TOTAL_COUNT = "AWBSERIES_UPLOAD_COUNT_TOTAL_COUNT";
	public static final String AWBSERIES_UPLOAD_CURRENT_COUNT = "AWBSERIES_UPLOAD_CURRENT_COUNT";
	
	public static final String THREE_PL_STATUS_UPLOAD_COUNT_FIRST_CALL = "THREE_PL_STATUS_UPLOAD_COUNT_FIRST_CALL";
	public static final String THREE_PL_STATUS_UPLOAD_CURRENT_COUNT = "THREE_PL_STATUS_UPLOAD_CURRENT_COUNT";
	public static final String THREE_PL_STATUS_UPLOAD_TOTAL_COUNT = "THREE_PL_STATUS_UPLOAD_TOTAL_COUNT";
	
	public static final String AWB_CHANGED_UPLOAD_COUNT_FIRST_CALL = "AWB_CHANGED_UPLOAD_COUNT_FIRST_CALL";
	public static final String AWB_CHANGED_UPLOAD_CURRENT_COUNT = "AWB_CHANGED_UPLOAD_CURRENT_COUNT";
	public static final String AWB_CHANGED_UPLOAD_TOTAL_COUNT = "AWB_CHANGED_UPLOAD_TOTAL_COUNT";
	
	public static final String CLIENT_BILL_UPLOAD_COUNT_FIRST_CALL = "CLIENT_BILL_UPLOAD_COUNT_FIRST_CALL";
	public static final String CLIENT_BILL_UPLOAD_CURRENT_COUNT = "CLIENT_BILL_UPLOAD_CURRENT_COUNT";
	public static final String CLIENT_BILL_UPLOAD_TOTAL_COUNT = "CLIENT_BILL_UPLOAD_TOTAL_COUNT";
	
	public static final String UPDATE_DELIVERED_UPLOAD_COUNT_FIRST_CALL = "UPDATE_DELIVERED_UPLOAD_COUNT_FIRST_CALL";
	public static final String UPDATE_DELIVERED_UPLOAD_CURRENT_COUNT = "UPDATE_DELIVERED_UPLOAD_CURRENT_COUNT";
	public static final String UPDATE_DELIVERED_UPLOAD_TOTAL_COUNT = "UPDATE_DELIVERED_UPLOAD_TOTAL_COUNT";
	
	public static final String COURIER_AWB_UPLOAD_COUNT_FIRST_CALL = "COURIER_AWB_UPLOAD_COUNT_FIRST_CALL";
	public static final String COURIER_AWB_UPLOAD_CURRENT_COUNT = "COURIER_AWB_UPLOAD_CURRENT_COUNT";
	public static final String COURIER_AWB_UPLOAD_TOTAL_COUNT = "COURIER_AWB_UPLOAD_TOTAL_COUNT";
	
	public static final String RECONNECT_BULK_UPLOAD_COUNT_FIRST_CALL = "RECONNECT_BULK_UPLOAD_COUNT_FIRST_CALL";
	public static final String RECONNECT_BULK_UPLOAD_CURRENT_COUNT = "RECONNECT_BULK_UPLOAD_CURRENT_COUNT";
	public static final String RECONNECT_BULK_UPLOAD_TOTAL_COUNT = "RECONNECT_BULK_UPLOAD_TOTAL_COUNT";
	
	public static final String REDIRECT_BULK_UPLOAD_COUNT_FIRST_CALL = "REDIRECT_BULK_UPLOAD_COUNT_FIRST_CALL";
	public static final String REDIRECT_BULK_UPLOAD_CURRENT_COUNT = "REDIRECT_BULK_UPLOAD_CURRENT_COUNT";
	public static final String REDIRECT_BULK_UPLOAD_TOTAL_COUNT = "REDIRECT_BULK_UPLOAD_TOTAL_COUNT";
	
	public static final String CHANGE_SERIES_PRODUCT_TYPE_UPLOAD_COUNT_FIRST_CALL = "CHANGE_SERIES_PRODUCT_TYPE_UPLOAD_COUNT_FIRST_CALL";
	public static final String CHANGE_SERIES_PRODUCT_TYPE_BULK_UPLOAD_CURRENT_COUNT = "CHANGE_SERIES_PRODUCT_TYPE_BULK_UPLOAD_CURRENT_COUNT";
	public static final String CHANGE_SERIES_PRODUCT_TYPE_BULK_UPLOAD_TOTAL_COUNT = "CHANGE_SERIES_PRODUCT_TYPE_BULK_UPLOAD_TOTAL_COUNT";
	
	public static final String CLIENT_CODE_BULK_UPLOAD_COUNT_FIRST_CALL = "CLIENT_CODE_BULK_UPLOAD_COUNT_FIRST_CALL";
	public static final String CLIENT_CODE_BULK_UPLOAD_CURRENT_COUNT = "CLIENT_CODE_BULK_UPLOAD_CURRENT_COUNT";
	public static final String CLIENT_CODE_BULK_UPLOAD_TOTAL_COUNT = "CLIENT_CODE_BULK_UPLOAD_TOTAL_COUNT";
	
	public static final String CLIENT_PRODUCT_SKU_RATE_BULK_UPLOAD_COUNT_FIRST_CALL = "CLIENT_PRODUCT_SKU_RATE_BULK_UPLOAD_COUNT_FIRST_CALL";
	public static final String CLIENT_PRODUCT_SKU_RATE_BULK_UPLOAD_CURRENT_COUNT = "CLIENT_PRODUCT_SKU_RATE_BULK_UPLOAD_CURRENT_COUNT";
	public static final String CLIENT_PRODUCT_SKU_RATE_BULK_UPLOAD_TOTAL_COUNT = "CLIENT_PRODUCT_SKU_RATE_BULK_UPLOAD_TOTAL_COUNT";
		
	public static final String RIAK_MIN_CONN = "riak.min.conn";
	public static final String RIAK_MAX_CONN = "riak.max.conn";
	
	public static final String SHIPWAY_PROFESSIONAL_VENDOR_SERVICEIMPL = "ShipwayProfessionalVendorServiceImpl";
	public static final String SHIPWAY_DTDC_VENDOR_SERVICEIMPL = "ShipwayDtdcVendorServiceImpl";
	public static final int XPRESSBEESLBH = 6;//value from contract of xpressbees on 20-7-17
	public static final String GST_NO = "06AAFCB5486R1ZX";
	public static final String HEADER_TOKEN = "Authorization";
	public static final String REPORT_TYPE_CUSTOM = "CUSTOM";
	public static final String REPORT_TYPE_KEYS = "KEYS";
	
	public static final String ALERT_KEYS = "ALERT_KEYS";
	
	//public static final int GATISHIPPER_CODE = 54959501;
	public static final String GATISHIPPER_CODE = "GATISHIPPER_CODE";
	public static final String UNCLAIMED_CLIENT="UNCLAIMED_CLIENT";
	public static final String UNCLAIMED_SHIPMENT_UNCLAIMEDSTATUS = "UNCLAIMED_SHIPMENT_UNCLAIMEDSTATUS";
	public static final String UNCLAIMED_GENERATED="UNCLAIMED_GENERATED";
	
	public static final String DELIVERY_ATMPT_PKTHISTORY = "DeliveryAtmptPktHistory";
	public static final String PICKUP_ATMPT_PKTHISTORY = "PickupAtmptPktHistory";
	public static final String HANOVER_PKTHISTORY = "HanoverPktHistory";
	public static final String RTO_INITIATED_PKTHISTORY = "rtoInitiatedPktHistory";
	public static final String RTO_DECLARE_PKTHISTORY = "rtoInitiatedPktHistory";
	
	public static final String LAST_DELIVERY_ATMPT_PACKETHISTORY = "LastDeliveryAtmptPktHistory";
	public static final String SEC_LAST_DELIVERY_ATMPT_PACKETHISTORY = "SecLastDeliveryAtmptPktHistory";
	public static final String THRD_LAST_DELIVERY_ATMPT_PACKETHISTORY = "ThrdDeliveryAtmptPktHistory";
	
	public static final String LAST_PICKUP_ATMPT_PKTHISTORY = "LastPickupAtmptPktHistory";
	public static final String SEC_LAST_PICKUP_ATMPT_PKTHISTORY = "SecLastPickupAtmptPktHistory";
	public static final String THRD_LAST_PICKUP_ATMPT_PKTHISTORY = "ThrdLastPickupAtmptPktHistory";
	
	public static final String LAST_STATUS_PKTHISTORY = "LastStatusPktHistory";
	public static final String SEC_LAST_STATUS_PKTHISTORY = "SecLastStatusPktHistory";
	public static final String THRD_LAST_STATUS_PKTHISTORY = "ThrdLastStatusPktHistory";
	
	public static final String PUSH_STATUS_CLIENT = "PUSH_STATUS_CLIENT";
	public static final String MANUAL_PUSH_COURIERS = "MANUAL_PUSH_COURIERS";
	public static final String REASONAL_STATUS = "REASONAL_STATUS";
	public static final String NDR_STATUS = "NDR_STATUS";
	
	public static final String RTO_REASON_OTHER = "RTO_REASON_OTHER";
	public static final String PICKUP_OTHER = "PICKUP_OTHER";
	public static final String RTO_DECLARE_REASON_OTHER = "RTO_DECLARE_REASON_OTHER";
	public static final String POH_REASON_OTHER = "POH_REASON_OTHER";
	public static final String POH_REASON_DATA_NOT_RECEIVED = "POH_REASON_DATA_NOT_RECEIVED";
	
	public static final String CLIENT_SKU_UPLOAD_COUNT_FIRST_CALL = "CLIENT_SKU_UPLOAD_COUNT_FIRST_CALL";
	public static final String CLIENT_SKU_UPLOAD_COUNT_TOTAL_COUNT = "CLIENT_SKU_COUNT_TOTAL_COUNT";
	public static final String CLIENT_SKU_UPLOAD_COUNT_CURRENT_COUNT = "ORDER_UPLOAD_COUNT_CURRENT_COUNT";
	
	// bill Status
	public static final String BILL_FLOW_KEY = "BILL_FLOW_KEY";
	public static final String BILL_GENERATED = "BILL_GENERATED";
	public static final String BILL_APPROVED = "BILL_APPROVED";
	public static final String BILL_PARTIALLY_DEPOSIT = "BILL_PARTIALLY_DEPOSIT";
	public static final String BILL_CLOSE = "BILL_CLOSE";
	public static final String BILL_DISPUTE = "BILL_DISPUTE";
	public static final String WEIGHT_MATCHING_THRESHOLD_PERCENT = "WEIGHT_MATCHING_THRESHOLD_PERCENT";
	public static final String CLIENT_WALLET_LOW_BALENCE_ALERT = "CLIENT_WALLET_LOW_BALENCE_ALERT";
	public static final String CLIENT_WALLET_LOW_BALENCE_STATUS = "CLIENT_WALLET_LOW_BALENCE_STATUS";
	
	public static final String NOTIFICATION = "NOTIFICATION";
	public static final String PICKUP_NOTIFICATION_TITLE = "PICKUP_NOTIFICATION_TITLE";
	public static final String DRS_NOTIFICATION_TITLE = "DRS_NOTIFICATION_TITLE";

	// EBS Payment Gateway Details
	public static final String EBS_SECURE_SECRET = "cf7f1a600c8e852c5a5d7cc50877b00d";
	public static final String EBS_PAGE_ID = "EBS_PAGE_ID";
	public static final String EBS_V3URL = "EBS_V3URL";
	public static final String EBS_RETURN_URL = "EBS_RETURN_URL";
	public static final String EBS_RETURN_URL_C2C = "EBS_RETURN_URL_C2C";
	public static final String EBS_REQUEST_URL = "EBS_REQUEST_URL";
	public static final String EBS_PAYMENT_MODE = "EBS_PAYMENT_MODE";
	public static final String EBS_PAYMENT_CHANNEL = "EBS_PAYMENT_CHANNEL";
	public static final String EBS_CURRENCY = "EBS_CURRENCY";
	public static final String EBS_ACCOUNT_ID = "EBS_ACCOUNT_ID";
	public static final String EBS_ALGO = "EBS_ALGO";
	public static final String INSUFFICIENT_BALABCE_REASON  = "115";
	public static final String RATE_CARD_ISSUE  = "rateCardIssue";
	
	// RazorPay Payment Gateway Details.
	public static final String RAZORPAY_API_KEY = "razorpay.api.key";
	public static final String RAZORPAY_API_SECRET = "razorpay.api.secret";
	public static final String RAZORPAY_API_TOKEN = "razorpay.api.token";
	public static final String RAZORPAY_ORDER_API_URL = "razorpay.order.api.url";
	public static final String RAZORPAY_FETCH_PAYMENT_API_URL = "razorpay.fetch.payment.api.url";
	public static final String RAZORPAY_GETWAY_LOGO_URL = "razorpay.getway.logo.url";
	public static final String RAZORPAY_API_CURRENCY = "razorpay.api.currency";
	public static final String COMPANY_NAME = "company.name";
	
	//Incentive Settings
	public static final String DRS_UPDATE_SHIPMENT_PRICE  = "DRS_UPDATE_SHIPMENT_PRICE";
	public static final String PICKSHEET_UPDATE_SHIPMENT_PRICE  = "PICKSHEET_UPDATE_SHIPMENT_PRICE";
	
	public static final String DRS_TOTAL_KMS_PRICE  = "DRS_TOTAL_KMS_PRICE";
	public static final String PICKSHEET_TOTAL_KMS_PRICE  = "PICKSHEET_TOTAL_KMS_PRICE";
	
	public static final String FWD_PICKUP_PER_POINT_PRICE  = "FWD_PICKUP_PER_POINT_PRICE";
	public static final String FWD_TOTAL_SHIPMENT_PICKED_PRICE  = "FWD_TOTAL_SHIPMENT_PICKED_PRICE";
	public static final String RVP_TOTAL_SHIPMENT_PICKED_PRICE  = "RVP_TOTAL_SHIPMENT_PICKED_PRICE";
	public static final String RVP_TOTAL_SHIPMENT_ATTEMPT_PRICE  = "RVP_TOTAL_SHIPMENT_ATTEMPT_PRICE";
	
	public static final String FWD_TOTAL_SHIPMENT_DELIVERED_PRICE  = "FWD_TOTAL_SHIPMENT_DELIVERED_PRICE";
	public static final String FWD_TOTAL_SHIPMENT_ATTEMPT_PRICE  = "FWD_TOTAL_SHIPMENT_ATTEMPT_PRICE";
	public static final String RTO_DRS_PER_POINT_PRICE  = "RTO_DRS_PER_POINT_PRICE";
	public static final String RTO_TOTAL_SHIPMENT_DELIVERED_PRICE  = "RTO_TOTAL_SHIPMENT_DELIVERED_PRICE";
	
	public static final String FWD_DRS = "FWD_DRS";
	public static final String RTO_DRS = "RTO_DRS";
	public static final String RVP_PICKUP = "RVP_PICKUP";
	public static final String FWD_PICKUP  = "FWD_PICKUP";
	public static final String PICKUP  = "PICKUP";
	
	//complaint status
	public static final String NEW = "NEW";
	public static final String INPROCESS = "INPROCESS";
	public static final String RESOLVE = "RESOLVE";
	public static final String CLOSE = "CLOSE";
	public static final String PARTENER_PENDENCY_FILTER_ROLE ="partnerteamtl";
	
	public static final String CTOC_PRODUCT_TYPE = "CTOC_PRODUCT_TYPE";
	public static final String CTOC_3PL_PRIORITY = "CTOC_3PL_PRIORITY";
	public static final String CTOC_BRANCH_KEY = "CTOC_BRANCH_KEY";
	
	//for c2c status
	public static final String PAYMENT_PENDING = "PAYMENT_PENDING";
	public static final String PICKUP_PENDING = "PICKUP_PENDING";
	public static final String CANCEL_ORDER ="CANCEL_ORDER";
	public static final String INTRANSIT_ORDER = "INTRANSIT_ORDER";
	public static final String DELIVERED_ORDER = "DELIVERED_ORDER";
	public static final String RETURNED_ORDER = "RETURNED_ORDER";
	public static final String EBS_TRANSACTION_API_URL = "EBS_TRANSACTION_API_URL";
	public static final String EBS_SUCCESS_STATUS = "EBS_SUCCESS_STATUS";
	public static final String CARGO_BOOKING = "CARGO_BOOKING";
	public static final String C2C_INQUIRY = "C2C_INQUIRY";
	public static final String C2C_INQUIRY_VM = "C2C_INQUIRY_VM";
	public static final String C2C_REGESTER_VM = "C2C_REGESTER_VM";
	public static final String C2C_EXPRESSBOOKING_VM = "C2C_EXPRESSBOOKING_VM";
	public static final String C2C_BOOKING_SMS = "C2C_BOOKING_SMS";
	public static final String C2C_REGISTER_SMS = "C2C_REGISTER_SMS";
	public static final String C2C_FORGOT_PASS_VM = "C2C_FORGOT_PASS_VM";
	public static final String C2C_SOCIAL = "C2C_SOCIAL";
	public static final String C2C_CHANGE_PASSWORD_VM = "C2C_CHANGE_PASSWORD_VM";
	public static final String REAL_TIME_ALERT_KEY = "REAL_TIME_ALERT_KEY";
	public static final String DELIVERED_PACKET_MAIL = "DELIVERED_PACKET_MAIL";
	public static final String TUBELIGHT_FORGOT_VM = "TUBELIGHT_FORGOT_VM";
	public static final String TRACK_ORDER_FOR_APOLLOIVR = "TRACK_ORDER_FOR_APOLLOIVR";
	public static final String REPORT_MAIL_VM = "REPORT_MAIL_VM";
	
	public static final String ROLE_QUERY_FOR_ACCOUNT_MANAGER = "ROLE_QUERY_FOR_ACCOUNT_MANAGER";
	public static final String ICICI_VALID_STAUS_FOR_PUSH = "ICICI_VALID_STAUS_FOR_PUSH";
	public static final String BMP_SMS_CONTACT_DETAILS = "BMP_SMS_CONTACT_DETAILS";
	
	public static final String EXOTEL_WHITE_LIST_NUMBER = "EXOTEL_WHITE_LIST_NUMBER";
	public static final String EXOTEL_OUTGOING_CALLS = "EXOTEL_OUTGOING_CALLS";
	public static final String EXOTEL_OUTGOING_CALLS_BY_FLOW = "EXOTEL_OUTGOING_CALLS_BY_FLOW";
	public static final String EXOTEL_SEND_SMS = "EXOTEL_SEND_SMS";
	public static final String EXOTEL_CALL_DETAILS = "EXOTEL_CALL_DETAILS";
	public static final String EXOTEL_CALL_RECOARDING_URL = "EXOTEL_CALL_RECOARDING_URL";
	public static final String EXOTEL_CALL_RECOARDING_PATH = "EXOTEL_CALL_RECOARDING_PATH";
	public static final String ALERT_SMS_OFD_OTP = "ALERT_SMS_OFD_OTP";
	public static final String EXOTEL_WHITE_LIST_DETAILS= "EXOTEL_WHITE_LIST_DETAILS";
	public static final String EXOTEL_NUMBER_METADATA= "EXOTEL_NUMBER_METADATA";
	public static final String EXOTEL_OUTGOING_CALLS_BY_RAL_ACCOUNT = "EXOTEL_OUTGOING_CALLS_BY_RAL_ACCOUNT";
	public static final String EXOTEL_PIN_CALLING_PHONE="EXOTEL_PIN_CALLING_PHONE";
	public static final String EXOTEL_PIN_CALLING_ACTIVE="EXOTEL_PIN_CALLING_ACTIVE";
	
	public static final String SEND_SMS_TO_CUTOMER_ON_CALL_DISPUTE = "SEND_SMS_TO_CUTOMER_ON_CALL_DISPUTE";
	public static final String SEND_SMS_TO_CUTOMER_ON_IVR_CALL_DISPUTE = "SEND_SMS_TO_CUTOMER_ON_IVR_CALL_DISPUTE";
	
	public static final String DEFAULT_SERVICE_LEVEL = "DEFAULT_SERVICE_LEVEL";
	
	public static final String AWAITING_CLIENT_INSTRUCTION = "AWAITING_CLIENT_INSTRUCTION";
	
	public static final String COURIER_FRANKING = "COURIER_FRANKING";
	public static final String COURIER_INDIAPOST = "COURIER_INDIAPOST";
	
	
	public static final String REPORT_TYPE_FIXED = "FIXED";
	public static final String TODAY = "TODAY";
	public static final String PREVIOUSDAY = "PREVIOUSDAY";
	public static final String LAST_7_DAYS = "LAST_7_DAYS";
	
	//order invoice status
	public static final String INVOICE_PENDING = "INVOICE_PENDING";
	public static final String INVOICE_GENERATED = "INVOICE_GENERATED";
	public static final String INVOICE_CANCELLED = "INVOICE_CANCELLED";
	
	public static final String MERCHANT_HANDOVER_STATUS_ID = "MERCHANT_HANDOVER_STATUS_ID";
	public static final String MERCHANT_RECEIVED_STATUS_ID = "MERCHANT_RECEIVED_STATUS_ID";
	public static final String MERCHANT_RETURNED_STATUS_ID = "MERCHANT_RETURNED_STATUS_ID";

	
	//telecalling status
	public static final String ORDER_VERIFY_PENDING = "ORDER_VERIFY_PENDING";
	public static final String ORDER_VERIFIED = "ORDER_VERIFIED";
	public static final String ORDER_CANCELLED = "ORDER_CANCELLED";
	public static final String RINGING_NO_RESPONSE = "RINGING_NO_RESPONSE";
	public static final String PHONE_NOT_REACHABLE = "PHONE_NOT_REACHABLE";
	public static final String PHONE_IS_SWITCHED_OFF = "PHONE_IS_SWITCHED_OFF";
	public static final String WRONG_PHONE_NUMBER = "WRONG_PHONE_NUMBER";
	public static final String CUSTOMER_REFUSED_FOR_DELIVERY = "CUSTOMER_REFUSED_FOR_DELIVERY";
	
	public static final String RAL_ORDER_PUSH_VENDOR_API_BEAN_KEY = "RAL_ORDER_PUSH_VENDOR_API_BEAN_KEY";
	public static final String RAL_ORDER_PUSH_VENDOR_API_LOGS_BEAN_KEY = "RAL_ORDER_PUSH_VENDOR_API_LOGS_BEAN_KEY";
	public static final String RAL_INVOICE_STATUS_GET_VENDOR_API_KEY = "RAL_INVOICE_STATUS_GET_VENDOR_API_KEY";
	public static final String RAL_CLIENT_KEY = "RAL";
	
	//For BFIL
	public static final String TELECALLING_STATUS = "TelecallingStatus";
	public static final String INVOICE_STATUS = "InvoiceStatus";
	public static final String SHIPMENT_STATUS = "ShipmentStatus";
	public static final String SUCCESSFUL = "Successful";
	public static final String UNSUCCESSFUL = "Unsuccessful";
	public static final String TELE = "Tele";
	public static final String INVOICE = "Invoice";
	public static final String DELIVERY = "Delivery";
	public static final String ADDRESS_NOT_TRACEABLE = "Address not traceable";
	public static final String CONSIGNEE_NOT_AVAILABLE = "Consignee not available";
	public static final String DOOR_LOCK = "Door Lock";
	public static final String KYC_DOCUMENT_NOT_AVAILABLE = "KYC Document not available";
	public static final String CONSIGNEE_REFUSED_TO_ACCEPT = "Consignee refused to accept";
	public static final String BFIL = "BFIL";
	public static final String TELECALLING = "TELECALLING";
	public static final String VENDOR_CODE = "VENDOR_CODE";
	public static final String SERVICE_URL = "service.url";
	
	public static final String BFIL_ORDER_FETCH="BFIL_ORDER_FETCH";
	public static final String BFIL_ORDER_FETCH_SUCCESS_UPDATE="BFIL_ORDER_FETCH_SUCCESS_UPDATE";
	public static final String BFIL_CANCEL_ORDER="BFIL_CANCEL_ORDER";
	public static final String BFIL_CANCEL_ORDER_SUCCESS_UPDATE="BFIL_CANCEL_ORDER_SUCCESS_UPDATE";
	public static final String BFIL_TELECALL="BFIL_TELECALL";
	public static final String BFIL_TELECALL_SUCCESS_UPDATE="BFIL_TELECALL_SUCCESS_UPDATE";
	public static final String BFIL_VIRTUAL_PHONE_NUMBER = "BFIL_VIRTUAL_PHONE_NUMBER";
	
	public static final String CALLING_USER_ROLES = "calling.user.roles";
	public static final String CLIENT_AWAITING_INSTRUCTIONS = "CLIENT_AWAITING_INSTRUCTIONS";
	
	public static final String DB_BACKUP_PATH = "DB_BACKUP_PATH";
	
	public static final String RAL_PUSH = "RAL_PUSH";
	public static final String CASHIFY_VALID_STAUS_FOR_PUSH = "CASHIFY_VALID_STAUS_FOR_PUSH";
	
	public static final String NDR_VALID_ARRANGE_DELIVERY = "NDR_VALID_ARRANGE_DELIVERY";
	public static final String NDR_VALID_ARRANGE_RTO = "NDR_VALID_ARRANGE_RTO";
	public static final String NDR_INVALID_ADDRESS = "NDR_INVALID_ADDRESS";
	public static final String NDR_INVALID_ARRANGE_DELIVERY = "NDR_INVALID_ARRANGE_DELIVERY";
	public static final String NDR_INVALID_ARRANGE_RTO = "NDR_INVALID_ARRANGE_RTO";	
	public static final String MAXIMUM_CALL_ATTEMPTED = "MAXIMUM_CALL_ATTEMPTED";
	public static final String DELIVERY_CONFIRMED = "DELIVERY_CONFIRMED";
	public static final String DELIVERY_REFUSED = "DELIVERY_REFUSED";
	public static final String ORDER_VERIFY_TELECALLING_STATUS = "ORDER_VERIFY_TELECALLING_STATUS";
	public static final String NDR_VALIDATE_TELECALLING_STATUS = "NDR_VALIDATE_TELECALLING_STATUS";
	public static final String DELIVERY_CONFIRM_TELECALLING_STATUS = "DELIVERY_CONFIRM_TELECALLING_STATUS";
	public static final String ORDER_VERIFY_WITH_PENDING_TELECALLING_STATUS = "ORDER_VERIFY_WITH_PENDING_TELECALLING_STATUS";
	
	public static final String INITIATE_BOOKING_CANCEL_REASON = "INITIATE_BOOKING_CANCEL_REASON";
	public static final String BOOKING_MAX_CALL_ATTEPTED = "BOOKING_MAX_CALL_ATTEPTED";
	public static final String AS_PER_CLIENT_INSTRUCTION = "AS_PER_CLIENT_INSTRUCTION";
	public static final String BOOKING_CANCEL_REASON_OTHER = "BOOKING_CANCEL_REASON_OTHER";
	
	public static final String DOOR_OFFICE_CLOSED_NDR = "DOOR_OFFICE_CLOSED_NDR";
	public static final String BFIL_POD_PUSH = "BFIL_POD_PUSH";
	public static final String CURRENT_APP_VERSION = "current.app.version";
	
	public static final String ATTEMPT_COUNT_NOT_INCREASE_AT_NDR = "ATTEMPT_COUNT_NOT_INCREASE_AT_NDR";
	public static final String BOOKING_CANCEL_REASON = "BOOKING_CANCEL_REASON";	
	public static final String RAL_PROFORMA_INVOICE = "RAL_PROFORMA_INVOICE";
	
	public static final String MANIFEST_PER_ALERT_KEY = "MANIFEST_PER_ALERT_KEY";
	public static final String INVOICE_UPDATE_STATUS = "InvoiceUpdateStatus";
	public static final String INVOICE_UPDATE = "InvoiceUpdate";
	public static final String SERVICE_REPORT_URL = "service.report.url";
	
	public static final String BFIL_API_USER_NAME = "BFIL_API_USER_NAME";
	public static final String BFIL_API_POSSWORD = "BFIL_API_POSSWORD";
	public static final String RAL_ORDER_PUSH = "RAL_ORDER_PUSH";
	public static final String RAL_ORDER_CANCEL = "RAL_ORDER_CANCEL";
	public static final String RAL_RDSP_MASTER_PUSH = "RAL_RDSP_MASTER_PUSH";
	
	//bfilMerchantCallingStatus
	public static final String INTERESTED = "Interested";
	public static final String NOT_INTERESTED = "Not Interested";
	
	public static final String PIN_BASED_OFD_SMS_TEMPLATE = "PIN_BASED_OFD_SMS_TEMPLATE";
	public static final String BMP_URL_SHORTCUT = "BMP_URL_SHORTCUT";
	public static final String BMP_SUPPORT_EMAIL = "BMP_SUPPORT_EMAIL";
	
	public static final String CONVERORT_PATH="converort.path";
	public static final String MEESHO_PRINT_PATH="meesho.print.path";
	public static final String MEESHO_PRINT_API_KEY = "MEESHO_PRINT_API_KEY";
	public static final String MEESHO_CLIENT_KEY = "";
	
	public static final String RAL_QC_CATEGORY = "RalProduct";
	public static final String RAL_QC_SUBCATEGORY = "RalQc";
	public static final String RAL_QC_KEY = "RAL_QC_KEY";
	
	public static final String ALERT_SMS_REGISTER_OTP = "ALERT_SMS_REGISTER_OTP";
	public static final String ALERT_SMS_FORGOT_PASWORD_OTP = "ALERT_SMS_FORGOT_PASWORD_OTP";
	public static final String GENDER_MALE = "Male";
	public static final String FE_DEPARTMENT_OPERATION = "Operation";
	public static final String FE_DESIGNATION = "FE";
	public static final String ALERT_SMS_COMPLETE_REGISTRATION = "ALERT_SMS_COMPLETE_REGISTRATION";
	
	public static final String JUSDA_VALID_STAUS_FOR_PUSH = "JUSDA_VALID_STAUS_FOR_PUSH";
	public static final String CLIENT_POD_SAMPLE = "client.pod.sample";
	public static final String SMS_LOGIN_CREDENTIALS = "SMS_LOGIN_CREDENTIALS";
	public static final String BANK_LIST = "BANK_LIST";
	public static final String AWB_PREEALERT_COURIER_SERIES_KEY = "AWB_PREEALERT_COURIER_SERIES_KEY";
	public static final String RAL_INVOICE_CANCEL_GET_API = "RAL_INVOICE_CANCEL_GET_API";
	public static final String PENDING_FOR_RE_INVOICE_NDR = "PENDING_FOR_RE_INVOICE_NDR";
	public static final String UPDATE_CANCEL_INVOICE_IN_RAL = "UPDATE_CANCEL_INVOICE_IN_RAL";
	public static final String KYC_APPROVE_ALERT_SMS = "KYC_APPROVE_ALERT_SMS";
	public static final String PENDING_DRS_PRE_ALERT_KEY = "PENDING_DRS_PRE_ALERT_KEY";
	public static final String COD_BRANCH_CLOSING_PRE_ALERT_KEY = "COD_BRANCH_CLOSING_PRE_ALERT_KEY";
	public static final String KYC_ALERT_SMS = "KYC_ALERT_SMS";
	public static final String APOLLO_CLIENT_KEY = "APOLLO_CLIENT_KEY";
	public static final String APOLLO_SMS_SENDER_ID = "apollo.sms.sender.id";
	public static final String LOGIN_WITH_OTP_ALERT_KEY = "LOGIN_WITH_OTP_ALERT_KEY";
	public static final String PENDING_COD_RECEIVE_PRE_ALERT_KEY = "PENDING_COD_RECEIVE_PRE_ALERT_KEY";
	public static final String RAL_NEW_INVOICING_PROCESS_TBL_CONTROL="RAL_NEW_INVOICING_PROCESS_TBL_CONTROL";
	public static final String RAL_INVOICE_PROCESS_API = "RAL_INVOICE_PROCESS_API";
	
	public static final String DASH_BOARD_QUERY = "DASH_BOARD_QUERY";
	
	public static final String INDIA_POST_PTINT = "INDIA_POST_PTINT";
	public static final String SPECIAL_COURIER_SIMPLE_PRINT = "SPECIAL_COURIER_SIMPLE_PRINT";
	public static final String SELF_LOGISTIC_PRINT_LOGO_PATH = "SELF_LOGISTIC_PRINT_LOGO_PATH";
	public static final String SELF_BARCODE_TITLE = "SELF_BARCODE_TITLE";
	public static final String HIDE_PAYMENT_MODE = "HIDE_PAYMENT_MODE";
	public static final String AMAZON_PRINT_LABEL_SETTING = "AMAZON_PRINT_LABEL_SETTING";
	public static final String DELHIVERYB2B_PRINT_LABEL_SETTING = "DELHIVERYB2B_PRINT_LABEL_SETTING";
	
	// Organization details start hear
	public static final String ORGANIZATION_KEY = "ORGANIZATION_KEY";
	public static final String ORGANIZATION_NAME="ORGANIZATION_NAME";
	public static final String ORGANIZATION_LOGO="ORGANIZATION_LOGO";
	public static final String ORGANIZATION_ICON="ORGANIZATION_ICON";
	public static final String ORGANIZATION_ADDRESS="ORGANIZATION_ADDRESS";
	public static final String ORGANIZATION_PIN_CODE="ORGANIZATION_PIN_CODE";
	public static final String ORGANIZATION_FOOTER_COPYRIGHT = "ORGANIZATION_FOOTER_COPYRIGHT";
	public static final String ORGANIZATION_GST_NUMBER = "ORGANIZATION_GST_NUMBER";
	
	public static final String CLIENT_ONBOARDING_ROLE = "clientOnBoardingRole";
	public static final String CLIENT_PAGE_ROLE = "clientNew";
	
	//public static final String ALL_INDIA_PICCODE_GROUP = "ALL_INDIA_PICCODE_GROUP";
	//public static final String ALL_INDIA_COURIER_PRIORITY="ALL_INDIA_COURIER_PRIORITY";
	public static final String B2C_DEFAULT_PRIORI_TYTEMPLATE="B2C_DEFAULT_PRIORI_TYTEMPLATE";
	public static final String B2B_DEFAULT_PRIORI_TYTEMPLATE="B2B_DEFAULT_PRIORI_TYTEMPLATE";
	public static final String INTERNATIONAL_DEFAULT_PRIORI_TYTEMPLATE="INTERNATIONAL_DEFAULT_PRIORI_TYTEMPLATE";
	public static final String DEFAULT_ON_BOARDING_RATE_CLIENT="DEFAULT_ON_BOARDING_RATE_CLIENT";
	public static final String CLIENT_REPORTS_ID="CLIENT_REPORTS_ID";
	
	
	public static final String CLIENT_ORDER_STATUS_TYPE = "CLIENT_ORDER_STATUS_TYPE";
	public static final String COMPLAIN_STATUS_TYPE = "COMPLAIN_STATUS_TYPE";
	
	public static final String WITHIN_CITY = "A";
	public static final String WITHIN_STATE = "B";
	public static final String METRO = "C";
	
	public static final String METRO_ZONE_TYPE_SETTING_KEY = "metro.zone.type.setting.key";
	public static final String NEJK_ZONE_TYPE_SETTING_KEY = "nejk.zone.type.setting.key";
	
	public static final String CUSTOME_COURIER_PRORITY = "CUSTOME";
	public static final String COD_OTHER_CHARGE_CODE  = "cod.other.charge.code";
	public static final String ODA_OTHER_CHARGE_CODE = "oda.other.charge.code";
	
	public static final String COUNTRY_OF_ORIGIN = "India";

	public static final String PO_CREATED = "PO_CREATED";
    public static final String PO_APPROVED = "PO_APPROVED";
	public static final String PO_CLOSED = "PO_CLOSED";
	public static final String PO_PARTIALRECEIVE = "PO_PARTIALRECEIVE";
	public static final String PO_FLOW_KEY = "PO_FLOW_KEY";
	
	public static final String STN_CREATED = "STN_CREATED";
    public static final String STN_FORWARD = "STN_FORWARD";
	public static final String STN_CLOSED = "STN_CLOSED";
	public static final String STN_PARTIALRECEIVE = "STN_PARTIALRECEIVE";
	public static final String STN_FLOW_KEY = "STN_FLOW_KEY";
	
	public static final String ORDER_CREATED = "ORDER_CREATED";
    public static final String ORDER_CONFIRM = "ORDER_CONFIRM";
    public static final String ORDER_CANCEL = "ORDER_CANCEL";
    public static final String ORDER_PARTIAL_PACKED = "ORDER_PARTIAL_PACKED";
    public static final String ORDER_PACKED = "ORDER_PACKED";
    public static final String ORDER_DISPATCH = "ORDER_DISPATCH";
    public static final String ORDER_FLOW_KEY = "ORDER_FLOW_KEY";
    
    public static final String PACKAGE_CREATED = "PACKAGE_CREATED";
    public static final String PACKAGE_INTRANSIT = "PACKAGE_INTRANSIT";
    public static final String PACKAGE_DISPATCH = "PACKAGE_DISPATCH";
    public static final String PACKAGE_DELIVERED = "PACKAGE_DELIVERED";
    public static final String PACKAGE_RTO_CONFIRM = "PACKAGE_RTO_CONFIRM";
    public static final String PACKAGE_RTO_RECEIVE = "PACKAGE_RTO_RECEIVE";
    public static final String PACKAGE_FLOW_KEY = "PACKAGE_FLOW_KEY";
    //public static final String PACKAGE_CONDITIONAL_QC_CODE = "PACKAGE_CONDITIONAL_QC_CODE";

	public static final String STATUS_TRANSITION_NOT_FOUND = "Status Transition is not found";
	
	public static final String SALE_ORDER_WEBHOOK_SOURCE = "vender";
    public static final String SALE_ORDER_WEBHOOK_SOURCE_KEY = "vender-key";
    public static final String SALE_ORDER_WEBHOOK_AWB_HEADER_KEY = "awbNo";
    
    public static final String SHOPIFY_API_KEY = "SHOPIFY_API_KEY";
    public static final String SHOPIFY_API_SECRET = "SHOPIFY_API_SECRET";
    public static final String AMZ_MARKET_APP_ID = "AMZ_MARKET_APP_ID";
    public static final String SHOPIFY_API_SCOPE = "SHOPIFY_API_SCOPE";

	public static final String LOCATION_CODE_AVAILABLE= "LOCATION_CODE_AVAILABLE";
	public static final String LOCATION_CODE_NOT_AVAILABLE= "LOCATION_CODE_NOT_AVAILABLE";
	public static final String BAR_CODE_AVAILABLE= "BAR_CODE_AVAILABLE";
	public static final String BAR_CODE_NOT_AVAILABLE= "BAR_CODE_NOT_AVAILABLE";

	public static final String CLIENT_WAREHOUSE_NOT_AVAILABLE ="CLIENT_WAREHOUSE_NOT_AVAILABLE";
	public static final String INVENTORY_NOT_AVAILABLE ="INVENTORY_NOT_AVAILABLE";


	public static final String RECORD_ALREADY_EXIST = "RECORD_ALREADY_EXIST";

    public static final String FileUrl = "imageUrl";
    public static final String AMAZON_SELLER_AUTH = "https://sellercentral.amazon.com/apps/authorize/consent";
    public static final String NGROK_SERVE_AMAZON = "https://7a96eee72a83.ngrok-free.app/ERP/";
    public static final String AMAZON_ORDER_BASEURL = "https://sellingpartnerapi-eu.amazon.com/orders/v0/orders";
    
    public static final String ALLOW_PUSH_WITHOUT_COURIER_AWB = "ALLOW_PUSH_WITHOUT_COURIER_AWB";
    
    


    public static final String WooComm_Client_Id = "WooComm_Client_Id";
    public static final String WooComm_Client_Secret = "WooComm_Client_Secret";
}