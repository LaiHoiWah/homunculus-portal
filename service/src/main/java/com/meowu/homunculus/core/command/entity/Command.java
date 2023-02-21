package com.meowu.homunculus.core.command.entity;

import com.meowu.commons.doamin.Creatable;
import com.meowu.commons.doamin.Entity;
import com.meowu.commons.doamin.Updatable;
import com.meowu.homunculus.core.command.entity.constants.CommandState;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Command extends Entity<Long> implements Creatable, Updatable{

    private String       name;
    private String       className;
    private CommandState status;
    private Date         createTime;
    private Date         updateTime;
}
