package com.piduqu.radar.entity.mongo;

/**
 * 校内职务
 * Created by jiangwei on 2016/4/25 0025.
 */
public class SchoolPosition {

    private String start_time;//开始时间
    private String end_time;//结束时间
    private String position_name;//职位名称
    private String position_desc;//职位描述

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

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getPosition_desc() {
        return position_desc;
    }

    public void setPosition_desc(String position_desc) {
        this.position_desc = position_desc;
    }
}
