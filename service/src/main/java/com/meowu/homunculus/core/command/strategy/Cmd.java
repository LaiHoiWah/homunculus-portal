package com.meowu.homunculus.core.command.strategy;

import java.util.Map;

public interface Cmd{

    Object execute(String options);

    Map<String, String> getOptions(String options);
}
