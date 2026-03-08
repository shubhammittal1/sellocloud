package com.bmp.dao.c2c.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bmp.dao.c2c.PacketDao;
import com.bmp.dao.config.MongoBaseDaoImpl;
import com.bmp.model.c2c.Packet;

@Repository
@Qualifier("packetDaoImpl")
public class PacketDaoImpl extends MongoBaseDaoImpl<Packet> implements PacketDao {

}
