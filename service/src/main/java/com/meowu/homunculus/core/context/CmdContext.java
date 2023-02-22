package com.meowu.homunculus.core.context;

import com.google.common.collect.Maps;
import com.meowu.homunculus.commons.security.stereotype.annotation.Context;
import com.meowu.homunculus.core.command.strategy.Cmd;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Context
public class CmdContext{

    @Autowired
    private final Map<String, Cmd> COMMAND_MAP = Maps.newConcurrentMap();

    public Cmd get(String name){
        return COMMAND_MAP.get(name);
    }

    public void put(String name, Cmd cmd){
        COMMAND_MAP.put(name, cmd);
    }

    public void remove(String name){
        COMMAND_MAP.remove(name);
    }
}
