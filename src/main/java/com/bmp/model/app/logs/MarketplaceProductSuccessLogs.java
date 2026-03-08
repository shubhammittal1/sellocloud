package com.bmp.model.app.logs;


import com.bmp.constant.CatalogueSource;
import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="marketplaceProductSuccessLogs")
@AssignKey(assvalue=true)
public class MarketplaceProductSuccessLogs extends MongoBaseBean {
    private String url;
    private String requestMethod;
    private String header;
    private String payload;
    private String response;
    @Indexed
    private String skuCode;
    private CatalogueSource source;
    private String actionType;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public CatalogueSource getSource() {
        return source;
    }

    public void setSource(CatalogueSource source) {
        this.source = source;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }
}
