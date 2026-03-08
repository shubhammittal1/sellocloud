package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class ComplaintBoxBucketModel extends BaseBucketModel {
	private static final String BUCKET_NAME = BucketConstants.COMPLAINT_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.CLIENT_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.COMPLAINT_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.NOT_ASSIGNED;

    
    public ComplaintBoxBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
