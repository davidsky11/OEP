/**
 * Copyright (c) 2006, Pointdew Inc. All rights reserved.
 * 
 * http://www.pointdew.com
 */
package com.kvlt.facade.listener;

import com.kvlt.facade.dto.MultimediaInfo;

/**
 * 
 * Defiend class file the EncoderProgressListener.java
 * 
 * Encoding progress listener interface. Instances of implementing classes could
 * be used to listen an encoding process. 
 *  
 * @author Rock.Lee
 * @version appcel 1.0.0
 * @since JDK-1.7.0
 * @date 2014-12-2
 */
public interface EncoderProgressListener {

	/**
	 * This method is called before the encoding process starts, reporting
	 * information about the source stream that will be decoded and re-encoded.
	 * 
	 * @param info
	 *            Informations about the source multimedia stream.
	 */
	public void sourceInfo(MultimediaInfo info);

	/**
	 * This method is called to notify a progress in the encoding process.
	 * 
	 * @param permil
	 *            A permil value representing the encoding process progress.
	 */
	public void progress(int permil);

	/**
	 * This method is called every time the facade need to send a message
	 * (usually, a warning).
	 * 
	 * @param message
	 *            The message sent by the facade.
	 */
	public void message(String message);

}
