package com.bmp.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.bean.courier.FieldBean;
import com.bmp.bean.user.SessionUserBean;
import com.bmp.dao.CourierAuthConfigDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.courier.CourierAuthConfig;


@Repository
@Qualifier("courierAuthConfigDaoImpl")
public class CourierAuthConfigDaoImpl extends MongoBaseDaoImpl<CourierAuthConfig> implements CourierAuthConfigDao {
	
	@Autowired
	@Qualifier("sessionUserBean")
	private SessionUserBean sessionUserBean;
	
	@Autowired 
	@Qualifier("mongoTemplateRead")
	private MongoTemplate mongoTemplateRead;
	
	public CourierAuthConfig getObjectByCourier(String courier,final Class<CourierAuthConfig> classVal) {
		//return this.mongoTemplate.findOne(new Query(Criteria.where(courierKey).is(courierKey)), classVal);
		Query query = new Query();
		query.addCriteria(Criteria.where("courier").is(courier));
		
		return this.mongoTemplateRead.findOne(query, classVal);
		// return this.mongoTemplateRead.findOne(new Query(CritesessionUserBean.getOrganization()ria.where(courierKey).is(courierKey)), classVal);
		
	}

	@Override
	public void deleteFieldBeanByCourier(String courier) {
		CourierAuthConfig courierAuthConfig = getObjectByCourier(courier, CourierAuthConfig.class);
		try {
			if(courierAuthConfig != null) {
				saveObject(courierAuthConfig, CourierAuthConfig.class);
			} 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteFieldRecordByFieldCode(String courier,String fieldCode) {
		CourierAuthConfig courierAuthConfig = getObjectByCourier(courier, CourierAuthConfig.class);
		List<FieldBean> fieldBean= courierAuthConfig.getFieldBean();
		Iterator<FieldBean> iterator = fieldBean.iterator();
		try {
				 while (iterator.hasNext()) {
		                FieldBean fieldBeanIterator = iterator.next();
		                if (fieldBeanIterator.getFieldCode().equals(fieldCode)) {
		                    iterator.remove();
		                    break;
		                }
		            }
			if(courierAuthConfig != null) {
				saveObject(courierAuthConfig, CourierAuthConfig.class);
			} 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
