package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class CourierAWBUnusedSeriesBucketModel extends BaseBucketModel {
	private static final String BUCKET_NAME = BucketConstants.COURIER_AWB_UNUSED_SERIES_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.COURIER_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.COURIER_AWB_UNUSED_SERIES_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public CourierAWBUnusedSeriesBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
