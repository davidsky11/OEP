package com.kvlt.utils.tree;

import java.util.Map;

/**
 * ITreeNode
 *
 * @author KVLT
 * @date 2017-04-17.
 */
public interface ITreeNode {
    /**
     * 获取父节点编号
     *
     * @return
     */
    String parentIdGet();

    /**
     * 获取自身节点编号
     *
     * @return
     */
    String idGet();

    /**
     * 获取一个Tree对象的属性Map
     *
     * @return
     */
    Map attributeForTreeGet();
}
