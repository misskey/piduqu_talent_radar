package com.piduqu.radar.common.enums;

import org.apache.commons.lang3.ObjectUtils;

/**
 * @author 无聊的挂面
 * @since 2017-07-19 9:48
 */
public enum EnumResultCode {

    RESULTCODE_SUCCESS(0,"成功"),
    RESULTCODE_FAILURE(-1,"失败"),
    RESULTCODE_SYSTEM_EXCEPTION(-2,"系统异常"),
    RESULTCODE_PARAMETER_ERROR(-3,"参数错误"),


    ;

    private Integer code;

    private String description;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    EnumResultCode(Integer code, String description){
        this.code = code;
        this.description = description;
    }

    public static EnumResultCode getEnumResultCodeByCode(Integer code){
        if (null == code) {
            return null;
        }
        for(EnumResultCode souce : values()){
            if(souce.getCode().equals(code))
                return souce;
        }
        return null;

    }
}
