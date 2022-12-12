package com.autotest.astarte.api.bean;

import com.autotest.astarte.api.bean.common.PageEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@Accessors(chain = true)
@TableName("atp_system")
public class AtpSystemBean extends PageEntity {
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    @TableField(value = "SYSTEM_NAME")
    private String systemName;
    @TableField(value = "SYSTEM_ID")
    private Long systemId;
    @TableField(value = "DESCRIPTION")
    private String description;
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
    @TableField(value = "LEADER")
    private String leader;
}
