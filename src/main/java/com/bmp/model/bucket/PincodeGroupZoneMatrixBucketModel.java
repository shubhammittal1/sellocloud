package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class PincodeGroupZoneMatrixBucketModel extends BaseBucketModel {
	private static final String BUCKET_NAME = BucketConstants.PINCODEGROUPZONEMATRIX_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.MASTER_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.PINCODEGROUPZONEMATRIX_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public PincodeGroupZoneMatrixBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
