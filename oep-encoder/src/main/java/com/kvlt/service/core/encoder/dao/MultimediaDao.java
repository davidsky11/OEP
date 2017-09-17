/**
 * Copyright (c) 2006, Pointdew Inc. All rights reserved.
 * 
 * http://www.pointdew.com
 */
package com.kvlt.service.core.encoder.dao;

import com.kvlt.dao.BaseDao;
import com.kvlt.facade.model.AudioInfo;
import com.kvlt.facade.model.Multimedia;
import com.kvlt.facade.model.VideoInfo;

import java.util.List;

/**
 * 
 * Defiend class file the MultimediaDao.java
 *  
 * @author Rock.Lee 
 * @version appcel 1.0.0
 * @since JDK-1.7.0
 * @date 2014-12-9
 */
public interface MultimediaDao extends BaseDao<Multimedia> {

	Multimedia createMultimedia(String entityKey, String duration, Long timelen, String type, String fps, String startTime,
                                AudioInfo audioInfo, VideoInfo videoInfo);

	Multimedia findMultimediaByKey(String key);

	List<Multimedia> findMultimediaByEntityKey(String entityKey);

	boolean deleteMultimedaByEntityKey(String entityKey);

	boolean deleteMultimedaByKey(String key);
}