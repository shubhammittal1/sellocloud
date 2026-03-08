package com.bmp.dao.wms.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.wms.StockTransferNoteDao;
import com.bmp.dao.wms.WarehouseLocationDao;
import com.bmp.model.app.wms.StockTransferNote;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Repository
@Qualifier("stockTransferNoteDaoImpl")
@SuppressWarnings("unused")
public class StockTransferNoteDaoImpl extends MongoBaseDaoImpl<StockTransferNote> implements StockTransferNoteDao {

        @Autowired
        private MongoTemplate mongoTemplate;

        @Autowired
        private WarehouseLocationDao warehouseLocationDao;

        @Override
        public Integer getTotalQuantityByKey(String key, String clientKey, String warehouseKey, String skuCode,
                        String locationType) {
                List<String> locationKeyList = warehouseLocationDao
                                .getWHLocationKeyListByCKAndWHKeyAndLocationType(clientKey, warehouseKey, locationType);

                MongoTemplate mongoTemplate = getMongoTemplate();
                MongoCollection<Document> collection = mongoTemplate.getCollection("stockTransferNote");

                List<BasicDBObject> pipeline = Arrays.asList(
                                new BasicDBObject("$match", new BasicDBObject("_id", key)),
                                new BasicDBObject("$lookup", new BasicDBObject("from", "skuInventory")
                                                .append("localField", "clientKey")
                                                .append("foreignField", "clientKey")
                                                .append("as", "skuInvList")),
                                new BasicDBObject("$project", new BasicDBObject("skuInvTotal",
                                                new BasicDBObject("$sum",
                                                                new BasicDBObject("$map",
                                                                                new BasicDBObject("input",
                                                                                                new BasicDBObject(
                                                                                                                "$filter",
                                                                                                                new BasicDBObject(
                                                                                                                                "input",
                                                                                                                                "$skuInvList")
                                                                                                                                .append("as", "it")
                                                                                                                                .append("cond", new BasicDBObject(
                                                                                                                                                "$and",
                                                                                                                                                Arrays.asList(
                                                                                                                                                                new BasicDBObject(
                                                                                                                                                                                "$eq",
                                                                                                                                                                                Arrays.asList("$$it.warehouseKey",
                                                                                                                                                                                                warehouseKey)),
                                                                                                                                                                new BasicDBObject(
                                                                                                                                                                                "$eq",
                                                                                                                                                                                Arrays.asList("$$it.skuCode",
                                                                                                                                                                                                skuCode)),
                                                                                                                                                                new BasicDBObject(
                                                                                                                                                                                "$not",
                                                                                                                                                                                Arrays.asList(
                                                                                                                                                                                                new BasicDBObject(
                                                                                                                                                                                                                "$regexMatch",
                                                                                                                                                                                                                new BasicDBObject(
                                                                                                                                                                                                                                "input",
                                                                                                                                                                                                                                "$$it.warehouseLocationKey")
                                                                                                                                                                                                                                .append("regex", "VIRTUAL_LOCATION$$")))),
                                                                                                                                                                new BasicDBObject(
                                                                                                                                                                                "$in",
                                                                                                                                                                                Arrays.asList("$$it.warehouseLocationKey",
                                                                                                                                                                                                locationKeyList))))))

                                                                                )
                                                                                                .append("as", "f")
                                                                                                .append("in", "$$f.totalQty"))))));

                MongoCursor<Document> cursor = collection.aggregate(pipeline).iterator();

                if (cursor.hasNext()) {
                        Document doc = cursor.next();
                        Object val = doc.get("skuInvTotal");
                        if (val instanceof Number) {
                                return ((Number) val).intValue();
                        }
                        if (val != null) {
                                try {
                                        return Integer.parseInt(val.toString());
                                } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                        return 0;
                                }
                        }
                }
                return 0;
        }
}