package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class RemittanceFrom3PLBucketModel extends BaseBucketModel{

	private static final String BUCKET_NAME = BucketConstants.REMITTANCEFROM3PL_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.SALEORDER_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.REMITTANCEFROM3PL_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;
	
    public RemittanceFrom3PLBucketModel() {
		super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
	}
}
