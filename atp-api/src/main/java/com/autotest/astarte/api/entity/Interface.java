package com.autotest.astarte.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Accessors(chain = true)
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
    @TableField(value = "REQUEST")
    private String request;
    @TableField(value = "RESPONSE")
    private String response;
    @TableField(value = "FORMAT")
    private String format;
    @TableField(value = "ENCODING")
    private String encoding;
    @TableField(value = "READ_TIME")
    private Long readTime;
    @TableField(value = "TEMPLATE_ID")
    private Long templateId;
    @TableField(value = "IS_DELETE")
    private Long isDelete;
    @TableField(value = "VERSION")
    private String version;


}
