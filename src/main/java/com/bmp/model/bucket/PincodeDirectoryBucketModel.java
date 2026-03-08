package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class PincodeDirectoryBucketModel extends BaseBucketModel {
	private static final String BUCKET_NAME = BucketConstants.PINCODEDIRECTORY_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.ROUTING_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.PINCODEDIRECTORY_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public PincodeDirectoryBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
