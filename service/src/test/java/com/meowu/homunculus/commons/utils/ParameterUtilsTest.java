package com.meowu.homunculus.commons.utils;

import org.junit.Test;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParameterUtilsTest{

    @Test
    public void match(){
        String REGEX = "(-[a-zA-Z] ((\'.*\')|[^-]+))";
        String params = "-z Shanghai -p 'yyyy-MM-dd'";

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(params);

        int matcherStart = 0;
        while(matcher.find(matcherStart)){
            System.out.println(matcher.group(1));
            matcherStart = matcher.end();
        }
    }
}
