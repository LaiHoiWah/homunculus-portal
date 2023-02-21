package com.meowu.homunculus.commons.utils;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParameterUtils{

    private static String REGEX = "(-[a-zA-Z]\\s*(\'.*\'|[^-]+)?)";

    public static Map<String, String> parse(String params){
        // when string is blank return empty map
        if(StringUtils.isBlank(params)){
            return Maps.newHashMap();
        }

        // result
        Map<String, String> result = Maps.newHashMap();

        // parse
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(params);

        // foreach match
        int index = 0;
        while(matcher.find(index)){
            String param = matcher.group(1);

            if(StringUtils.isNotBlank(param)){
                String[] entity = param.split(" ", 2);
                String   key    = entity[0];
                String   value  = entity[1];

                if(StringUtils.isNotBlank(value)){
                    if(value.startsWith("'") && value.endsWith("'")){
                        value = value.replaceAll("'", "");
                    }

                    value = value.trim();
                }

                result.put(key, value);
            }

            index = matcher.end();
        }

        return result;
    }
}
