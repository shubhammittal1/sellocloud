package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class CourierPriorityTemplateBucketModel extends BaseBucketModel{

	private static final String BUCKET_NAME = BucketConstants.COURIER_PRIORITY_TEMPLATE_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.COURIER_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.COURIER_PRIORITY_TEMPLATE_BUCKET_INDEX;
    private static final String ASSIGNED = BucketConstants.ASSIGNED;

    
    public CourierPriorityTemplateBucketModel () {
        super(BUCKET_TYPE, BUCKET_NAME, ASSIGNED, null, BUCKET_INDEX);
    }
}
