package com.bmp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ColoaderDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.coloader.Coloader;
import com.bmp.model.app.masters.PincodeGroup;
import com.bmp.solr.common.ISolrSearchDao;
import com.bmp.utility.QueryUtility;

@Repository
@Qualifier("coloaderDaoImpl")
public class ColoaderDaoImpl extends MongoBaseDaoImpl<Coloader>  implements ColoaderDao{

	@Autowired	
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;
	
	/*@Override
	public List<Coloader> getColoader(List<PincodeGroup> groups) throws Exception {
		
		String query = "";
		for (int i = 0; i < groups.size(); i++) {
			for (int j = 0; j < groups.size(); j++) {
				query += groups.get(i).getKey_s() + "_" + groups.get(j).getKey_s()+ " OR ";
			}
		}
		query = query.substring(0, query.lastIndexOf(" OR "));
		if(query.contains(" OR ")){
			query = "pincodeGroupZoneMatrix.groupToGroups_ss:("+query+")";
		}else{
			query = "pincodeGroupZoneMatrix.groupToGroups_ss:"+query;
		}
		SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		solrSearchDTO.setQueryString(query);
		List<String> keysList = searchDao.getKeys(solrSearchDTO, Coloader.class);
		return getEntityByLocationKey(keysList, Coloader.class);
		return null;
	}
	
	@Override
	public List<Coloader> getColoader (List<PincodeGroup> sourceBranchpincodeGroupList, List<PincodeGroup> destinationBranchpincodeGroupList) throws Exception {

		if(sourceBranchpincodeGroupList.size() > 0 && destinationBranchpincodeGroupList.size() > 0){
			String query = "";
			for (int i = 0; i < sourceBranchpincodeGroupList.size(); i++) {
				for (int j = 0; j < destinationBranchpincodeGroupList.size(); j++) {
					query += sourceBranchpincodeGroupList.get(i).getKey_s() + "_" + destinationBranchpincodeGroupList.get(j).getKey_s()+ " OR ";
				}
			}
			for (int i = 0; i < destinationBranchpincodeGroupList.size(); i++) {
				for (int j = 0; j < sourceBranchpincodeGroupList.size(); j++) {
					query += destinationBranchpincodeGroupList.get(i).getKey_s() + "_" + sourceBranchpincodeGroupList.get(j).getKey_s()+ " OR ";
				}
			}
			query = query.substring(0, query.lastIndexOf(" OR "));
			if(query.contains(" OR ")){
				query = "pincodeGroupZoneMatrix.groupToGroups_ss:("+query+")";
			}else{
				query = "pincodeGroupZoneMatrix.groupToGroups_ss:"+query;
			}
			SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
			solrSearchDTO.setQueryString(query);
			List<String> keysList = searchDao.getKeys(solrSearchDTO, Coloader.class);
			return getEntityByLocationKey(keysList, Coloader.class);
			return null;
		}
		return null;	
	}*/
	
	@Override
	public List<Coloader> getColoader(List<PincodeGroup> groups) throws Exception {
		
		Query query = new Query(); 
		
		String value = "";
		for (int i = 0; i < groups.size(); i++) {
			for (int j = 0; j < groups.size(); j++) {
				value += groups.get(i).getKey_s() + "_" + groups.get(j).getKey_s()+ " , ";
			}
		}
		value = value.substring(0, value.lastIndexOf(" , "));
		if(value.contains(" , ")) {
			
			Criteria[] criterias = QueryUtility.orQuery("pincodeGroupZoneMatrix.groupToGroups_ss", value);
			query.addCriteria(new Criteria().orOperator(criterias));
			
		} else {
			
			query.addCriteria(Criteria.where("pincodeGroupZoneMatrix.groupToGroups_ss").is(value));
			
		}
		
		return getObjectByQuery(query, Coloader.class);
	}
	
	@Override
	public List<Coloader> getColoader (List<PincodeGroup> sourceBranchpincodeGroupList, List<PincodeGroup> destinationBranchpincodeGroupList) throws Exception {

		Query query = new Query();
		
		if(sourceBranchpincodeGroupList.size() > 0 && destinationBranchpincodeGroupList.size() > 0){
			String value = "";
			for (int i = 0; i < sourceBranchpincodeGroupList.size(); i++) {
				for (int j = 0; j < destinationBranchpincodeGroupList.size(); j++) {
					value += sourceBranchpincodeGroupList.get(i).getKey_s() + "_" + destinationBranchpincodeGroupList.get(j).getKey_s()+ " , ";
				}
			}
			for (int i = 0; i < destinationBranchpincodeGroupList.size(); i++) {
				for (int j = 0; j < sourceBranchpincodeGroupList.size(); j++) {
					value += destinationBranchpincodeGroupList.get(i).getKey_s() + "_" + sourceBranchpincodeGroupList.get(j).getKey_s()+ " , ";
				}
			}
			value = value.substring(0, value.lastIndexOf(" , "));
			if(value.contains(" , ")) {
				
				Criteria[] criterias = QueryUtility.orQuery("pincodeGroupZoneMatrix.groupToGroups_ss", value);
				query.addCriteria(new Criteria().orOperator(criterias));
				
			} else {
				
				query.addCriteria(Criteria.where("pincodeGroupZoneMatrix.groupToGroups_ss").is(value));
				
			}
			
			return getObjectByQuery(query, Coloader.class);
		}
		return null;	
	}
	
}