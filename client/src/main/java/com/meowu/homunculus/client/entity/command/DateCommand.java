package com.meowu.homunculus.client.entity.command;

import com.meowu.homunculus.client.entity.Command;

import java.time.LocalDateTime;

public class DateCommand implements Command{

    private String timeZone;
    private String pattern;

    @Override
    public Object execute(Object[] args){
        return LocalDateTime.now().toString();
    }
}
