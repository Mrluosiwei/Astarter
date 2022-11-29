package com.autotest.astarte.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@TableName("atp_interface")
public class Interface implements Serializable {
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    @TableField(value = "SYSTEM_ID")
    private Long systemId;
    @TableField(value = "DESCRIPTION")
    private String description;
    @TableField(value = "INTERFACE_NAME")
    private String interfaceName;
    @TableField(value = "INTERFACE_PATH")
    private String interfacePath;
    // http,tcp
    @TableField(value = "INTERFACE_TYPE")
    private String interfaceType;
    @TableField(value = "CREATE_USER")
    private String createUser;
    @TableField(value = "UPDATE_USER")
    private String updateUser;
    @TableField(value = "UPDATE_TIME")
    private Timestamp updateTime;

}
