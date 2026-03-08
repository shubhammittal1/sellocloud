package com.bmp.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.OutgoingCallLogsDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.app.systemCalling.OutgoingCallLogs;

@Repository
@Qualifier("outgoingCallLogsDaoImpl")
public class OutgoingCallLogsDaoImpl extends MongoBaseDaoImpl<OutgoingCallLogs> implements OutgoingCallLogsDao{

}
