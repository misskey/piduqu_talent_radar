package com.piduqu.radar.common.enums;


import com.piduqu.radar.common.utils.CommonUtils;

public enum EnumUserStatus {
    /*用户状态*/
    USER_REGISTER(0,"已注册,但未激活"),
    USER_ACTIVE(1,"正常"),
    USER_FREEZE(2,"冻结"),
    USER_DESTROY(3,"已销毁"),
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

    EnumUserStatus(Integer code, String description){
        this.code = code;
        this.description = description;
    }

    public static EnumUserStatus getEnumUserStatusByCode(Integer code){
        if (CommonUtils.isEmpty(code)) {
            return null;
        }
        for(EnumUserStatus souce : values()){
            if(souce.getCode().equals(code))
                return souce;
        }
        return null;
    }
}
