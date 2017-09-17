package com.kvlt.facade.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EncoderFormatEnum
 *
 * @author KVLT
 * @date 2017-09-17.
 */
public enum EncoderFormatEnum {

    /**
     * PNG格式图片
     */
    IMAGE_FORMAT_PNG("PNG", 1),
    /**
     * JPG格式图片
     */
    IMAGE_FORMATE_JPG("JPG", 2),
    /**
     * FLV格式视频
     */
    VIDEO_FORMAT_FLV("FLV", 3),
    /**
     * MP4格式视频
     */
    VIDEO_FORMAT_MP4("MP4", 4);

    /** 名称，状态描述  */
    private String name;
    /** 枚举值 */
    private int value;

    /** 构造函数 */
    private EncoderFormatEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static EncoderFormatEnum getEnum(int value) {
        EncoderFormatEnum resultEnum = null;
        EncoderFormatEnum[] enumAry = EncoderFormatEnum.values();
        for (int i = 0; i < enumAry.length; i++) {
            if (enumAry[i].getValue() == value) {
                resultEnum = enumAry[i];
                break;
            }
        }
        return resultEnum;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List toList() {
        EncoderFormatEnum[] ary = EncoderFormatEnum.values();
        List list = new ArrayList();
        for (int i = 0; i < ary.length; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("value", String.valueOf(ary[i].getValue()));
            map.put("desc", ary[i].getName());
            list.add(map);
        }
        return list;
    }
}
