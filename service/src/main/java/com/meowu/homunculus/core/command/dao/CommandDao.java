package com.meowu.homunculus.core.command.dao;

import com.meowu.commons.utils.AssertUtils;
import com.meowu.commons.utils.SnowflakeUtils;
import com.meowu.homunculus.core.command.dao.mapper.CommandMapper;
import com.meowu.homunculus.core.command.entity.Command;
import com.meowu.plugins.mybatis.criteria.Criteria;
import com.meowu.plugins.mybatis.criteria.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommandDao{

    @Autowired
    private SnowflakeUtils snowflakeUtils;

    @Autowired
    private CommandMapper mapper;

    public Command getByName(String name){
        AssertUtils.hasText(name, "command: name must not be null");

        Criteria criteria = new Criteria();
        criteria.add(Restrictions.eq(Command::getName, name));

        return mapper.get(criteria);
    }
}
