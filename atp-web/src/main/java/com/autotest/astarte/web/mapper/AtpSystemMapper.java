package com.autotest.astarte.web.mapper;

import com.autotest.astarte.api.entity.AtpSystemEntity;
import com.autotest.astarte.api.entity.Interface;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtpSystemMapper extends BaseMapper<AtpSystemEntity> {

//    IPage<Interface> selectInterfaceByPage(Page<Interface> interfacePage, @Param(Constants.WRAPPER) Wrapper<Interface> userWrapper);
}
