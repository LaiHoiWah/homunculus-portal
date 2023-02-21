package com.meowu.homunculus.core.command.entity.constants;

import com.google.gson.annotations.SerializedName;
import com.meowu.commons.security.exception.IllegalArgumentException;
import com.meowu.commons.utils.AssertUtils;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CommandState{

    @SerializedName("0")
    ENABLE(0),

    @SerializedName("1")
    DISABLE(1),

    ;

    private int id;

    public static CommandState getById(Integer id){
        AssertUtils.notNull(id, "command state id must not be null");

        for(CommandState state : CommandState.values()){
            if(state.getId() == id){
                return state;
            }
        }

        throw new IllegalArgumentException("invalid state id: [{0}]", id);
    }
}
