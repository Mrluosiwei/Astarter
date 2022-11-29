package com.autotest.astarte.api.util;

import com.autotest.astarte.api.entity.Interface;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;

public class PackData {

    public static <T> HashMap packingData(IPage<T> interfacePage){
        HashMap map = new HashMap();
        map.put("list",interfacePage.getRecords());
        map.put("total",interfacePage.getTotal());
        map.put("pageNumber",interfacePage.getCurrent());
        map.put("pageSize",interfacePage.getSize());
        return map;
    }
}
