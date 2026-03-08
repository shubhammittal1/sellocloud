package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;


public abstract class Receiving3plRtoBucketModel extends BaseBucketModel {
	
	private static final String BUCKET_NAME = BucketConstants.THREEPL_RTO_RECEIVE_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.NOBUSINESS_BUCKET_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.THREEPL_RTO_RECEIVE_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public Receiving3plRtoBucketModel () {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null, BUCKET_INDEX);
    }
}

