package com.autotest.astarte.api.bean;

import com.autotest.astarte.api.bean.common.PageEntity;
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
public class AtpSystemEnvBean extends PageEntity {
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    @TableField(value = "ENV_NAME")
    private String envName;
    @TableField(value = "ENV_SHORT")
    private String envShort;
    @TableField(value = "ENV_IP")
    private String envIp;
    @TableField(value = "DESCRIPTION")
    private String description;
    @TableField(value = "SYSTEM_ID")
    private Long systemId;
    @TableField(value = "CREATE_USER")
    private String createUser;
    @TableField(value = "UPDATE_USER")
    private String updateUser;
    @TableField(value = "CREATE_TIME")
    private Timestamp createTime;
    @TableField(value = "UPDATE_TIME")
    private Timestamp updateTime;
    @TableField(value = "IS_DELETE")
    private Long isDelete;
    @TableField(value = "STATUS")
    private int status;

}
