package com.bmp.bean.saleorder;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperationContext;

public class CustomFacetOperation implements AggregationOperation {

    private final Document operation;

    public CustomFacetOperation(Document operation) {
        this.operation = operation;
    }

    @Override
    public Document toDocument(AggregationOperationContext context) {
        return context.getMappedObject(operation);
    }
}
