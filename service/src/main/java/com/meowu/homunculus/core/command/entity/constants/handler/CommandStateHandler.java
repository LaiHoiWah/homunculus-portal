package com.meowu.homunculus.core.command.entity.constants.handler;

import com.meowu.homunculus.core.command.entity.constants.CommandState;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommandStateHandler extends BaseTypeHandler<CommandState>{

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int column, CommandState state, JdbcType jdbcType) throws SQLException{
        preparedStatement.setInt(column, state.getId());
    }

    @Override
    public CommandState getNullableResult(ResultSet resultSet, String column) throws SQLException{
        if(StringUtils.isBlank(column)){
            return null;
        }

        return CommandState.getById(resultSet.getInt(column));
    }

    @Override
    public CommandState getNullableResult(ResultSet resultSet, int column) throws SQLException{
        return CommandState.getById(resultSet.getInt(column));
    }

    @Override
    public CommandState getNullableResult(CallableStatement callableStatement, int column) throws SQLException{
        return CommandState.getById(callableStatement.getInt(column));
    }
}
