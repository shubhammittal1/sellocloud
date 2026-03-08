package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public abstract class BulkMasterBucketModel extends BaseBucketModel {
	
	private static final String BUCKET_NAME = BucketConstants.BULKMASTER_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.BULK_BUCKET_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.BULKMASTER_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public BulkMasterBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
