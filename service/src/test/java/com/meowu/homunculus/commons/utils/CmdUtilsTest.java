package com.meowu.homunculus.commons.utils;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CmdUtilsTest{

    @Test
    public void getOptions(){
        String regex  = "-((?<option>[a-z])\\s*(?<value>\'.*\'|[^-]*)+?)+?";
        String params = " -z shanghai-p  'yyyy-MM-dd'  -o iii  ";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(params);

        int index = 0;
        while(matcher.find(index)){
            System.out.println(matcher.group("option"));
            System.out.println(matcher.group("value"));
            index = matcher.end();
        }
    }

    @Test
    public void parse(){
        String regex = "\\s*(?<cmd>[a-zA-Z0-9]+)\\s*(?<option>-[a-z]+\\s*(\'.*\'|[^-]*)*?)*";
        String cmd   = "help -d iiii -o dddd kkkk";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cmd);

        if(matcher.matches()){
            System.out.println(true);

            System.out.println(matcher.group("cmd"));
            System.out.println(matcher.group("option"));
        }
    }
}
