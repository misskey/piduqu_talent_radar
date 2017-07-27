package com.piduqu.radar.entity.mongo;

/**
 * Created by ZhaoCeng on 2016/7/25.
 */
public class Product {

    private String product_name	;//	作品名称
    private String start_time	;//	开始时间
    private String end_time	;//	结束时间
    private String product_desc	;//	描述

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }
}
