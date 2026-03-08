package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class ReportQueueBucketModel extends BaseBucketModel {
	
	private static final String BUCKET_NAME = BucketConstants.REPORT_QUEUE_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.REPORT_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.REPORT_QUEUE_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

	 public ReportQueueBucketModel () {
	        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null, BUCKET_INDEX);
	    }
}
