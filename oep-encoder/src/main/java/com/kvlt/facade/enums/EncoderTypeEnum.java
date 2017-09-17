package com.kvlt.facade.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EncoderTypeEnum
 *
 * @author KVLT
 * @date 2017-09-17.
 */
public enum EncoderTypeEnum {

    /**
     * 图片
     */
    IMAGE("图片", 1),
    /**
     * 音频
     */
    AUDIO("音频", 2),
    /**
     * 视频
     */
    VIDEO("视频", 3);

    /** 名称，状态描述  */
    private String name;
    /** 枚举值 */
    private int value;

    /** 构造函数 */
    private EncoderTypeEnum(String name, int value) {
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

    public static EncoderTypeEnum getEnum(int value) {
        EncoderTypeEnum resultEnum = null;
        EncoderTypeEnum[] enumAry = EncoderTypeEnum.values();
        for (int i = 0; i < enumAry.length; i++) {
            if (enumAry[i].getValue() == value) {
                resultEnum = enumAry[i];
                break;
            }
        }
        return resultEnum;
    }

    public static List toList() {
        EncoderTypeEnum[] ary = EncoderTypeEnum.values();
        List list = new ArrayList();
        for (int i = 0; i < ary.length; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("value", String.valueOf(ary[i].getValue()));
            map.put("name", ary[i].getName());
            list.add(map);
        }
        return list;
    }
}
