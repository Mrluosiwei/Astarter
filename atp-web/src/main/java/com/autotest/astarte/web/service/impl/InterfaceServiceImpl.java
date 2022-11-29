package com.autotest.astarte.web.service.impl;

import com.autotest.astarte.api.bean.InterfaceBean;
import com.autotest.astarte.api.bean.common.AtpResponse;
import com.autotest.astarte.api.entity.Interface;
import com.autotest.astarte.api.util.JsonParseUtil;
import com.autotest.astarte.api.util.PackData;
import com.autotest.astarte.web.mapper.InterfaceMapper;
import com.autotest.astarte.web.service.InterfaceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InterfaceServiceImpl implements InterfaceService {

    @Autowired
    InterfaceMapper InterfaceMapper;

    @Override
    public Interface selectInterfaceById(Long id) {
        Interface interfaceEntity = new Interface();
        interfaceEntity.setId(id);
        Interface anInterface = InterfaceMapper.selectInterfaceById(interfaceEntity);
        return anInterface;
    }

    @Override
    public AtpResponse selectInterfaceList(InterfaceBean entity) {
        QueryWrapper<Interface> queryWrapper = new QueryWrapper<>();
        Interface inter = new Interface();
        BeanUtils.copyProperties(entity,inter);
        queryWrapper.like(StringUtils.isNotBlank(inter.getInterfaceName()),
                "INTERFACE_NAME",inter.getInterfaceName())
                    ;
        inter.setInterfaceName(null);
        queryWrapper.setEntity(inter);
        queryWrapper.orderByDesc("UPDATE_TIME");

        Page<Interface> page = new Page<Interface>();
        page.setSize(entity.getPageSize());
        page.setCurrent(entity.getPageNumber());
        IPage<Interface> interfacePage = InterfaceMapper.selectPage(page, queryWrapper);
//        IPage<Interface> interfaceIPage = InterfaceMapper.selectInterfaceByPage(page, queryWrapper);
        HashMap hashMap = PackData.packingData(interfacePage);
//        List<Interface> records = interfacePage.getRecords();
//        records.forEach(System.out::println);
        return AtpResponse.success(hashMap);
    }




}
