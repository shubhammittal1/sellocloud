package com.bmp.model.bucket;

import com.bmp.constant.BucketConstants;
import com.bmp.model.config.BaseBucketModel;

public class PacketBucketModel extends BaseBucketModel {
	
	private static final String BUCKET_NAME = BucketConstants.PACKET_BUCKET_NAME;
    private static final String BUCKET_TYPE = BucketConstants.PACKET_BUCKET_TYPE;
    private static final String BUCKET_INDEX = BucketConstants.PACKET_INDEX_BUCKET;
    private static final String NOT_ASSIGNED = BucketConstants.NOT_ASSIGNED;
    
    public PacketBucketModel() {
        super(BUCKET_TYPE, BUCKET_NAME, NOT_ASSIGNED, null,BUCKET_INDEX);
    }
}
