/**
 * Copyright (c) 2006, Pointdew Inc. All rights reserved.
 * 
 * http://www.pointdew.com
 */
package com.kvlt.service.core.encoder.dao;

import com.kvlt.dao.BaseDao;
import com.kvlt.facade.model.Configure;

import java.util.List;

/**
 *  
 * @author Kony.Lee
 * @version appcel 1.0
 * @since JDK-1.7.0
 * @date 2016-5-12
 */
public interface ConfigureDao extends BaseDao<Configure> {

	Configure createConfigure(String name, String value, String remark);

	Configure findConfigureByKey(String key);

	List<Configure> listAllConfigure();

	boolean deleteConfigureByKey(String key);

}