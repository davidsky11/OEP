package com.kvlt.facade.dto;

import com.kvlt.facade.enums.EncoderFormatEnum;
import com.kvlt.facade.enums.EncoderTypeEnum;
import com.kvlt.utils.CloneUtil;

import java.io.Serializable;

/**
 * EncoderObject
 *
 * @author KVLT
 * @date 2017-09-17.
 */
public class EncoderObject implements Serializable,Cloneable {

    private String fileId;
    private String fileName;
    private EncoderFormatEnum encoderFormat;
    private EncoderTypeEnum encoderType;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public EncoderFormatEnum getEncoderFormat() {
        return encoderFormat;
    }

    public void setEncoderFormat(EncoderFormatEnum encoderFormat) {
        this.encoderFormat = encoderFormat;
    }

    public EncoderTypeEnum getEncoderType() {
        return encoderType;
    }

    public void setEncoderType(EncoderTypeEnum encoderType) {
        this.encoderType = encoderType;
    }

    @Override
    public EncoderObject clone() {
        return (EncoderObject) CloneUtil.clone(this);
    }
}
