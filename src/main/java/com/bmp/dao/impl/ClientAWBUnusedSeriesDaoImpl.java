package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.constant.PaymentType;
import com.bmp.dao.ClientAWBUnusedSeriesDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.client.ClientAWBUnusedSeries;
import com.bmp.solr.common.ISolrSearchDao;
import com.bmp.solr.common.SOLRSearchDTO;

@Repository
@Qualifier("clientAWBUnusedSeriesDaoImpl")
public class ClientAWBUnusedSeriesDaoImpl extends MongoBaseDaoImpl<ClientAWBUnusedSeries> implements ClientAWBUnusedSeriesDao {
	
	@Autowired	
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;

	@Override
	public int getUnusedCodAwbSeries(String clientKey){
		SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		int totalPackets = 0;
		try {
			//String query = "clientKey_s:"+clientKey +" AND paymentType_s :"+PaymentType.COD.toString()+" AND expired_b:false";
			//solrSearchDTO.setQueryString(query);
			//totalPackets = searchDao.getCount(solrSearchDTO, ClientAWBUnusedSeries.class);
			
			Query query = new Query();
			query.addCriteria(Criteria.where("clientKey_s").is(clientKey).and("paymentType_s").is(PaymentType.COD.toString()).and("expired_b").is(false));
			totalPackets = getObjectCount(query,ClientAWBUnusedSeries.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalPackets;
	}
	
	@Override
	public int getUnusedPPAwbSeries(String clientKey){
		SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		int totalPackets = 0;
		try {
			/*String query = "clientKey_s:"+clientKey +" AND paymentType_s :"+PaymentType.PREPAID.toString()+" AND expired_b:false";
			solrSearchDTO.setQueryString(query);
			totalPackets = searchDao.getCount(solrSearchDTO, ClientAWBUnusedSeries.class);*/
			
			Query query = new Query();
			query.addCriteria(Criteria.where("clientKey_s").is(clientKey).and("paymentType_s").is(PaymentType.PREPAID.toString()).and("expired_b").in(false));
			totalPackets = getObjectCount(query,ClientAWBUnusedSeries.class);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalPackets;
	}
	
	@Override
	public int getUnusedBothAwbSeries(String clientKey){
		SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		int totalPackets = 0;
		try {
			/*String query = "clientKey_s:"+clientKey +" AND paymentType_s :"+PaymentType.BOTH.toString()+" AND expired_b:false";
			solrSearchDTO.setQueryString(query);
			totalPackets = searchDao.getCount(solrSearchDTO, ClientAWBUnusedSeries.class);*/
			
			Query query = new Query();
			query.addCriteria(Criteria.where("clientKey_s").is(clientKey).and("paymentType_s").is(PaymentType.BOTH.toString()).and("expired_b").is(false));
			totalPackets = getObjectCount(query,ClientAWBUnusedSeries.class);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalPackets;
	}
}