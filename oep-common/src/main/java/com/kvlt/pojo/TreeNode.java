package com.kvlt.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * TreeNode
 * 树形结构实体
 * @author KVLT
 * @date 2017-03-14.
 */
public class TreeNode implements Serializable {

    private String text;

    private List<String> tags;

    private String id;

    private String parentId;

    private String levelCode;

    private List<TreeNode> nodes;

    private String icon;

    public String getParentId() {

        return parentId;
    }

    public String getIcon() {

        return icon;
    }

    public void setIcon(String icon) {

        this.icon = icon;
    }

    public String getLevelCode() {

        return levelCode;
    }

    public void setLevelCode(String levelCode) {

        this.levelCode = levelCode;
    }

    public void setParentId(String parentId) {

        this.parentId = parentId;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {

        this.text = text;
    }

    public List<String> getTags() {

        return tags;
    }

    public void setTags(List<String> tags) {

        this.tags = tags;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public List<TreeNode> getNodes() {

        return nodes;
    }

    public void setNodes(List<TreeNode> nodes) {

        this.nodes = nodes;
    }

}
