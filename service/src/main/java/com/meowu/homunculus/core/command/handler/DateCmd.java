package com.meowu.homunculus.core.command.handler;

import com.meowu.homunculus.commons.utils.ParameterUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TimeZone;

public class DateCmd extends Cmd{

    private String timeZone;
    private String pattern;

    public DateCmd(String params){
        init(params);
    }

    @Override
    public Object execute(){
        return LocalDateTime.now(TimeZone.getTimeZone(timeZone).toZoneId())
                            .format(DateTimeFormatter.ofPattern(pattern));
    }

    @Override
    protected void init(String params){
        // format the params string
        Map<String, String> parser = ParameterUtils.parse(params);
        // init params
        pattern  = parser.getOrDefault("-p", "yyyy-MM-dd HH:mm:ss");
        timeZone = parser.getOrDefault("-z", TimeZone.getDefault().getID());
    }
}
