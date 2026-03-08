package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class ClientCategoryMappingBucketModel extends BaseBucketModel {
	
	private static final String BUCKET_NAME = BucketConstants.CLIENT_CATEGORY_MAPPING_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.CLIENT_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.CLIENT_CATEGORY_MAPPING_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;
    
    public ClientCategoryMappingBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
