package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class RateZoneBucketModel extends BaseBucketModel {
	private static final String BUCKET_NAME = BucketConstants.RATEZONE_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.MASTER_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.RATEZONE_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public RateZoneBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
