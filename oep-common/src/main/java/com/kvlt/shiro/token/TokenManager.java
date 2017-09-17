package com.kvlt.shiro.token;

import org.apache.shiro.session.Session;

/**
 * TokenManager
 *
 * @author KVLT
 * @date 2017-03-28.
 */
public interface TokenManager {

    Session getSession();

    Object getVal2Session(Object key);

    void setVal2Session(Object key, Object value);

    Long getUserId();

}
