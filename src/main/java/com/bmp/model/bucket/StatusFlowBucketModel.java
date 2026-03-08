package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public abstract class StatusFlowBucketModel extends BaseBucketModel {
	
	private static final String BUCKET_NAME = BucketConstants.STATUS_FLOW_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.STATUS_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.STATUS_FLOW_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public StatusFlowBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null, BUCKET_INDEX);
    }
}
