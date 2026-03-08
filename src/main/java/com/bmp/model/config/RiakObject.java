package com.bmp.model.config;

import java.util.List;

public interface RiakObject {
    String getBucketType();
    String getBucketName();
    String getKeyAssignmentType();
    List<String> getFieldsIndex();
}
