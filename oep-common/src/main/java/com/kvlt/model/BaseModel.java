package com.kvlt.model;

import java.io.Serializable;
import java.util.Date;

/**
 * BaseModel
 *
 * @author KVLT
 * @date 2017-09-08.
 */
public abstract class BaseModel implements Serializable {

    protected String id;
    protected Integer key;
    protected String version;
    protected Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseModel baseModel = (BaseModel) o;

        if (!id.equals(baseModel.id)) return false;
        if (!key.equals(baseModel.key)) return false;
        return version.equals(baseModel.version);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + key.hashCode();
        result = 31 * result + version.hashCode();
        return result;
    }
}
