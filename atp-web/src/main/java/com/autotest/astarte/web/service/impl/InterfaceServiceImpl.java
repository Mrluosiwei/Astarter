package com.autotest.astarte.web.service.impl;

import com.autotest.astarte.api.bean.InterfaceBean;
import com.autotest.astarte.api.bean.common.AtpResponse;
import com.autotest.astarte.api.entity.Interface;
import com.autotest.astarte.api.util.PackData;
import com.autotest.astarte.web.mapper.InterfaceMapper;
import com.autotest.astarte.web.service.InterfaceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.*;


@Service
public class InterfaceServiceImpl implements InterfaceService {

    //调试日志
    private Logger logger = LoggerFactory.getLogger(InterfaceServiceImpl.class);

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
    public AtpResponse selectInterfaceList(@RequestBody InterfaceBean entity) {
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
//        IPage<Interface> interfacePage = InterfaceMapper.selectPage(page, queryWrapper);
        IPage<Interface> interfacePage = InterfaceMapper.selectInterfaceByPage(page, queryWrapper);
        HashMap hashMap = PackData.packingData(interfacePage);
//        List<Interface> records = interfacePage.getRecords();
//        records.forEach(System.out::println);
        return AtpResponse.success(hashMap);
    }

    @Override
    public AtpResponse saveInterface(@RequestBody InterfaceBean entity) {
        try {
            QueryWrapper<Interface> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("INTERFACE_NAME",entity.getInterfaceName());
            List<Interface> interfaces = InterfaceMapper.selectList(queryWrapper);
            if(!CollectionUtils.isEmpty(interfaces))
                return AtpResponse.fail("接口名不可重复");
            Interface inter = new Interface();
            BeanUtils.copyProperties(entity,inter);
            inter.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            InterfaceMapper.insert(inter);
            return AtpResponse.success();
        } catch (BeansException e) {
            e.printStackTrace();
            return AtpResponse.fail(e.getMessage());
        }
    }

    public AtpResponse updateInterface(@RequestBody InterfaceBean entity) {
        try {
            QueryWrapper<Interface> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("INTERFACE_NAME",entity.getInterfaceName());
            List<Interface> interfaces = InterfaceMapper.selectList(queryWrapper);
            if(!CollectionUtils.isEmpty(interfaces) && !interfaces.get(0).getId().equals(entity.getId()))
                return AtpResponse.fail("接口名不可重复");
            Interface inter = new Interface();
            BeanUtils.copyProperties(entity,inter);
            inter.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            InterfaceMapper.updateById(inter);
            return AtpResponse.success();
        } catch (BeansException e) {
            e.printStackTrace();
            return AtpResponse.fail(e.getMessage());
        }
    }

    public AtpResponse deleteInterface(@RequestParam String ids) {
        try {
            if(org.springframework.util.StringUtils.isEmpty(ids))
                AtpResponse.fail("删除失败");
            List<String> list = Arrays.asList(ids.split(","));
            InterfaceMapper.deleteInterfaces(list);
            return AtpResponse.success();
        } catch (BeansException e) {
            e.printStackTrace();
            return AtpResponse.fail(e.getMessage());
        }
    }

}
