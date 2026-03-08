package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;
public class WebUserBucketModel extends BaseBucketModel {
	private static final String BUCKET_NAME = BucketConstants.USER_PROFILE_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.USER_PROFILE_BUCKET_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.USER_PROFILE_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.NOT_ASSIGNED;
	
    public WebUserBucketModel() {
		super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED,  null,BUCKET_INDEX);
	}

}
