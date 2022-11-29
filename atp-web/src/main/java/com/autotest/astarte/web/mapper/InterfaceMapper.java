package com.autotest.astarte.web.mapper;

import com.autotest.astarte.api.entity.Interface;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface InterfaceMapper extends BaseMapper<Interface> {

    public Interface selectInterfaceById(Interface entity);

    IPage<Interface> selectInterfaceByPage(Page<Interface> interfacePage, @Param(Constants.WRAPPER) Wrapper<Interface> userWrapper);
}
