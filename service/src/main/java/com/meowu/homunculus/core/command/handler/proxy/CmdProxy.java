package com.meowu.homunculus.core.command.handler.proxy;

import com.meowu.commons.utils.AssertUtils;
import com.meowu.homunculus.core.command.handler.Cmd;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Constructor;

public class CmdProxy{

    private String name;
    private String params;

    public CmdProxy(String cmd){
        init(cmd);
    }

    public Object execute() throws ClassNotFoundException{
        Cmd cmd = getCmd();
        return cmd.execute();
    }

    private void init(String cmd){
        AssertUtils.hasText(cmd, "cmd must not be null");

        String[] arrays = cmd.split(" ", 2);

        name   = arrays[0];
        params = arrays[1];
    }

    private Cmd getCmd() throws ClassNotFoundException{
        AssertUtils.hasText(name, "cmd class name must not be null");

        if("date".equals(name)){
            String className = "com.meowu.homunculus.core.command.handler.DateCmd";

            Class clazz = ClassUtils.getClass(className);
            new Constructor<Cmd>().newInstance(params);
        }
    }
}
