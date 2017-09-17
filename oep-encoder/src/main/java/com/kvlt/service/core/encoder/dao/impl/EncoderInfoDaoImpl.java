/**
 * Copyright (c) 2006, Pointdew Inc. All rights reserved.
 * 
 * http://www.pointdew.com
 */
package com.kvlt.service.core.encoder.dao.impl;

import com.kvlt.dao.impl.BaseDaoImpl;
import com.kvlt.facade.enums.EncoderPlayModeEnum;
import com.kvlt.facade.enums.EncoderStatusEnum;
import com.kvlt.facade.model.EncoderInfo;
import com.kvlt.service.core.encoder.dao.EncoderInfoDao;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 *  
 * @author Kony.Lee
 * @version appcel 1.0
 * @since JDK-1.7.0
 * @date 2016-5-11
 */
@Repository("encoderInfoDao")
public class EncoderInfoDaoImpl extends BaseDaoImpl<EncoderInfo> implements EncoderInfoDao {

	public EncoderInfo createEncoderInfo(String entityKey, String fileName, String srcFilePath, EncoderPlayModeEnum playMode,
                                         EncoderStatusEnum status, String remark) {
		EncoderInfo encoderInfo = new EncoderInfo(entityKey, fileName, srcFilePath, playMode, status, remark);
		Integer key = insert(encoderInfo);
		encoderInfo.setKey(key);
		return encoderInfo;
	}

	public EncoderInfo findEncoderInfoByKey(String key) {
		EncoderInfo encoderInfo = findByKey(key);
		return encoderInfo;
	}

	public List<EncoderInfo> findEncoderInfoByEntityKey(String entityKey) {
		return super.getSqlSessionTemplate().selectList("listByEntityKey", entityKey);
	}

	public List<EncoderInfo> findEncoderInfoByStatus(EncoderStatusEnum encoderSatus) {
		Integer status = encoderSatus.getValue();
		return super.getSqlSessionTemplate().selectList("listByStatus", status);
	}

	public boolean deleteEncoderInfoByEntityKey(String entityKey) {
		List<EncoderInfo> encoderInfos = findEncoderInfoByEntityKey(entityKey);
		if (null != encoderInfos && !encoderInfos.isEmpty()) {
			for (EncoderInfo encoderInfo : encoderInfos) {
				deleteByKey(encoderInfo.getKey());
			}
			return true;
		}
		return false;
	}

	public boolean updateEncoderTime(String key) {
		EncoderInfo encoderInfo = findByKey(key);
		if (encoderInfo != null) {
			encoderInfo.setEncoderTime(new Date());
			update(encoderInfo);
			return true;
		}
		return false;
	}

	public boolean updateEncoderStatus(String key, EncoderStatusEnum encoderSatus) {
		EncoderInfo encoderInfo = findByKey(key);
		if (encoderInfo != null) {
			encoderInfo.setStatus(encoderSatus.getValue());
			update(encoderInfo);
			return true;
		}
		return false;
	}

	public boolean deleteEncoderInfoByKey(String key) {
		EncoderInfo encoderInfo = findByKey(key);
		if (encoderInfo != null) {
			deleteByKey(encoderInfo.getKey());
			return true;
		}
		return false;
	}
}
