package com.meowu.homunculus.core.command.strategy;

import com.meowu.homunculus.commons.security.stereotype.annotation.Strategy;
import com.meowu.homunculus.commons.utils.ParameterUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TimeZone;

@Strategy("dateCmd")
public class DateCmd implements Cmd{

    @Override
    public Object execute(String params){
        // parse the params string
        Map<String, String> parser = ParameterUtils.parse(params);
        // init params
        String pattern  = parser.getOrDefault("-p", "yyyy-MM-dd HH:mm:ss");
        String timeZone = parser.getOrDefault("-z", TimeZone.getDefault().getID());

        return LocalDateTime.now(TimeZone.getTimeZone(timeZone).toZoneId())
                            .format(DateTimeFormatter.ofPattern(pattern));
    }
}
