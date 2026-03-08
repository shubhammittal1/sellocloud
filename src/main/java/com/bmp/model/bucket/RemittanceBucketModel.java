package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class RemittanceBucketModel extends BaseBucketModel{
	
	private static final String BUCKET_NAME = BucketConstants.REMITTANCE_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.SALEORDER_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.REMITTANCE_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.NOT_ASSIGNED;
	
    public RemittanceBucketModel() {
		super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
	}

}
