package com.meowu.homunculus.core.command.dao.mapper;

import com.meowu.homunculus.core.command.entity.Command;
import com.meowu.plugins.mybatis.criteria.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommandMapper{

    void save(Command command);

    void update(Command command);

    Command get(@Param("Params") Criteria criteria);

    List<Command> find(@Param("params") Criteria criteria);

    Long count(@Param("params") Criteria criteria);
}
