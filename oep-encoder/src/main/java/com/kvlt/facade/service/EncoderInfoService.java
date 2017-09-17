/**
 * Copyright (c) 2006, Pointdew Inc. All rights reserved.
 * 
 * http://www.pointdew.com
 */
package com.kvlt.facade.service;

import com.kvlt.facade.enums.EncoderPlayModeEnum;
import com.kvlt.facade.enums.EncoderStatusEnum;
import com.kvlt.facade.model.Configure;
import com.kvlt.facade.model.EncoderInfo;

import java.util.List;

/**
 *  
 * @author Kony.Lee
 * @version appcel 1.0
 * @since JDK-1.7.0
 * @date 2016-5-12
 */
public interface EncoderInfoService {

	EncoderInfo createEncoderInfo(String entityKey, String fileName, String srcFilePath, EncoderPlayModeEnum playMode,
                                  EncoderStatusEnum status, String remark);

	EncoderInfo getEncoderInfoByKey(String key);

	List<EncoderInfo> getEncoderInfoByEntityKey(String entityKey);

	boolean deleteEncoderInfoByEntityKey(String entityKey);

	boolean updateEncoderTime(String key);

	boolean deleteEncoderInfoByKey(String key);

	Configure createConfigure(String name, String value, String remark);

	Configure findConfigureByKey(String key);

	List<Configure> getAllConfigure();

	boolean deleteConfigureByKey(String key);

}