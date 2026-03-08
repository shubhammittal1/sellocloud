package com.bmp.dao.wms.impl;

import com.bmp.bean.common.DatatableRequestBean;
import com.bmp.bean.user.SessionUserBean;
import com.bmp.constant.GlobalConstant;
import com.bmp.constant.UserType;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.dao.wms.PackageMasterDao;
import com.bmp.model.app.wms.PackageMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Qualifier("packageMasterDaoImpl")
public class PackageMasterDaoImpl extends MongoBaseDaoImpl<PackageMaster> implements PackageMasterDao {

    @Autowired
    @Qualifier("sessionUserBean")
    private SessionUserBean sessionUserBean;

    @Override
    public List<PackageMaster> filterRecordsByClientKey(String clientKey) {
        Query query = new Query();
        if(sessionUserBean.getUser().getType().equals(UserType.CLIENT)) {
            query.addCriteria(Criteria.where("clientKey").is(sessionUserBean.getUser().getThirdPartyKey()));
        }else {
        	query.addCriteria(Criteria.where("clientKey").is(clientKey));
        }
        
        query.addCriteria(Criteria.where("expired_b").is(false));
        return getObjectByQuery(query, PackageMaster.class );
    }

    @Override
    public List<PackageMaster> getAllByRequest(DatatableRequestBean datatableRequestBean) {
        Query query = new Query();
        query.skip(datatableRequestBean.getStart());
        query.limit(datatableRequestBean.getLength());

        if (datatableRequestBean.getSearch() != null && !datatableRequestBean.getSearch().trim().isEmpty()) {
            query.addCriteria(Criteria.where("_id").regex(datatableRequestBean.getSearch(), GlobalConstant.CASE_SENSITIVE));
        }
        if (sessionUserBean != null && sessionUserBean.getUser().getType().equals(UserType.CLIENT)) {
            query.addCriteria(Criteria.where("clientKey").is(sessionUserBean.getUser().getThirdPartyKey()));
        }

        if (datatableRequestBean.getOrder() != null && !datatableRequestBean.getOrder().isEmpty()) {
            List<String> list = datatableRequestBean.getOrder().get(0);
            int columnNumber = Integer.parseInt(list.get(0));
            String orderBy = list.get(1);
            switch (columnNumber) {
                case 0:
                    if (orderBy.equals(GlobalConstant.ASC)) {
                        query.with(Sort.by(Sort.Direction.ASC, "createdDate_l"));
                    } else {
                        query.with(Sort.by(Sort.Direction.DESC, "createdDate_l"));
                    }
                    break;
            }
        }
       return  getObjectByQuery(query, PackageMaster.class);

    }

    @Override
    public boolean isExist(PackageMaster packageMaster) {
        Query  query = new Query();
        query.addCriteria(Criteria.where("clientKey").is(packageMaster.getClientKey()));
        query.addCriteria(Criteria.where("packageName").is(packageMaster.getPackageName()));
        query.addCriteria(Criteria.where("length").is(packageMaster.getLength()));
        query.addCriteria(Criteria.where("width").is(packageMaster.getWidth()));
        query.addCriteria(Criteria.where("height").is(packageMaster.getHeight()));
        query.addCriteria(Criteria.where("weight").is(packageMaster.getWeight()));
        return !getObjectByQuery(query, PackageMaster.class).isEmpty();
    }
}
