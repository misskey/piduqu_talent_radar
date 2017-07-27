package com.piduqu.radar.entity.mongo;

/**
 * Created by jiangwei on 2016/4/12 0012.
 */
public class Address {

    private CodeMapName province;
    private CodeMapName city;
    private CodeMapName district;
    private CodeMapName block;

    public CodeMapName getProvince() {
        return province;
    }

    public void setProvince(CodeMapName province) {
        this.province = province;
    }

    public CodeMapName getCity() {
        return city;
    }

    public void setCity(CodeMapName city) {
        this.city = city;
    }

    public CodeMapName getDistrict() {
        return district;
    }

    public void setDistrict(CodeMapName district) {
        this.district = district;
    }

    public CodeMapName getBlock() {
        return block;
    }

    public void setBlock(CodeMapName block) {
        this.block = block;
    }
}
