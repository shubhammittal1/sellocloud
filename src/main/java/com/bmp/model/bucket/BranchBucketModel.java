package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public abstract class BranchBucketModel extends BaseBucketModel {
	
	private static final String BUCKET_NAME = BucketConstants.BRANCH_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.FACILITY_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.BRANCH_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public BranchBucketModel () {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null, BUCKET_INDEX);
    }
}
