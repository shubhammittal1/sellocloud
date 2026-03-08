package com.bmp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.BranchRouteDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.facility.BranchRoute;
import com.bmp.solr.common.ISolrSearchDao;

@Repository
@Qualifier("branchRouteDaoImpl")
public class BranchRouteDaoImpl extends MongoBaseDaoImpl<BranchRoute> implements
		BranchRouteDao {

	@Autowired
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;

	@Override
	public List<BranchRoute> routeListByBranchName(String branchKey) throws Exception {
		
		Query query = new Query();
		Object obj[] = branchKey.split(",");
		query.addCriteria(Criteria.where("branchKey_s").in(obj));
		List<BranchRoute> resultList = getObjectByQuery(query, BranchRoute.class);
		return resultList;
		
		/*SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		solrSearchDTO.setQueryString("branchKey_s:"+ branchKey.replaceAll(" ", "*"));
		List<BranchRoute> branchRouteList = new ArrayList<BranchRoute>();
		List<String> keyList = searchDao.getKeys(solrSearchDTO,BranchRoute.class);
		for (String key : keyList) {
			BranchRoute branchRoute = getObjectById(key,BranchRoute.class);
			if (branchRoute != null)
				branchRouteList.add(branchRoute);
		}
		return branchRouteList;*/
	}

}
