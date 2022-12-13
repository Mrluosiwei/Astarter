package com.autotest.astarte.web.controller;


import com.autotest.astarte.api.bean.AtpSystemEnvBean;
import com.autotest.astarte.api.bean.InterfaceBean;
import com.autotest.astarte.api.bean.common.AtpResponse;
import com.autotest.astarte.api.entity.Interface;
import com.autotest.astarte.web.mapper.InterfaceMapper;
import com.autotest.astarte.web.service.AtpSystemEnvService;
import com.autotest.astarte.web.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/systemEnv")
public class AtpSystemEnvController {

    @Autowired
    AtpSystemEnvService AtpSystemEnvService;

    @PostMapping("/querySystemEnvOne")
    public AtpResponse queryInterfaceOne(@RequestBody AtpSystemEnvBean entity){
        AtpResponse AtpResponse = AtpSystemEnvService.selectSystemEnvOne(entity);
        return AtpResponse;
    }

    @PostMapping("/querySystemEnvList")
    public AtpResponse queryInterfaceList(@RequestBody AtpSystemEnvBean entity){
        AtpResponse atpResponse = AtpSystemEnvService.selectSystemEnvList(entity);
        return atpResponse;
    }

    @PostMapping("/saveSystemEnv")
    public AtpResponse saveInterface(@RequestBody AtpSystemEnvBean entity){
        AtpResponse atpResponse = AtpSystemEnvService.saveSystemEnv(entity);
        return atpResponse;
    }

}
