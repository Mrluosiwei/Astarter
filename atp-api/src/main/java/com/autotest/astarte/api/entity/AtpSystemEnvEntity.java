package com.autotest.astarte.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@Accessors(chain = true)
@TableName("atp_system_env")
public class AtpSystemEnvEntity {
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    @TableField(value = "ENV_NAME")
    private String envName;
    @TableField(value = "SYSTEM_ID")
    private Long systemId;
    @TableField(value = "ENV_SHORT")
    private String envShort;
    @TableField(value = "CREATE_USER")
    private String createUser;
    @TableField(value = "UPDATE_USER")
    private String updateUser;
    @TableField(value = "CREATE_TIME")
    private Timestamp createTime;
    @TableField(value = "UPDATE_TIME")
    private Timestamp updateTime;
    @TableField(value = "ENV_IP")
    private String envIp;
    @TableField(value = "ENV_PORT")
    private int envPort;
    @TableField(value = "IS_DELETE")
    private int isDelete;
    @TableField(value = "STATUS")
    private int status;
    @TableField(value = "ENV_CURRENT")
    private int envCurrent;
    @TableField(value = "JPA_VERSION")
    private int jpaVersion;
}
