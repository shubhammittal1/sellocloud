package com.bmp.dao.wms.impl;

import com.bmp.bean.user.SessionUserBean;
import com.bmp.constant.LocationType;
import com.bmp.constant.UserType;
import com.bmp.constant.VirtualLocation;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.wms.WarehouseLocationDao;
import com.bmp.model.app.wms.WarehouseLocationMaster;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("warehouseLocationDaoImpl")
public class WarehouseLocationDaoImpl extends MongoBaseDaoImpl<WarehouseLocationMaster> implements WarehouseLocationDao {

	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;
	
	@Autowired
    @Qualifier("mongoTemplateRead")
    private MongoTemplate mongoTemplate;

	@Override
	public WarehouseLocationMaster getWarehouseLocation(String clientKey, String warehouseKey, String locationCode) {
		Query query = new Query();
	    query.addCriteria(Criteria.where("clientKey").is(clientKey));
	    query.addCriteria(Criteria.where("warehouseKey").is(warehouseKey));
	    query.addCriteria(Criteria.where("locationCode").is(locationCode));
	    
	    List<WarehouseLocationMaster> warehouseLocationMaster = getObjectByQuery(query, WarehouseLocationMaster.class);
		if( warehouseLocationMaster!=null && warehouseLocationMaster.size()>0) {
		 return warehouseLocationMaster.get(warehouseLocationMaster.size()-1);
		}
		
		return null;
	}

	@Override
	public List<WarehouseLocationMaster> getWhLocByKey(String key1,String key2,String locType) {
		List<WarehouseLocationMaster> warehouseLocationMaster;
		Query query = new Query();
		query.addCriteria(Criteria.where("warehouseKey").is(key2));
		query.addCriteria(Criteria.where("locationCode").not().regex(".*VIRTUAL_LOCATION.*", "i"));
        if(locType != null && !locType.isEmpty()) {
            query.addCriteria(Criteria.where("locationType").is(locType));
        }
		if(sessionUserBean.getUser().getType().equals(UserType.CLIENT)) {
			query.addCriteria(Criteria.where("clientKey").is(sessionUserBean.getUser().getThirdPartyKey()));
			warehouseLocationMaster = getObjectByQuery(query,WarehouseLocationMaster.class);
		}else {
			query.addCriteria(Criteria.where("clientKey").is(key1));
			warehouseLocationMaster = getObjectByQuery(query,WarehouseLocationMaster.class);
		}
		if( warehouseLocationMaster != null && !warehouseLocationMaster.isEmpty()) {
			return warehouseLocationMaster;
		}
		return warehouseLocationMaster;
	}

    @Override
	public String getNameByLocationKey(String key) {
		Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(key.trim()));

