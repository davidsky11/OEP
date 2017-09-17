package com.kvlt.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * BooleanTypeHandler
 * java中的boolean和jdbc中的char之间转换;true-Y;false-N
 * @author KVLT
 * @date 2017-09-11.
 */
public class BooleanTypeHandler implements TypeHandler {

    public Object getResult(ResultSet rs, int i) throws SQLException {
        String str = rs.getString(i);
        Boolean rt = Boolean.FALSE;
        if (str.equalsIgnoreCase("Y")){
            rt = Boolean.TRUE;
        }
        return rt;
    }

    public Object getResult(ResultSet rs, String s) throws SQLException {
        String str = rs.getString(s);
        Boolean rt = Boolean.FALSE;
        if (str.equalsIgnoreCase("Y")){
            rt = Boolean.TRUE;
        }
        return rt;
    }

    public Object getResult(CallableStatement rs, int i) throws SQLException {
        Boolean b = rs.getBoolean(i);
        return b == true ? "Y" : "N";
    }

    public void setParameter(PreparedStatement rs, int i, Object obj, JdbcType arg3) throws SQLException {
        Boolean b = (Boolean) obj;
        String value = (Boolean) b == true ? "Y" : "N";
        rs.setString(i, value);
    }

}
