package com.meowu.homunculus.core.command.dao;

import com.meowu.commons.utils.AssertUtils;
import com.meowu.commons.utils.SnowflakeUtils;
import com.meowu.homunculus.core.command.dao.mapper.CommandMapper;
import com.meowu.homunculus.core.command.entity.Command;
import com.meowu.homunculus.core.command.entity.constants.CommandState;
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

    public Command getByCmd(String cmd){
        AssertUtils.hasText(cmd, "command: cmd must not be null");

        Criteria criteria = new Criteria();
        criteria.add(Restrictions.eq(Command::getCmd, cmd));

        return mapper.get(criteria);
    }

    public void updateStateByCmd(String cmd, CommandState state){
        AssertUtils.hasText(cmd, "command: cmd must not be null");
        AssertUtils.notNull(state, "command: state must not be null");

        Command command = new Command();
        command.setCmd(cmd);
        command.setState(state);

        mapper.update(command);
    }
}
