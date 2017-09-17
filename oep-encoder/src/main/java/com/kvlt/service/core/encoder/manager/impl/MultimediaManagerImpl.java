/**
 * Copyright (c) 2006, Pointdew Inc. All rights reserved.
 * 
 * http://www.pointdew.com
 */
package com.kvlt.service.core.encoder.manager.impl;

import com.kvlt.dao.BaseDao;
import com.kvlt.facade.model.AudioInfo;
import com.kvlt.facade.model.Multimedia;
import com.kvlt.facade.model.VideoInfo;
import com.kvlt.manager.impl.BaseManagerImpl;
import com.kvlt.service.core.encoder.dao.MultimediaDao;
import com.kvlt.service.core.encoder.manager.MultimediaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  
 * Defiend class file the MultimediaManagerImpl.java
 * 
 *  
 * @author Rock.Lee
 * @version appcel 1.0.0 
 * @since JDK-1.7.0
 * @date 2014-12-9
 */
@Service("multimediaManager")
public class MultimediaManagerImpl extends BaseManagerImpl<Multimedia> implements MultimediaManager {

	@Autowired
    MultimediaDao multimediaDao;

	public Multimedia createMultimedia(String entityKey, String duration, Long timelen, String type, String fps, String startTime,
                                       AudioInfo audioInfo, VideoInfo videoInfo) {
		return multimediaDao.createMultimedia(entityKey, duration, timelen, type, fps, startTime, audioInfo, videoInfo);
	}

	public Multimedia getMultimediaByKey(String key) {
		//checkParameter(key, "multimedia key");
		return multimediaDao.findMultimediaByKey(key);
	}

	public List<Multimedia> getMultimediaByEntityKey(String entityKey) {
		//checkParameter(entityKey, "Multimedia relation entityKey");
		return multimediaDao.findMultimediaByEntityKey(entityKey);
	}

	public boolean deleteMultimedaByEntityKey(String entityKey) {
		//checkParameter(entityKey, "Multimedia relation entityKey");
		return multimediaDao.deleteMultimedaByEntityKey(entityKey);
	}

	protected BaseDao<Multimedia> getDao() {
		return this.multimediaDao;
	}
}
