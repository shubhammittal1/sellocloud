package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;


public abstract class BranchRouteBucketModel extends BaseBucketModel {
	
	private static final String BUCKET_NAME = BucketConstants.BRANCHROUTE_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.FACILITY_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.BRANCHROUTE_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.NOT_ASSIGNED;

    
    public BranchRouteBucketModel () {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null, BUCKET_INDEX);
    }
}

