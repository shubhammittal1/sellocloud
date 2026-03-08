package com.bmp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClientNewDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClientNew;

@Repository
@Qualifier("clientNewDaoImpl")
public class ClientNewDaoImpl extends MongoBaseDaoImpl<ClientNew>  implements ClientNewDao{

	@Override
	public String getClientActiveCourierPriority(String clientKey) throws Exception {
		if(clientKey == null || "".equals(clientKey.trim())) {
			return null;
		}
		Query query = new Query();
		query.fields().include("clientActiveCourierPriority");
		query.addCriteria(Criteria.where("_id").is(clientKey));
		List<ClientNew> keys = getObjectByQuery(query, ClientNew.class);
		return keys != null && keys.size() > 0 ? keys.get(0).getClientActiveCourierPriority() : null;
	}

}
