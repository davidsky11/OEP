/**
 * Copyright (c) 2006, Pointdew Inc. All rights reserved.
 * 
 * http://www.pointdew.com
 */
package com.kvlt.service.core.encoder.manager;

import com.kvlt.facade.enums.EncoderPlayModeEnum;
import com.kvlt.facade.enums.EncoderStatusEnum;
import com.kvlt.facade.model.Configure;
import com.kvlt.facade.model.EncoderInfo;
import com.kvlt.manager.BaseManager;

import java.util.List;
import java.util.Map;

/**
 *  
 * @author Kony.Lee
 * @version appcel 1.0
 * @since JDK-1.7.0
 * @date 2016-5-12
 */
public interface EncoderInfoManager extends BaseManager<EncoderInfo> {

	EncoderInfo createEncoderInfo(String entityKey, String fileName, String srcFilePath, EncoderPlayModeEnum playMode,
                                  EncoderStatusEnum status, String remark);

	EncoderInfo getEncoderInfoByKey(String key);

	List<EncoderInfo> getEncoderInfoByEntityKey(String entityKey);

	boolean deleteEncoderInfoByEntityKey(String entityKey);

	boolean updateEncoderTime(String key);

	boolean deleteEncoderInfoByKey(String key);

	Configure createConfigure(String name, String value, String remark);

	Configure getConfigureByKey(String key);

	List<Configure> getAllConfigure();

	boolean deleteConfigureByKey(String key);

	boolean updateEncoderStatus(String key, EncoderStatusEnum encoderSatus);

	List<EncoderInfo> getEncoderInfoByStatus(EncoderStatusEnum encoderSatus);

	Map<String, Configure> getAllConfigureMap();

}