package com.meowu.homunculus.commons.security.exception;

import com.meowu.commons.security.exception.MeowuException;

import java.text.MessageFormat;

public class CommandNotFoundException extends MeowuException{

    public CommandNotFoundException(){
        super();
    }

    public CommandNotFoundException(String message){
        super(message);
    }

    public CommandNotFoundException(Throwable cause){
        super(cause);
    }

    public CommandNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public CommandNotFoundException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public CommandNotFoundException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
