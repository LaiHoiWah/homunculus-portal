package com.meowu.homunculus.commons.security.exception;

import com.meowu.commons.security.exception.MeowuException;

import java.text.MessageFormat;

public class CommandStateException extends MeowuException{

    public CommandStateException(){
        super();
    }

    public CommandStateException(String message){
        super(message);
    }

    public CommandStateException(Throwable cause){
        super(cause);
    }

    public CommandStateException(String message, Throwable cause){
        super(message, cause);
    }

    public CommandStateException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public CommandStateException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
