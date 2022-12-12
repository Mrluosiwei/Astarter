package com.autotest.astarte.api.bean;

import com.autotest.astarte.api.bean.common.PageEntity;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class InterfaceBean extends PageEntity {
    private Long id;

    private Long systemId;

    private String description;

    private String interfaceName;

    private String interfacePath;

    private String interfaceType;

    private String createUser;

    private String updateUser;

    private Timestamp updateTime;
    private String request;
    private String response;
    private String format;
    private String encoding;
    private Long readTime;
    private Long templateId;
    private Long isDelete;
    private String version;

}
