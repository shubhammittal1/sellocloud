package com.bmp.dao.wms.impl;

import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.wms.SupplierDao;
import com.bmp.model.app.wms.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
@Qualifier("supplierDaoImpl")
public class SupplierDaoImpl extends MongoBaseDaoImpl<Supplier> implements SupplierDao {

    @Autowired
    @Qualifier("mongoTemplateRead")
    private MongoTemplate mongoTemplate;

    @Override
    public Map<String, String> findDistinctSupplier() {
        Query query = new Query();
        query.fields().include("key_s").include("name").include("expired_b");

        // Fetch all records that match the query
        List<Supplier> suppliers = mongoTemplate.find(query, Supplier.class);

        // Use Map to collect distinct parent keys
        Map<String,String> uniqueRecords = new TreeMap<>();

        // Loop through the results and add each parentKey to the Map
        for (Supplier supplier : suppliers) {
            uniqueRecords.put(supplier.getKey_s(), supplier.getVendorName());
        }

        // Convert the Set to a List and return
        return uniqueRecords;
    }
    @Override
    public Map<String, String> findSupplierByClient(String key){
        Query query= new Query();
        query.addCriteria(Criteria.where("clientKey").is(key));
        List<Supplier> suppliers = mongoTemplate.find(query, Supplier.class);
        Map<String,String> uniqueRecords = new TreeMap<>();

        for (Supplier supplier : suppliers) {
            uniqueRecords.put(supplier.getKey_s(), supplier.getVendorName());
        }
        return uniqueRecords;
    }
}
