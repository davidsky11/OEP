package com.kvlt.dao.impl;

import com.kvlt.dao.BaseDao;
import com.kvlt.utils.BeanMapUtils;
import com.kvlt.utils.GenericsUtils;
import com.kvlt.utils.lang.StringUtil;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BaseDaoImpl  基于MyBatis的基础泛型Dao实现类
 *  @param <T> 业务实体类型
 *  @param <PK> ID类型，如：String、Long、Integer等
 *
 * @author KVLT
 * @date 2017-09-08.
 */
@Repository("baseDao")
public class BaseDaoImpl<T> implements Serializable, BaseDao<T> {

    private static final Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);

    private static final long seriaVersionUID  = 7623507504198633838L;

    private static final String _SEPARATOR = ".";
    private static final String POSTFIX = "Dao";
    private static final String _INSERT = ".insert";
    private static final String _INSERTSELECTIVE = ".insertSelective";
    private static final String _SELECTBYPRIMARYKEY = ".selectByPrimaryKey";
    private static final String _UPDATEBYPRIMARYKEY = ".updateByPrimaryKey";
    private static final String _UPDATEBYPRIMARYKEYSELECTIVE = ".updateByPrimaryKeySelective";
    private static final String _DELETEBYPRIMARYKEY = ".deleteByPrimaryKey";
    private static final String _DELETEBYPRIMARYKEYS = ".deleteByPrimaryKeys";
    private static final String _FINDLISTBY = ".findListBy";
    private static final String _GETCOUNTBY = ".getCountBy";
    private static final String _SORT = "SORT";
    private static final String _DIR = "DIR";

    /** 不能用于SQL中的非法字符（主要用于排序字段名） */
    public static final String[] ILLEGAL_CHARS_FOR_SQL = {",", ";", " ", "\"", "%"};

    /**
     * SqlMapping命名空间
     */
    private String sqlNamespace = getDefaultNameSpace();

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    /**
     * 获取默认SqlMapping命名空间。
     * 使用泛型参数中业务实体类型的全限定名作为默认的命名空间。
     * 如果实际应用中需要特殊的命名空间，可由子类重写该方法实现自己的命名空间规则。
     * @return 返回命名空间字符串
     */
    protected String getDefaultNameSpace() {
        Class<T> clazz = (Class) GenericsUtils.getSuperClassGenricType(this.getClass());
        String namespace = clazz.getName();
        return namespace;
    }

    public String getNameSpace() {
        Class<T> clazz = (Class) GenericsUtils.getSuperClassGenricType(this.getClass());
        String simpleName = clazz.getSimpleName() + POSTFIX;

        return simpleName.contains("Entity") ? simpleName.replace("Entity", "")
                : simpleName;
    }


    protected String getSqlName(String sqlName) {
        return sqlNamespace + _SEPARATOR + sqlName;
    }

    /**
     * 生成主键值
     *  默认情况下什么也不做；如果需要生成主键，需要由子类重写此方法根据需要的方式生成主键值。
     * @param ob
     */
    protected void generateId(T ob) {

    }

    /**
     * 保存对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object insert(String str, Object obj) throws Exception {
        return sqlSessionTemplate.insert(str, obj);
    }

    /**
     * 批量保存
     * @param str
     * @param objs
     * @return
     * @throws Exception
     */
    public Object batchSave(String str, List objs) throws Exception {
        return sqlSessionTemplate.insert(str, objs);
    }

    /**
     * 修改对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object update(String str, Object obj) throws Exception {
        return sqlSessionTemplate.update(str, obj);
    }

    /**
     * 批量更新
     * @param str
     * @param objs
     * @return
     * @throws Exception
     */
    public void batchUpdate(String str, List objs )throws Exception {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        //批量执行器
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
        try{
            if(objs!=null){
                for(int i=0,size=objs.size();i<size;i++){
                    sqlSession.update(str, objs.get(i));
                }
                sqlSession.flushStatements();
                sqlSession.commit();
                sqlSession.clearCache();
            }
        }finally{
            sqlSession.close();
        }
    }

    /**
     * 批量删除
     * @param str
     * @param objs
     * @return
     * @throws Exception
     */
    public Object batchDelete(String str, List objs)throws Exception{
        return sqlSessionTemplate.delete(str, objs);
    }

    /**
     * 删除对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object delete(String str, Object obj) throws Exception {
        return sqlSessionTemplate.delete(str, obj);
    }

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object findForObject(String str, Object obj) throws Exception {
        return sqlSessionTemplate.selectOne(str, obj);
    }

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object findForList(String str, Object obj) throws Exception {
        return sqlSessionTemplate.selectList(str, obj);
    }

    /**
     * 查找对象封装成Map
     * @param str
     * @param obj
     * @param key
     * @return
     * @throws Exception
     */
    public Object findForMap(String str, Object obj, String key) throws Exception {
        return sqlSessionTemplate.selectMap(str, obj, key);
    }

    public Long findAllCount(String str, Object obj) {
        return sqlSessionTemplate.selectOne(str, obj);
    }

    /**
     * 批量新增
     * 同一事务范围内，分批commit insert batch
     * @param str
     * @param objs
     * @param <T>
     * @return
     */
    public <T> boolean insertBatch(String str, List<T> objs) {
        int result = 1;
        SqlSession batchSqlSession = null;

        try {
            batchSqlSession = this.sqlSessionTemplate.getSqlSessionFactory()
                    .openSession(ExecutorType.BATCH, false);  // 获取批量方式的sqlSession
            int batchCount = 100; // 每批commit的个数
            int batchLastIndex = batchCount; // 每批最后一个的下标
            for (int index = 0; index < objs.size();) {
                if (batchLastIndex >= objs.size()) {
                    batchLastIndex = objs.size();
                    result = result * batchSqlSession.insert(str, objs.subList(index, batchLastIndex));
                    batchSqlSession.commit();
                    logger.info(" --> index: " + index + " batchLastIndex: " + batchLastIndex);
                    break;
                } else {
                    result = result * batchSqlSession.insert(str, objs.subList(index, batchLastIndex));
                    batchSqlSession.commit();
                    logger.info(" --> index: " + index + " batchLastIndex: " + batchLastIndex);
                    index = batchLastIndex;  // 设置下一批的下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
            batchSqlSession.commit();
        } finally {
            if (null != batchSqlSession) {
                // 清理缓存，防止溢出
                batchSqlSession.clearCache();
                batchSqlSession.close();
            }
        }
        return result > 0;
    }

    public int insert(T entity) {
        generateId(entity);
        return this.getSqlSessionTemplate().insert(
                this.getNameSpace() + _INSERT, entity);
    }

    public int insertSelective(T entity) {
        return this.getSqlSessionTemplate().insert(
                this.getNameSpace() + _INSERTSELECTIVE, entity);
    }

    public int update(T entity) {
        return this.getSqlSessionTemplate().update(
                this.getNameSpace() + _UPDATEBYPRIMARYKEY, entity);
    }

    public T findByKey(String key) {
        return null;
    }

    public List<T> findListBy(T param) {
        return findListBy(param, null, null);
    }

    public List<T> listAll() {
        return findListBy(null, null, null);
    }

    public List<T> findListBy(T entity, String sort, String dir) {
        Map<String, Object> paramMap = null;
        try {
            if (entity != null) {
                paramMap = BeanMapUtils.toMap(entity);
            } else {
                paramMap = new HashMap<>();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Where过滤条件
        // 排序条件
        if (sort != null) {
            // 排序字段不为空，过滤其中可能存在的非法字符
            sort = filterIllegalChars(sort, ILLEGAL_CHARS_FOR_SQL);
        }

        if (StringUtil.isNullOrBlank(sort) || StringUtil.isNull(dir)) {

        } else {
            paramMap.put(_SORT, sort);
            paramMap.put(_DIR, dir);
        }

        List<T> list = this.getSqlSessionTemplate().selectList(
                getSqlName(_FINDLISTBY), paramMap);
        return list;
    }

    /**
     * 从给定字符串中将指定的非法字符串数组中各字符串过滤掉。
     * @param str 待过滤的字符串
     * @param filterChars 指定的非法字符串数组
     * @return 过滤后的字符串
     */
    protected String filterIllegalChars(String str, String[] filterChars) {
        String rs = str;
        if (rs != null && filterChars != null) {
            for (String fc : filterChars) {
                if (fc != null && fc.length() > 0) {
                    str = str.replaceAll(fc, "");
                }
            }
        }
        return rs;
    }
}
