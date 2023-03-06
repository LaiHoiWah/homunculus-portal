package com.meowu.homunculus.commons.utils;

import com.google.common.collect.Maps;
import com.meowu.commons.security.exception.IllegalArgumentException;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CmdUtils{

    private final static String CMD_REGEX     = "\\s*(?<cmd>[a-zA-Z0-9]+?)+\\s*(?<option>-[a-z]\\s*(\'.*\'|[^-]*)+?)+?";
    private final static String OPTIONS_REGEX = "-((?<option>[a-z]+)\\s*(?<value>\'.*\'|[^-]*)+?)+?";

    public static Map<String, String> parse(String cmd){
        if(StringUtils.isBlank(cmd)){
            throw new IllegalArgumentException("Command is null.");
        }

        return null;
    }

    public static Map<String, String> getOptions(String optionStr){
        if(StringUtils.isBlank(optionStr)){
            return Maps.newHashMap();
        }

        // option map
        Map<String, String> optionMap = Maps.newHashMap();

        // parse
        Pattern pattern = Pattern.compile(OPTIONS_REGEX);
        Matcher matcher = pattern.matcher(optionStr);

        int index = 0;
        while(matcher.find(index)){
            String option = matcher.group("option");
            String value  = matcher.group("value");

            if(StringUtils.isNotBlank(value)){
                value = value.replaceAll("\'", "");
            }

            optionMap.put(option, value);
            index = matcher.end();
        }

        return optionMap;
    }
}
