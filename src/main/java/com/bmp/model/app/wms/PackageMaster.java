package com.bmp.model.app.wms;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="packageMaster")
@AssignKey(assvalue=true)
public class PackageMaster extends MongoBaseBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String clientKey;
    private String packageName;
    private double length;
    private double width;
    private double height;
    private double weight;

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
