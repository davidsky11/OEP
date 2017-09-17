package com.kvlt.manager.impl;

import com.kvlt.dao.BaseDao;

/**
 * BaseManagerImpl
 *
 * @author KVLT
 * @date 2017-09-08.
 */
public class BaseManagerImpl<T> {

    protected BaseDao<T> getDao(){return null;};

    public void update(T t) {

    }

}
