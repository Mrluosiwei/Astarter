package com.autotest.astarte.web.service.impl;

import com.autotest.astarte.api.bean.AtpSystemBean;
import com.autotest.astarte.api.bean.InterfaceBean;
import com.autotest.astarte.api.bean.common.AtpResponse;
import com.autotest.astarte.api.entity.AtpSystemEntity;
import com.autotest.astarte.api.entity.Interface;
import com.autotest.astarte.api.util.PackData;
import com.autotest.astarte.web.mapper.AtpSystemMapper;
import com.autotest.astarte.web.service.AtpSystemService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class AtpSystemServiceImpl implements AtpSystemService {

    //调试日志
    private Logger logger = LoggerFactory.getLogger(AtpSystemServiceImpl.class);

    @Autowired
    AtpSystemMapper atpSystemMapper ;
    @Override
    public AtpResponse selectSystemList(AtpSystemBean entity) {
        Page page = new Page(entity.getPageNumber(),entity.getPageSize());
        LambdaQueryWrapper<AtpSystemEntity> qw = new LambdaQueryWrapper();
        qw.like(AtpSystemEntity::getSystemName, entity.getSystemName())
                .orderByDesc(AtpSystemEntity::getUpdateTime);
        Page<AtpSystemEntity> pageV = atpSystemMapper.selectPage(page, qw);
        HashMap hashMap = PackData.packingData(pageV);
        return AtpResponse.success(hashMap);
    }

    @Override
    public AtpResponse selectSystemOne(AtpSystemBean entity) {
        AtpSystemEntity atpSystemEntity = atpSystemMapper.selectById(entity.getId());
        return AtpResponse.success(atpSystemEntity);
    }

    @Override
    public AtpResponse saveSystem(AtpSystemBean entity) {
        try {
            LambdaQueryWrapper<AtpSystemEntity> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(AtpSystemEntity::getSystemName,entity.getSystemName());
            List<AtpSystemEntity> atpSystemEntities = atpSystemMapper.selectList(queryWrapper);
            if(!CollectionUtils.isEmpty(atpSystemEntities))
                return AtpResponse.fail("系统名不可重复");
            AtpSystemEntity inter = new AtpSystemEntity();
            BeanUtils.copyProperties(entity,inter);
            inter.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            atpSystemMapper.insert(inter);
            return AtpResponse.success();
        } catch (BeansException e) {
            e.printStackTrace();
            return AtpResponse.fail(e.getMessage());
        }
    }

    @Override
    public AtpResponse updateSystem(AtpSystemBean entity) {
        try {
            LambdaQueryWrapper<AtpSystemEntity> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(AtpSystemEntity::getSystemName,entity.getSystemName());
            List<AtpSystemEntity> atpSystemEntities = atpSystemMapper.selectList(queryWrapper);
            if(!CollectionUtils.isEmpty(atpSystemEntities) && !atpSystemEntities.get(0).getId().equals(entity.getId()))
                return AtpResponse.fail("系统名不可重复");
            AtpSystemEntity inter = new AtpSystemEntity();
            BeanUtils.copyProperties(entity,inter);
            inter.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            atpSystemMapper.updateById(inter);
            return AtpResponse.success();
        } catch (BeansException e) {
            e.printStackTrace();
            return AtpResponse.fail(e.getMessage());
        }
    }

    @Override
    public AtpResponse deleteSystem(String ids) {
        try {
            if(org.springframework.util.StringUtils.isEmpty(ids))
                AtpResponse.fail("删除失败");
            List<String> list = Arrays.asList(ids.split(","));
            atpSystemMapper.deleteBatchIds(list);
            return AtpResponse.success();
        } catch (BeansException e) {
            e.printStackTrace();
            return AtpResponse.fail(e.getMessage());
        }
    }
}
