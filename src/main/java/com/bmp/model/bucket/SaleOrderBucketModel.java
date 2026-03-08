package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public abstract class SaleOrderBucketModel extends BaseBucketModel {
	
	private static final String BUCKET_NAME = BucketConstants.SALEORDER_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.SALEORDER_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.SALEORDER_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public SaleOrderBucketModel () {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null, BUCKET_INDEX);
    }
}
