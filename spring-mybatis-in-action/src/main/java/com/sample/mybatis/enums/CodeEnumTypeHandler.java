package com.sample.mybatis.enums;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EnumSet;

/**
 * @author sskim
 */
public abstract class CodeEnumTypeHandler<E extends Enum<E> & CodeEnum> implements TypeHandler<CodeEnum> {

    private Class<E> type;

    public CodeEnumTypeHandler(Class<E> type) {
        this.type = type;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, CodeEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public CodeEnum getResult(ResultSet rs, String columnName) throws SQLException {
        return getCodeEnum(rs.getString(columnName));
    }

    @Override
    public CodeEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        return getCodeEnum(rs.getString(columnIndex));
    }

    @Override
    public CodeEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getCodeEnum(cs.getString(columnIndex));
    }

    private CodeEnum getCodeEnum(String code) {
        return EnumSet.allOf(type)
                .stream()
                .filter(value -> value.getCode().equals(code))
                .findFirst()
                .orElseGet(null);
    }
}
