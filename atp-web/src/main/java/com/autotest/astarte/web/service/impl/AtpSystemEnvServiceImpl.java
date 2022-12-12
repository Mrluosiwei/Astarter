package com.autotest.astarte.web.service.impl;

import com.autotest.astarte.api.bean.AtpSystemBean;
import com.autotest.astarte.api.bean.AtpSystemEnvBean;
import com.autotest.astarte.api.bean.common.AtpResponse;
import com.autotest.astarte.api.entity.AtpSystemEntity;
import com.autotest.astarte.api.entity.AtpSystemEnvEntity;
import com.autotest.astarte.api.util.PackData;
import com.autotest.astarte.web.mapper.AtpSystemEnvMapper;
import com.autotest.astarte.web.mapper.AtpSystemMapper;
import com.autotest.astarte.web.service.AtpSystemEnvService;
import com.autotest.astarte.web.service.AtpSystemService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@Service
public class AtpSystemEnvServiceImpl implements AtpSystemEnvService {

    //调试日志
    private Logger logger = LoggerFactory.getLogger(AtpSystemEnvServiceImpl.class);

    @Autowired
    AtpSystemEnvMapper atpSystemEnvMapper;

    @Override
    public AtpResponse selectSystemEnvList(AtpSystemEnvBean entity) {
        Page page = new Page(entity.getPageNumber(),entity.getPageSize());
        LambdaQueryWrapper<AtpSystemEnvEntity> qw = new LambdaQueryWrapper();
        qw.like(AtpSystemEnvEntity::getEnvName, entity.getEnvName())
                .orderByDesc(AtpSystemEnvEntity::getUpdateTime);
        Page<AtpSystemEnvEntity> pageV = atpSystemEnvMapper.selectPage(page, qw);
        HashMap hashMap = PackData.packingData(pageV);
        return AtpResponse.success(hashMap);
    }

    @Override
    public AtpResponse selectSystemEnvOne(AtpSystemEnvBean entity) {
        AtpSystemEnvEntity atpSystemEntity = atpSystemEnvMapper.selectById(entity.getId());
        return AtpResponse.success(atpSystemEntity);
    }

    @Override
    public AtpResponse saveSystemEnv(AtpSystemEnvBean entity) {
        try {
            LambdaQueryWrapper<AtpSystemEnvEntity> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(AtpSystemEnvEntity::getSystemId,entity.getSystemId());
            queryWrapper.eq(AtpSystemEnvEntity::getEnvShort,entity.getEnvShort());
            List<AtpSystemEnvEntity> atpSystemEntities = atpSystemEnvMapper.selectList(queryWrapper);
            if(!CollectionUtils.isEmpty(atpSystemEntities))
                return AtpResponse.fail("环境不可重复");
            AtpSystemEnvEntity inter = new AtpSystemEnvEntity();
            BeanUtils.copyProperties(entity,inter);
            inter.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            atpSystemEnvMapper.insert(inter);
            return AtpResponse.success();
        } catch (BeansException e) {
            e.printStackTrace();
            return AtpResponse.fail(e.getMessage());
        }
    }

    @Override
    public AtpResponse updateSystemEnv(AtpSystemEnvBean entity) {
        try {
            LambdaQueryWrapper<AtpSystemEnvEntity> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(AtpSystemEnvEntity::getSystemId,entity.getSystemId());
            queryWrapper.eq(AtpSystemEnvEntity::getEnvShort,entity.getEnvShort());
            List<AtpSystemEnvEntity> atpSystemEntities = atpSystemEnvMapper.selectList(queryWrapper);
            if(!CollectionUtils.isEmpty(atpSystemEntities))
                return AtpResponse.fail("环境不可重复");
            AtpSystemEnvEntity inter = new AtpSystemEnvEntity();
            BeanUtils.copyProperties(entity,inter);
            inter.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            atpSystemEnvMapper.updateById(inter);
            return AtpResponse.success();
        } catch (BeansException e) {
            e.printStackTrace();
            return AtpResponse.fail(e.getMessage());
        }
    }

    @Override
    public AtpResponse deleteSystemEnv(@RequestParam String ids) {
        try {
            if(org.springframework.util.StringUtils.isEmpty(ids))
                AtpResponse.fail("删除失败");
            List<String> list = Arrays.asList(ids.split(","));
            atpSystemEnvMapper.deleteBatchIds(list);
            return AtpResponse.success();
        } catch (BeansException e) {
            e.printStackTrace();
            return AtpResponse.fail(e.getMessage());
        }
    }
}
