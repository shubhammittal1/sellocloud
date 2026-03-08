package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public abstract class DrsBucketModel extends BaseBucketModel {
	
	private static final String BUCKET_NAME = BucketConstants.DRS_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.DRS_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.DRS_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public DrsBucketModel () {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null, BUCKET_INDEX);
    }
}
