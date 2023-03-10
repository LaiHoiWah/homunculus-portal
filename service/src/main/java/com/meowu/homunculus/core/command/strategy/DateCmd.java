package com.meowu.homunculus.core.command.strategy;

import com.meowu.commons.security.exception.IllegalArgumentException;
import com.meowu.homunculus.commons.security.stereotype.annotation.Strategy;
import com.meowu.homunculus.commons.utils.CmdUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TimeZone;

@Strategy("DateCmd")
public class DateCmd implements Cmd{

    private final String DEFAULT_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private final String DEFAULT_TIMEZONE     = TimeZone.getDefault().getID();

    private final String PARAM_PATTERN  = "p";
    private final String PARAM_TIMEZONE = "z";

    @Override
    public Object execute(String options){
        // parse the options string
        Map<String, String> optionMap = getOptions(options);
        // init options
        String pattern  = optionMap.getOrDefault(PARAM_PATTERN, DEFAULT_TIME_PATTERN);
        String timeZone = optionMap.getOrDefault(PARAM_TIMEZONE, DEFAULT_TIMEZONE);

        return LocalDateTime.now(TimeZone.getTimeZone(timeZone).toZoneId())
                            .format(DateTimeFormatter.ofPattern(pattern));
    }

    @Override
    public Map<String, String> getOptions(String options){
        // parameter map
        Map<String, String> optionMap = CmdUtils.getOptions(options);

        if(optionMap.size() > 2){
            throw new IllegalArgumentException("Illegal arguments and call 'help' to view the instructions.");
        }

        optionMap.keySet()
                 .forEach(key -> {
                    if(!PARAM_PATTERN.equals(key) && !PARAM_TIMEZONE.equals(key)){
                        throw new IllegalArgumentException("Illegal arguments and call 'help' to view the instructions.");
                    }
                 });

        return optionMap;
    }
}
