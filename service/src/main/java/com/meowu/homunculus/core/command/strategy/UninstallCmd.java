package com.meowu.homunculus.core.command.strategy;

import com.meowu.commons.security.exception.IllegalArgumentException;
import com.meowu.homunculus.commons.security.stereotype.annotation.Strategy;
import com.meowu.homunculus.commons.utils.CmdUtils;
import com.meowu.homunculus.core.command.dao.CommandDao;
import com.meowu.homunculus.core.command.entity.constants.CommandState;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Strategy("UninstallCmd")
public class UninstallCmd implements Cmd{

    @Autowired
    private CommandDao commandDao;

    private final String PARAM_CMD = "c";

    @Override
    public Object execute(String options){
        // parse the options string
        Map<String, String> optionMap = getOptions(options);
        // init options
        String cmd = optionMap.get(PARAM_CMD);
        // update state
        commandDao.updateStateByCmd(cmd, CommandState.DISABLE);

        return "UNINSTALL SUCCESS";
    }

    @Override
    public Map<String, String> getOptions(String options){
        // options map
        Map<String, String> optionMap = CmdUtils.getOptions(options);

        if(optionMap.size() != 1){
            throw new IllegalArgumentException("Illegal arguments and call 'help' to view the instructions.");
        }

        optionMap.keySet()
                 .forEach(key -> {
                    if(!PARAM_CMD.equals(key)){
                        throw new IllegalArgumentException("Illegal arguments and call 'help' to view the instructions.");
                    }
                 });

        return optionMap;
    }
}
