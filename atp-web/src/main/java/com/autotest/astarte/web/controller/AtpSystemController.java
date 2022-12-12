package com.autotest.astarte.web.controller;


import com.autotest.astarte.api.bean.AtpSystemBean;
import com.autotest.astarte.api.bean.InterfaceBean;
import com.autotest.astarte.api.bean.common.AtpResponse;
import com.autotest.astarte.api.entity.Interface;
import com.autotest.astarte.web.mapper.AtpSystemMapper;
import com.autotest.astarte.web.mapper.InterfaceMapper;
import com.autotest.astarte.web.service.AtpSystemService;
import com.autotest.astarte.web.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/system")
public class AtpSystemController {

    @Autowired
    AtpSystemService AtpSystemService;


    @PostMapping("/querySystemOne")
    public AtpResponse queryInterfaceOne(@RequestBody AtpSystemBean entity){
        AtpResponse AtpResponse = AtpSystemService.selectSystemOne(entity);
        return AtpResponse;
    }

    @PostMapping("/queryAtpSystemList")
    public AtpResponse queryInterfaceList(@RequestBody AtpSystemBean entity){
        AtpResponse atpResponse = AtpSystemService.selectSystemList(entity);
        return atpResponse;
    }

    @PostMapping("/saveAtpSystem")
    public AtpResponse saveInterface(@RequestBody AtpSystemBean entity){
        AtpResponse atpResponse = AtpSystemService.saveSystem(entity);
        return atpResponse;
    }


}
