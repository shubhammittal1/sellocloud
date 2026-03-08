package com.bmp.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.common.SolrDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bmp.constant.PaymentType;
import com.bmp.dao.CourierAWBUnusedSeriesDao;
import com.bmp.dao.SaleOrderDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.courier.CourierAWBUnusedSeries;
import com.bmp.model.app.saleorder.SaleOrder;
import com.bmp.solr.common.ISolrSearchDao;
import com.bmp.solr.common.SOLRSearchDTO;

@Repository
@Qualifier("courierAWBUnusedSeriesDaoImpl")
public class CourierAWBUnusedSeriesDaoImpl extends MongoBaseDaoImpl<CourierAWBUnusedSeries> implements CourierAWBUnusedSeriesDao {

	/*@Autowired	
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;*/
	
	@Autowired	
	@Qualifier("saleOrderDaoImpl")
	private SaleOrderDao saleOrderDao;

	@Override
	public int getUnusedCodAwbSeries(String clientKey){
		SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		int totalPackets = 0;
		try {
			/*String query = "courierKey_s:"+clientKey +" AND paymentType_s :"+PaymentType.COD.toString()+" AND expired_b:false";
			solrSearchDTO.setQueryString(query);
			totalPackets = searchDao.getCount(solrSearchDTO, CourierAWBUnusedSeries.class);*/
			
			Query query = new Query();
			query.addCriteria(Criteria.where("courierKey_s").is(clientKey).and("paymentType_s").is(PaymentType.COD.toString()).and("expired_b").is(false));
			totalPackets = getObjectCount(query,CourierAWBUnusedSeries.class);
				
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
			/*String query = "courierKey_s:"+clientKey +" AND paymentType_s :"+PaymentType.PREPAID.toString()+" AND expired_b:false";
			solrSearchDTO.setQueryString(query);
			totalPackets = searchDao.getCount(solrSearchDTO, CourierAWBUnusedSeries.class);*/
			
			Query query = new Query();
			query.addCriteria(Criteria.where("courierKey_s").is(clientKey).and("paymentType_s").is(PaymentType.PREPAID.toString()).and("expired_b").is(false));
			totalPackets = getObjectCount(query,CourierAWBUnusedSeries.class);
				
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
			/*String query = "courierKey_s:"+clientKey +" AND paymentType_s :"+PaymentType.BOTH.toString()+" AND expired_b:false";
			solrSearchDTO.setQueryString(query);
			totalPackets = searchDao.getCount(solrSearchDTO, CourierAWBUnusedSeries.class);*/
			
			Query query = new Query();
			query.addCriteria(Criteria.where("courierKey_s").is(clientKey).and("paymentType_s").is(PaymentType.BOTH.toString()).and("expired_b").is(false));
			totalPackets = getObjectCount(query,CourierAWBUnusedSeries.class);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalPackets;
	}

	/*@Override
	public List<String> getUnUsedCourierAwbnumber(String courierKey, PaymentType paymentType) throws Exception {
		SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		String query = "courierKey_s:"+courierKey+" AND paymentType_s:"+paymentType.toString();
		solrSearchDTO.setPageSize(100);
		solrSearchDTO.setQueryString(query);
		return searchDao.getKeys(solrSearchDTO, CourierAWBUnusedSeries.class);
	}*/
	
	@Override
	public List<String> getUnUsedCourierAwbnumber(String courierKey, PaymentType paymentType) throws Exception {
		//TODO
		/*SOLRSearchDTO solrSearchDTO = new SOLRSearchDTO();
		String query = "courierKey_s:"+courierKey+" AND paymentType_s:"+paymentType.toString();
		solrSearchDTO.setQueryString(query);
		int totalCount = searchDao.getCount(solrSearchDTO, CourierAWBUnusedSeries.class);
		int pageSize = 20;
		int noOfPages = totalCount/pageSize;
		Random random = new Random();
		int randomPageNo = random.nextInt(noOfPages-1)+1;
		
		solrSearchDTO = new SOLRSearchDTO();
		query = "courierKey_s:"+courierKey+" AND paymentType_s:"+paymentType.toString();
		solrSearchDTO.setPageNumber(randomPageNo);
		solrSearchDTO.setPageSize(pageSize);
		solrSearchDTO.setQueryString(query);
		
		List<String> awbKeys = searchDao.getKeys(solrSearchDTO, CourierAWBUnusedSeries.class);
		
		List<String> saleOrderAwbs = new ArrayList<>(); 
		query = "courierAWBNumber_s:("+StringUtils.join(awbKeys," OR ")+")";
		solrSearchDTO.setQueryString(query);
		List<String> returnColumn = new ArrayList<>();
		returnColumn.add("courierAWBNumber_s");
		solrSearchDTO.setReturnList(returnColumn);
		
		List<SolrDocument> saleOrderDocList = searchDao.getSolrDocument(solrSearchDTO, CourierAWBUnusedSeries.class);
		if (saleOrderDocList != null && saleOrderDocList .size() > 0) {
			for(SolrDocument seriesUsedDoc : saleOrderDocList ){
				saleOrderAwbs.add(seriesUsedDoc.get("courierAWBNumber_s").toString());
			}
		}
		
		awbKeys.removeAll(saleOrderAwbs);
		return awbKeys;*/
		
		Query query = new Query();
		/*
		//Before - 30Nov18 - with random logic for solr indexing issue
		query.addCriteria(Criteria.where("courierKey_s").is(courierKey).and("paymentType_s").is(paymentType.toString()));
		int totalCount = getObjectCount(query,CourierAWBUnusedSeries.class);
		int pageSize = 20;
		int noOfPages = totalCount/pageSize;
		Random random = new Random();
		int rt = noOfPages +1;
		int randomPageNo = random.nextInt(rt);
		
		query = new Query();
		//query.fields().include("_id");
		query.addCriteria(Criteria.where("courierKey_s").is(courierKey).and("paymentType_s").is(paymentType.toString()));
		query.skip(randomPageNo).limit(pageSize);
		*/
		
		//After - 30Nov18 - without random logic for getting sequential courier awb
		int pageSize = 20;
		query = new Query();
		query.addCriteria(Criteria.where("courierKey_s").is(courierKey).and("paymentType_s").is(paymentType.toString()));
		query.limit(pageSize);
		query.with(Sort.by(Sort.Direction.ASC, "createdDate_l"));
		
		List<String> objList = getObjectsIdList(query, CourierAWBUnusedSeries.class);

		/*List<String> awbKeys = new ArrayList<String>(objList);
		query = new Query();
		query.fields().include("courierAWBNumber_s");
		query.addCriteria((Criteria.where("courierAWBNumber_s").in(StringUtils.join(awbKeys," , "))));
		List<SaleOrder> saleOrderList = saleOrderDao.getObjectByQuery(query, SaleOrder.class);
		
		List<String> saleOrderAwbs = new ArrayList<>();
		for(SaleOrder saleOrder : saleOrderList) {
			if(saleOrder != null && saleOrder.getCourierAWBNumber_s() != null && !"".equals(saleOrder.getCourierAWBNumber_s().trim())) {
				saleOrderAwbs.add(saleOrder.getCourierAWBNumber_s());
			}
		}
		awbKeys.removeAll(saleOrderAwbs);*/
		return objList;
		
	}
	
}