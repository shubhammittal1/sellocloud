package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;
public class StandardParcelBucketModel extends BaseBucketModel {
	private static final String BUCKET_NAME = BucketConstants.STANDATRD_PARCEL_BUCKET;
    private static final String BUCKET_TYPE = BucketConstants.STANDATRD_PARCEL_BUCKET_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.STANDATRD_PARCEL_INDEX;
    private static final String NOT_ASSIGNED = BucketConstants.NOT_ASSIGNED;
	
    public StandardParcelBucketModel() {
		super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED,  null,BUCKET_INDEX);
	}

}
