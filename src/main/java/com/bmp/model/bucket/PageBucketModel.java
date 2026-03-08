package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;


public abstract class PageBucketModel extends BaseBucketModel {
	
	private static final String BUCKET_NAME = BucketConstants.PAGE_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.FACILITY_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.PAGE_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public PageBucketModel () {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null, BUCKET_INDEX);
    }
}

