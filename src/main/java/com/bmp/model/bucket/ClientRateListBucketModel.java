package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class ClientRateListBucketModel extends BaseBucketModel {
	private static final String BUCKET_NAME = BucketConstants.CLIENT_RATELIST_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.CLIENT_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.CLIENT_RATELIST_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public ClientRateListBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
