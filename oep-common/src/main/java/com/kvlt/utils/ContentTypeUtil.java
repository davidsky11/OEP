package com.kvlt.utils;

/**
 * ContentTypeUtil
 *
 * @author KVLT
 * @date 2017-09-08.
 */
public class ContentTypeUtil {

    private static String[] supportedDocType = {"doc","xls","ppt","odt","txt","md","xlsx","xlsm","pptx"};
    private static String[] supportedAudioType = {"cda","wav","mp3","wma","asf","ra","rma","mid","midi",
            "rmi","xmi","ogg","vqf","tvq","mod","ape","aiff","au"};
    private static String[] supportedVideoType = {"avi","3gp","mp4","wmv","flv","f4v","mov","mpeg","mpg",
            "mp3","m4v","rmvb","rm","mkv","ogg","ogm","dat","ts","mts","vob","flash","asf"};

    public static boolean isSupportedDocExt(String name) {
        for (String str : supportedDocType) {
            if (str.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSupportedVedioExt(String name) {
        for (String str : supportedVideoType) {
            if (str.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSupportedAudioExt(String name) {
        for (String str : supportedAudioType) {
            if (str.equals(name)) {
                return true;
            }
        }
        return false;
    }
}
