package com.autotest.astarte.api.bean;

import com.autotest.astarte.api.bean.common.PageEntity;
import com.baomidou.mybatisplus.annotation.TableField;
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

}
