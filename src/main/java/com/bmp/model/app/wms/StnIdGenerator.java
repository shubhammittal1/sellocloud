package com.bmp.model.app.wms;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="stnIdGenerator")
@AssignKey(assvalue=false)
public class StnIdGenerator extends MongoBaseBean {
    private String stnIdPrefix;
    private Long stnSequenceNo;

    public String getStnIdPrefix() {
        return stnIdPrefix;
    }
    public void setStnIdPrefix(String stnIdPrefix) {
        this.stnIdPrefix = stnIdPrefix;
    }
    public Long getStnSequenceNo() {
        return stnSequenceNo;
    }
    public void setStnSequenceNo(Long stnSequenceNo) {
        this.stnSequenceNo = stnSequenceNo;
    }

}
