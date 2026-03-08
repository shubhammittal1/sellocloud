package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class VendorOrderReadyToPushBucketModel extends BaseBucketModel {

	private static final String BUCKET_NAME = BucketConstants.VENDOR_ORDER_READY_TO_PUSH_BUCKET_NAME;
    private static final String BUCKET_TYPE = BucketConstants.VENDOR_API_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.VENDOR_ORDER_READY_TO_PUSH_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;
	
    public VendorOrderReadyToPushBucketModel() {
		super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
	}

}
