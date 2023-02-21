package com.meowu.homunculus.core.command;

import com.meowu.homunculus.core.command.handler.DateCmd;
import org.junit.Test;

public class DateCommandTest{

    @Test
    public void execute(){
        String params = "-p 'yyyy/MM/dd'";
        DateCmd command = new DateCmd(params);

        System.out.println(command.execute());
    }
}
