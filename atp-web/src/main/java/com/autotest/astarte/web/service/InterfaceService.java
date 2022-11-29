package com.autotest.astarte.web.service;

import com.autotest.astarte.api.bean.InterfaceBean;
import com.autotest.astarte.api.bean.common.AtpResponse;
import com.autotest.astarte.api.entity.Interface;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InterfaceService {

    Interface selectInterfaceById(Long id);

    AtpResponse selectInterfaceList(InterfaceBean entity);
}
