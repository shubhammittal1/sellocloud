package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class QCMasterBucketModel extends BaseBucketModel {
	private static final String BUCKET_NAME = BucketConstants.QCMASTER_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.NOBUSINESS_BUCKET_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.QCMASTER_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public QCMasterBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
