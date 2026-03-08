package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public abstract class ClientWarehouseBucketModel extends BaseBucketModel {
	
	private static final String BUCKET_NAME = BucketConstants.CLIENT_WAREHOUSE_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.CLIENT_WAREHOUSE_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.CLIENT_WAREHOUSE_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public ClientWarehouseBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
