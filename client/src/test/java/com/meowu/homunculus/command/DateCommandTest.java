package com.meowu.homunculus.command;

import com.meowu.homunculus.client.entity.command.DateCommand;
import org.junit.Test;

public class DateCommandTest{

    @Test
    public void execute(){
        DateCommand command = new DateCommand();
        System.out.println(command.execute(null));
    }
}
