package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class OrderPushErrorLogsBucketModel extends BaseBucketModel {

	
	private static final String BUCKET_NAME = BucketConstants.ORDER_PUSH_ERROR_LOGS_BUCKET_NAME;
    private static final String BUCKET_TYPE = BucketConstants.SALEORDER_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.ORDER_PUSH_ERROR_LOGS_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.NOT_ASSIGNED;
	
    public OrderPushErrorLogsBucketModel() {
		super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
	}

}
