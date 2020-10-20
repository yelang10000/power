package com.sun.power.modules.system.role.dto;

import lombok.Data;

@Data
public class Operation {
    private String rulerId;
    private int  operationAdd;
    private int  operationUpdate;
    private int  operationDelete;

}
