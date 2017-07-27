package com.piduqu.radar.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by chenwei on 2017/6/27.
 */

public enum EnumOrgType {

    TYPE_1("1","郫都区委组织部"),
    TYPE_2("2","镇"),
    TYPE_3("3","企业"),
    TYPE_4("4","局"),
    ;

    private String code;

    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    EnumOrgType(String code, String description){
        this.code = code;
        this.description = description;
    }

    public static EnumOrgType getEnumOrgTypeByCode(String code){
        if(StringUtils.isBlank(code)){
            return null;
        }
        for (EnumOrgType status : values()){
            if(StringUtils.equals(code,status.getCode()))
                return status;
        }
        return null;
    }
}
