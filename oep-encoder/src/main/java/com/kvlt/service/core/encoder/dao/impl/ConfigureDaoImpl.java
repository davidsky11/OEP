/**
 * Copyright (c) 2006, Pointdew Inc. All rights reserved.
 * 
 * http://www.pointdew.com
 */
package com.kvlt.service.core.encoder.dao.impl;

import com.kvlt.dao.impl.BaseDaoImpl;
import com.kvlt.facade.model.Configure;
import com.kvlt.service.core.encoder.dao.ConfigureDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  
 * @author Kony.Lee
 * @version appcel 1.0
 * @since JDK-1.7.0
 * @date 2016-5-11
 */
@Repository("configureDao")
public class ConfigureDaoImpl extends BaseDaoImpl<Configure, Integer> implements ConfigureDao {

	public Configure createConfigure(String name, String value, String remark) {
		Configure configure = new Configure(name, value, remark);
        Integer key = insert(configure);
		configure.setKey(key);
		return configure;
	}

	public Configure findConfigureByKey(String key) {
		Configure encoderInfo = findByKey(key);
		return encoderInfo;
	}

	public List<Configure> listAllConfigure() {
		return super.listAll();
	}

	public boolean deleteConfigureByKey(String key) {
		Configure configure = findByKey(key);
		if (configure != null) {
			deleteByKey(configure.getKey());
			return true;
		}
		return false;
	}
}
