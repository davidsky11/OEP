/**
 * Copyright (c) 2006, Pointdew Inc. All rights reserved.
 * 
 * http://www.pointdew.com
 */
package com.kvlt.service.core.encoder.dao.impl;

import com.kvlt.dao.impl.BaseDaoImpl;
import com.kvlt.facade.model.AudioInfo;
import com.kvlt.facade.model.Multimedia;
import com.kvlt.facade.model.VideoInfo;
import com.kvlt.service.core.encoder.dao.MultimediaDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * Defiend class file the MultimediaDaoImpl.java 
 *  
 * @author Rock.Lee
 * @version appcel 1.0.0
 * @since JDK-1.7.0
 * @date 2014-12-9
 */
@Repository("multimediaDao")
public class MultimediaDaoImpl extends BaseDaoImpl<Multimedia> implements MultimediaDao {

	public Multimedia createMultimedia(String entityKey, String duration, Long timelen, String type, String fps, String startTime,
                                       AudioInfo audioInfo, VideoInfo videoInfo) {

		//		AudioInfo audioInfo = new AudioInfo(samplingRate, channels, audioBitrate);
		//		VideoSize videoSize = new VideoSize(sizex, width, height);
		//		VideoInfo videoInfo = new VideoInfo(videoSize, videoBitrate, frameRate, vedioformat);

		Multimedia multimedia = new Multimedia(audioInfo, videoInfo, entityKey, startTime);

		multimedia.setEntityKey(entityKey);
		multimedia.setDuration(duration);
		multimedia.setTimelen(timelen);
		multimedia.setType(type);
		multimedia.setFps(fps);
		insert(multimedia);
		return multimedia;
	}

	public Multimedia findMultimediaByKey(String key) {
		Multimedia multimedia = findByKey(key);
		return multimedia;
	}

	public List<Multimedia> findMultimediaByEntityKey(String entityKey) {
		return super.getSqlSessionTemplate().selectList("listByEntityKey", entityKey);
	}

	public boolean deleteMultimedaByEntityKey(String entityKey) {
		List<Multimedia> multimedias = findMultimediaByEntityKey(entityKey);
		if (null != multimedias && !multimedias.isEmpty()) {
			for (Multimedia multimedia : multimedias) {
				deleteByKey(multimedia.getKey());
			}
			return true;
		}
		return false;
	}

	public boolean deleteMultimedaByKey(String key) {
		Multimedia multimedia = findByKey(key);
		if (multimedia != null) {
			deleteByKey(multimedia.getKey());
			return true;
		}
		return false;
	}
}
