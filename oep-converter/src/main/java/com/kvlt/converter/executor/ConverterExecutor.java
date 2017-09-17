/**
 * Copyright (c) 2006, Pointdew Inc. All rights reserved.
 * 
 * http://www.pointdew.com
 */
package com.kvlt.converter.executor;

import com.kvlt.converter.exception.ConverterException;

import java.io.File;

/**
 *  
 * @author Kony.Lee
 * @version appcel 1.0
 * @since JDK-1.7.0
 * @date 2016-5-16
 */
public interface ConverterExecutor {

	boolean isLinuxos();

	void execute(String inputFilePath, String outputFilePath) throws ConverterException;

	void execute(File inputFile, File outputFile) throws ConverterException;
}
