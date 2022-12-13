package com.autotest.astarte.web.service;

import com.autotest.astarte.api.bean.InterfaceBean;
import com.autotest.astarte.api.bean.common.AtpResponse;
import com.autotest.astarte.api.entity.Interface;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface InterfaceService {

    Interface selectInterfaceById(Long id);

    AtpResponse selectInterfaceList(InterfaceBean entity);

    AtpResponse saveInterface(InterfaceBean entity);

    AtpResponse updateInterface(InterfaceBean entity);

    AtpResponse deleteInterface(String ids);

    AtpResponse debugInterface(InterfaceBean entity);

}
