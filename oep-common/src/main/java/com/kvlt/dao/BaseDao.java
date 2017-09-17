package com.kvlt.dao;

import java.io.Serializable;
import java.util.List;

/**
 * BaseDao
 *
 * @author KVLT
 * @date 2017-09-08.
 */
public interface BaseDao<T> {

    /**
     * 获取namespace
     * @return
     */
    String getNameSpace();

    /**
     * 保存对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object insert(String str, Object obj) throws Exception;

    /**
     * 修改对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object update(String str, Object obj) throws Exception;

    /**
     * 删除对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object delete(String str, Object obj) throws Exception;

    /**
     * 批量保存
     * @param str
     * @param objs
     * @return
     * @throws Exception
     */
    Object batchSave(String str, List objs) throws Exception;

    /**
     * 批量更新
     * @param str
     * @param objs
     * @return
     * @throws Exception
     */
    void batchUpdate(String str, List objs)throws Exception;

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object findForObject(String str, Object obj) throws Exception;

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    Object findForList(String str, Object obj) throws Exception;


    /**
     * 查找对象封装成Map
     * @param sql
     * @param obj
     * @return
     * @throws Exception
     */
    Object findForMap(String sql, Object obj, String key) throws Exception;

    /**
     * 获取记录总数
     * @return
     */
    Long findAllCount(String str, Object obj);

    /**
     * 批量新增
     */
    <T> boolean insertBatch(String str, List<T> objs);

    int insert(T entity);
    int insertSelective(T entity);
    int update(T entity);

    T findByKey(String key);

    List<T> findListBy(T entity, String sort, String dir);
    List<T> listAll();
}
