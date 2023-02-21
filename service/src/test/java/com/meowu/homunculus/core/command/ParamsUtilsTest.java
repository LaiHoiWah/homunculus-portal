package com.meowu.homunculus.core.command;

import com.meowu.homunculus.commons.utils.ParameterUtils;
import org.junit.Test;

import java.util.Map;

public class ParamsUtilsTest{

    @Test
    public void parse(){
        String params = "    -p 'yyyy-MM-dd HH:mm:ss'-z           Shanghai -i ";

        Map<String, String> parse = ParameterUtils.parse(params);
        parse.forEach((k, v) -> System.out.println("k: " + k + " & v: " + v));
    }
}
