package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class QCCheckListBucketModel extends BaseBucketModel {
	private static final String BUCKET_NAME = BucketConstants.QCCHECKLIST_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.NOBUSINESS_BUCKET_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.QCCHECKLIST_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public QCCheckListBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
