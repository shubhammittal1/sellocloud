package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class SmsMailMasterBucketModel extends BaseBucketModel {

	private static final String BUCKET_NAME = BucketConstants.SMS_MAIL_MASTER_BUCKET_NAME;
    private static final String BUCKET_TYPE = BucketConstants.FACILITY_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.SMS_MAIL_MASTER_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.NOT_ASSIGNED;

    
    public SmsMailMasterBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
