package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class ManifestBucketModel extends BaseBucketModel{

	private static final String BUCKET_NAME = BucketConstants.MANIFEST_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.MANIFEST_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.MANIFEST_BUCKET_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.ASSIGNED;
    
    public ManifestBucketModel () {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null, BUCKET_INDEX);
    }
}
