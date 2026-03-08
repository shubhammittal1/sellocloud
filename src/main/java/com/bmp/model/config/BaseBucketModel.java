package com.bmp.model.config;

import java.util.List;

public abstract class BaseBucketModel implements RiakObject {

    private String bucketType;
    private String bucketName;
    private String keyAssignmentType;
    private List<String> fieldsIndex;
    private String keyValue;
    private String solrIndex;


    public BaseBucketModel(final String bucketType, final String bucketName,
           final String keyAssignmentType, final String keyValue, final List<String> fieldsIndex) {
        this.bucketType = bucketType;
        this.bucketName = bucketName;
        this.keyAssignmentType = keyAssignmentType;
        this.keyValue = keyValue;
        this.fieldsIndex = fieldsIndex;
    }

     public BaseBucketModel(final String bucketType, final String bucketName,
           final String keyAssignmentType, final List<String> fieldsIndex) {
        this.bucketType = bucketType;
        this.bucketName = bucketName;
        this.keyAssignmentType = keyAssignmentType;
        this.fieldsIndex = fieldsIndex;
    }

    public BaseBucketModel(final String bucketType, final String bucketName,
            final String keyAssignmentType, final List<String> fieldsIndex,
            final String solrIndex) {
         this.bucketType = bucketType;
         this.bucketName = bucketName;
         this.keyAssignmentType = keyAssignmentType;
         this.fieldsIndex = fieldsIndex;
         this.solrIndex = solrIndex;
     }
 
    public String getBucketType() {
        return this.bucketType;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKeyAssignmentType() {
        return this.keyAssignmentType;
    }

    public List<String> getFieldsIndex() {
        return this.fieldsIndex;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void addFieldsIndex(final List<String> fieldsIndexParam) {
        if (this.fieldsIndex != null) {
            this.fieldsIndex.addAll(fieldsIndexParam);
        } else {
            this.fieldsIndex = fieldsIndexParam;
        }
    }

    public String getSolrIndex() {
        return solrIndex;
    }

    public void setSolrIndex(final String solrIndex) {
        this.solrIndex = solrIndex;
    }
}