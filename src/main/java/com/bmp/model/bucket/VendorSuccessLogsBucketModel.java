package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class VendorSuccessLogsBucketModel extends BaseBucketModel {

	private static final String BUCKET_NAME = BucketConstants.VENDOR_SUCCESS_LOGS_BUCKET_NAME;
    private static final String BUCKET_TYPE = BucketConstants.VENDOR_API_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.VENDOR_SUCCESS_LOGS_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.NOT_ASSIGNED;
	
    public VendorSuccessLogsBucketModel() {
		super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
	}

}
