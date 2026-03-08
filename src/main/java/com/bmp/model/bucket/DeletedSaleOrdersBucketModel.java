package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class DeletedSaleOrdersBucketModel extends BaseBucketModel{

	private static final String BUCKET_NAME = BucketConstants.DELETED_SALEORDERS_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.SALEORDER_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.DELETED_SALEORDERS_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public DeletedSaleOrdersBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
