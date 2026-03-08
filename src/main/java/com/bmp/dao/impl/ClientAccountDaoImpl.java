package com.bmp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ClientAccountDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClientAccount;
import com.bmp.utility.CommonUtility;

@Repository
@Qualifier("clientAccountDaoImpl")
public class ClientAccountDaoImpl extends MongoBaseDaoImpl<ClientAccount> implements ClientAccountDao {

	@Override
	public Double getAccountBalance(String clientKey) {
		try {
			Query query = new Query();
			query.fields().include("currentBalance");
			query.addCriteria(Criteria.where("clientKey_s").is(clientKey));
			List<ClientAccount> clientAccountList = getObjectByQuery(query, ClientAccount.class);
			Double amount = (clientAccountList != null && clientAccountList.size() > 0 ? clientAccountList.get(0).getCurrentBalance() : null);
			return amount != null ? CommonUtility.roundTwoDecimalPlaces(amount) : null;
		}catch (Exception e) {
			//e.printStackTrace();
		}
		return null;
	}

}
