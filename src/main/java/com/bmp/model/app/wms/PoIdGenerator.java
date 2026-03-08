package com.bmp.model.app.wms;

import com.bmp.dao.config.AssignKey;
import com.bmp.model.base.MongoBaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="poIdGenerator")
@AssignKey(assvalue=false)
public class PoIdGenerator extends MongoBaseBean {
    String poIdPrefix;
    Long poSequenceNo;

    public String getPoIdPrefix() {
        return poIdPrefix;
    }

    public void setPoIdPrefix(String poIdPrefix) {
        this.poIdPrefix = poIdPrefix;
    }

    public Long getPoSequenceNo() {
        return poSequenceNo;
    }

    public void setPoSequenceNo(Long poSequenceNo) {
        this.poSequenceNo = poSequenceNo;
    }
}
