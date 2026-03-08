package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class WebUserAccountLogBucketModel extends BaseBucketModel {

	private static final String BUCKET_NAME = BucketConstants.WEB_USER_LOG_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.USER_PROFILE_BUCKET_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.WEB_USER_LOG_C2C_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;
	
    public WebUserAccountLogBucketModel() {
		super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
	}

}
