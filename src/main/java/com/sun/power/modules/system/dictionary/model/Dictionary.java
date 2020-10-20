package com.sun.power.modules.system.dictionary.model;

import lombok.Data;

import java.util.Date;

@Data
public class Dictionary {
    private Long id;


    private String remarks;

    private String code;

    private String name;

    private String chineseName;

    private Long orderCode;

    private String createUserId;

    private Date gmtCreate;

    private String updateUserId;

    private Date gmtModified;

    private Byte isDeleted;

    private String createOrgId;

    private String createOrgParentId;


}