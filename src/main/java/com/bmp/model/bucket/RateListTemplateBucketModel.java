package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class RateListTemplateBucketModel extends BaseBucketModel {
	private static final String BUCKET_NAME = BucketConstants.RATELIST_TEMPLATE_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.MASTER_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.RATELIST_TEMPLATE_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public RateListTemplateBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
