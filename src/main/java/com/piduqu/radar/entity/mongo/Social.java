package com.piduqu.radar.entity.mongo;

/**
 * 社会实践
 * Created by jiangwei on 2016/4/25 0025.
 */
public class Social {

    private String start_time;//开始时间
    private String end_time;//结束时间
    private String social_name;//名称
    private String social_desc;//描述

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

    public String getSocial_name() {
        return social_name;
    }

    public void setSocial_name(String social_name) {
        this.social_name = social_name;
    }

    public String getSocial_desc() {
        return social_desc;
    }

    public void setSocial_desc(String social_desc) {
        this.social_desc = social_desc;
    }
}
