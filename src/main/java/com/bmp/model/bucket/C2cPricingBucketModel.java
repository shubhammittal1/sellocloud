package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class C2cPricingBucketModel extends BaseBucketModel {
	
	private static final String BUCKET_NAME = BucketConstants.SERVICE_PRICING_BUCKET_NAME;
    private static final String BUCKET_TYPE = BucketConstants.SERVICE_PRICING_BUCKET_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.SERVICE_PRICING_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.NOT_ASSIGNED;
    
    public C2cPricingBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
