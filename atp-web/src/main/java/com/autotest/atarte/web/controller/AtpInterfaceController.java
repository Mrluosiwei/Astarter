package com.autotest.atarte.web.controller;


import com.autotest.astarte.api.bean.InterfaceEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/interface")
public class AtpInterfaceController {

    @PostMapping("/queryInterfaceOne")
    public static void queryInterfaceOne(@RequestBody InterfaceEntity entity){

    }

}
