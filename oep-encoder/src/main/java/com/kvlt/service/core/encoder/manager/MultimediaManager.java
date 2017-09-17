/**
 * Copyright (c) 2006, Pointdew Inc. All rights reserved.
 * 
 * http://www.pointdew.com
 */
package com.kvlt.service.core.encoder.manager;

import com.kvlt.facade.model.AudioInfo;
import com.kvlt.facade.model.Multimedia;
import com.kvlt.facade.model.VideoInfo;
import com.kvlt.manager.BaseManager;

import java.util.List;

/**
 * 
 * Defiend class file the MultimediaManager.java
 * 
 *  
 * @author Rock.Lee
 * @version appcel 1.0.0
 * @since JDK-1.7.0
 * @date 2014-12-10
 */
public interface MultimediaManager extends BaseManager<Multimedia> {

	Multimedia createMultimedia(String entityKey, String duration, Long timelen, String type, String fps, String startTime,
                                AudioInfo audioInfo, VideoInfo videoInfo);

	Multimedia getMultimediaByKey(String key);

	List<Multimedia> getMultimediaByEntityKey(String entityKey);

	boolean deleteMultimedaByEntityKey(String entityKey);
}