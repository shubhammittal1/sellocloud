package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public abstract class SettingBucketModel extends BaseBucketModel {
	
	private static final String BUCKET_NAME = BucketConstants.SETTING_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.CONFIG_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.SETTING_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;

    
    public SettingBucketModel () {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null, BUCKET_INDEX);
    }
}
