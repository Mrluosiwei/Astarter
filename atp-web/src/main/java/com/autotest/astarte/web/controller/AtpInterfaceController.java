package com.autotest.astarte.web.controller;


import com.autotest.astarte.api.bean.InterfaceBean;
import com.autotest.astarte.api.bean.common.AtpResponse;
import com.autotest.astarte.api.entity.Interface;
import com.autotest.astarte.web.mapper.InterfaceMapper;
import com.autotest.astarte.web.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/interface")
public class AtpInterfaceController {

    @Autowired
    InterfaceService interfaceService;
    @Autowired
    InterfaceMapper interfaceMapper;

    @PostMapping("/queryInterfaceOne")
    public Interface queryInterfaceOne(@RequestBody InterfaceBean entity){
        Interface anInterface = interfaceService.selectInterfaceById(entity.getId());
        return anInterface;
    }

    @PostMapping("/queryInterfaceList")
    public AtpResponse queryInterfaceList(@RequestBody InterfaceBean entity){
        AtpResponse atpResponse = interfaceService.selectInterfaceList(entity);
        return atpResponse;
    }

    @PostMapping("/saveInterface")
    public AtpResponse saveInterface(@RequestBody InterfaceBean entity){
        AtpResponse atpResponse = interfaceService.saveInterface(entity);
        return atpResponse;
    }

}
