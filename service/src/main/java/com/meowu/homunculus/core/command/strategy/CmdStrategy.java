package com.meowu.homunculus.core.command.strategy;

import com.meowu.homunculus.commons.security.exception.CommandNotFoundException;
import com.meowu.homunculus.commons.security.exception.CommandStateException;
import com.meowu.homunculus.commons.security.stereotype.annotation.Strategy;
import com.meowu.homunculus.core.command.dao.CommandDao;
import com.meowu.homunculus.core.command.entity.Command;
import com.meowu.homunculus.core.command.entity.constants.CommandState;
import com.meowu.homunculus.core.holder.CmdHolder;
import org.springframework.beans.factory.annotation.Autowired;

@Strategy
public class CmdStrategy{

    @Autowired
    private CmdHolder cmdHolder;

    @Autowired
    private CommandDao commandDao;

    public Object execute(String cmd, String params){
        // check command state
        Command command = commandDao.getByName(cmd);

        if(command == null){
            throw new CommandNotFoundException("Command[{0}] is not installed.", cmd);
        }
        if(CommandState.DISABLE.equals(command.getState())){
            throw new CommandStateException("Command[{0}] is not installed.", cmd);
        }

        return null;
    }
}
