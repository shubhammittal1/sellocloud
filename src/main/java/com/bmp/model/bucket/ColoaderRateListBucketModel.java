package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class ColoaderRateListBucketModel extends BaseBucketModel {
	private static final String BUCKET_NAME = BucketConstants.COLOADER_RATELIST_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.COLOADER_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.COLOADER_RATELIST_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public ColoaderRateListBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