        // Fetch all records that match the query
        List<WarehouseLocationMaster> WarehouseLocationMasterList = mongoTemplate.find(query, WarehouseLocationMaster.class);
        if(WarehouseLocationMasterList!=null && WarehouseLocationMasterList.size()>0) {
        	return WarehouseLocationMasterList.get(WarehouseLocationMasterList.size()-1).getLocationName();
        }
		return null;
	}

	@Override
	public WarehouseLocationMaster getWarehouseVirtualLocation(String clientKey, String warehouseKey,
			VirtualLocation locationCode) throws Exception {
		Query query = new Query();
	    query.addCriteria(Criteria.where("clientKey").is(clientKey));
	    query.addCriteria(Criteria.where("warehouseKey").is(warehouseKey));
	    query.addCriteria(Criteria.where("locationCode").is(locationCode.name()));
	    query.addCriteria(Criteria.where("isVirtualLocation").is(true));
	    
	    List<WarehouseLocationMaster> warehouseLocationMaster = getObjectByQuery(query, WarehouseLocationMaster.class);
		if( warehouseLocationMaster!=null && warehouseLocationMaster.size()>0) {
		 return warehouseLocationMaster.get(warehouseLocationMaster.size()-1);
		}
		WarehouseLocationMaster location = new WarehouseLocationMaster();
		location.setClientKey(clientKey);
		location.setWarehouseKey(warehouseKey);
		location.setLocationName(locationCode.name());
		location.setLocationCode(locationCode.name());
		location.setKey_s(clientKey+"_"+warehouseKey+"_"+locationCode.name());
		location.setLocationType(LocationType.GOOD);
		location.setLocationCapacity(100000l);
		location.setVirtualLocation(true);
		getMongoTemplate().save(location);
		
		return location;
	}

	@Override
	public List<String> getWHLocationKeyListByCKAndWHKeyAndLocationType(String clientKey, String warehouseKey,String locationType) {
		Query query = new Query();
		query.addCriteria(Criteria.where("clientKey").is(clientKey));
		query.addCriteria(Criteria.where("warehouseKey").is(warehouseKey));
		query.addCriteria(Criteria.where("isVirtualLocation").is(false));
		query.addCriteria(Criteria.where("locationType").is(locationType));
		List<WarehouseLocationMaster> warehouseLocation = getObjectByQuery(query, WarehouseLocationMaster.class);
		List<String> warehouseVirtualLocations = new ArrayList<>();
		for(WarehouseLocationMaster location : warehouseLocation) {
			warehouseVirtualLocations.add(location.getKey_s());
		}
		return  warehouseVirtualLocations;
	}

    @Override
    public WarehouseLocationMaster getWarehouseVirtualLocByType(String clientKey, String warehouseKey, VirtualLocation locationCode, LocationType locationType) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("clientKey").is(clientKey));
        query.addCriteria(Criteria.where("warehouseKey").is(warehouseKey));
        query.addCriteria(Criteria.where("locationCode").is(locationCode.name()));
        query.addCriteria(Criteria.where("locationType").is(locationType));
        query.addCriteria(Criteria.where("isVirtualLocation").is(true));

        List<WarehouseLocationMaster> warehouseLocationMaster = getObjectByQuery(query, WarehouseLocationMaster.class);
        if( warehouseLocationMaster!=null && warehouseLocationMaster.size()>0) {
            return warehouseLocationMaster.get(warehouseLocationMaster.size()-1);
        }
        WarehouseLocationMaster location = new WarehouseLocationMaster();
        location.setClientKey(clientKey);
        location.setWarehouseKey(warehouseKey);
        location.setLocationName(locationCode.name());
        location.setLocationCode(locationCode.name());
        location.setKey_s(clientKey+"_"+warehouseKey+"_"+locationCode.name());
        location.setLocationType(LocationType.GOOD);
        location.setLocationCapacity(100000l);
        location.setVirtualLocation(true);
        getMongoTemplate().save(location);

        return location;
    }

	@Override
	public List<String> getWarehouseLocationByKeyAndType(String clientKey, String warehouseKey,String type, String isVirtualLocation) {
		Query query = new Query();
		query.addCriteria(Criteria.where("clientKey").is(clientKey));
        query.addCriteria(Criteria.where("warehouseKey").is(warehouseKey));
        if(isVirtualLocation!=null && !isVirtualLocation.equals("")) {
        	query.addCriteria(Criteria.where("isVirtualLocation").is(isVirtualLocation.equals("false")?false:true));
        }
		if(type!=null && !type.equals("")) {
			query.addCriteria(Criteria.where("locationType").is(type));
		}
	    List<WarehouseLocationMaster> warehouseLocation = getObjectByQuery(query, WarehouseLocationMaster.class);
		List<String> warehouseVirtualLocations = new ArrayList<>();
		for(WarehouseLocationMaster location : warehouseLocation) {
			warehouseVirtualLocations.add(location.getKey_s());
		}
		return  warehouseVirtualLocations;
	}
	@Override
	public List<WarehouseLocationMaster> getWHLocationByCLKeyAndWHKey(String clientKey, String warehouseKey) {
		Query query = new Query();
		query.addCriteria(Criteria.where("clientKey").is(clientKey));
        query.addCriteria(Criteria.where("warehouseKey").is(warehouseKey));
        query.addCriteria(Criteria.where("isVirtualLocation").is(false));
        
	    List<WarehouseLocationMaster> warehouseLocation = getObjectByQuery(query, WarehouseLocationMaster.class);
		
		return  warehouseLocation;
	}
}
