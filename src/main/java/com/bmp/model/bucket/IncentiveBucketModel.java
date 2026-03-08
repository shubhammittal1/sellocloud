package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class IncentiveBucketModel extends BaseBucketModel{

	private static final String BUCKET_NAME = BucketConstants.INCENTIVE_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.NOBUSINESS_BUCKET_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.INCENTIVE_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.NOT_ASSIGNED;

    
    public IncentiveBucketModel () {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null, BUCKET_INDEX);
    }
}
