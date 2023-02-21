package com.meowu.homunculus.core.command.handler;

public abstract class Cmd {

    public abstract Object execute();

    protected abstract void init(String params);
}
