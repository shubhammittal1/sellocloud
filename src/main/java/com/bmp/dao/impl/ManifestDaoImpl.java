package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.ManifestDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.manifest.Manifest;
import com.bmp.solr.common.ISolrSearchDao;

@Repository
@Qualifier("manifestDaoImpl")
public class ManifestDaoImpl extends MongoBaseDaoImpl<Manifest> implements ManifestDao {

	@Autowired	
	@Qualifier("solrDaoImpl")
	private ISolrSearchDao searchDao;
	
	
	
}
