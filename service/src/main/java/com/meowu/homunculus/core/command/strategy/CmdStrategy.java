package com.meowu.homunculus.core.command.strategy;

import com.meowu.homunculus.commons.security.stereotype.annotation.Strategy;
import com.meowu.homunculus.core.context.CmdContext;
import org.springframework.beans.factory.annotation.Autowired;

@Strategy
public class CmdStrategy{

    @Autowired
    private CmdContext context;

    public Object execute(String cmd, String params){
        Cmd command = context.get(cmd);
        return command.execute(params);
    }
}
