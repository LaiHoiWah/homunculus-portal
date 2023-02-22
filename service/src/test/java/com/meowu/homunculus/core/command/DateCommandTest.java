package com.meowu.homunculus.core.command;

import com.meowu.homunculus.core.command.strategy.DateCmd;
import org.junit.Test;

public class DateCommandTest{

    @Test
    public void execute(){
        String params = "-p 'yyyy/MM/dd'";
        DateCmd command = new DateCmd();

        System.out.println(command.execute(params));
    }
}
