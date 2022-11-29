package com.autotest.astarte.api.enumcom;

public enum ResultEnum {
    // 枚举定义
    SUCCESS("000000", "success"),
    FAIL("FFFFFF","fail"),
    INTERNAL_SERVER_ERROR("555555", "服务器异常请联系管理员"),
    ;

    /** 错误码 */
    private String code;

    /** 错误信息 */
    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
