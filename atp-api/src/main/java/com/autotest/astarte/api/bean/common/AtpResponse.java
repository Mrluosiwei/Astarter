package com.autotest.astarte.api.bean.common;

import com.autotest.astarte.api.enumcom.ResultEnum;
import lombok.Data;

@Data
public class AtpResponse {
    //是否成功
    private Boolean success;
    //状态码
    private String code;
    //提示信息
    private String msg;
    //数据
    private Object data;

    public AtpResponse() {}
    // 自定义构造方法
    public AtpResponse(Boolean success,String code, String msg,Object data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 其他异常
    public static AtpResponse otherException(ResultEnum resultEnum){
        AtpResponse result = new AtpResponse();
        result.setSuccess(false);
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMessage());
        result.setData(null);
        return result;
    }

    public static AtpResponse fail(ResultEnum resultEnum){
        AtpResponse result = new AtpResponse();
        result.setSuccess(false);
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMessage());
        result.setData(null);
        return result;
    }

    public static AtpResponse fail(String msg){
        AtpResponse result = new AtpResponse();
        result.setSuccess(false);
        result.setCode(ResultEnum.FAIL.getCode());
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static AtpResponse success(Object data){
        AtpResponse result = new AtpResponse();
        result.setSuccess(true);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(null);
        result.setData(data);
        return result;
    }

    public static AtpResponse success(){
        AtpResponse result = new AtpResponse();
        result.setSuccess(true);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(null);
        result.setData(null);
        return result;
    }
}
