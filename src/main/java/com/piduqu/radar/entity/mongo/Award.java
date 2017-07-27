package com.piduqu.radar.entity.mongo;

/**
 * Created by ZhaoCeng on 2016/7/25.
 */
public class Award {

    private String time	;//	获取时间
    private String  award_name	;//	奖项名称
    private String award_level	;//	奖项等级
    private String award_desc	;//	奖项描述

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAward_name() {
        return award_name;
    }

    public void setAward_name(String award_name) {
        this.award_name = award_name;
    }

    public String getAward_level() {
        return award_level;
    }

    public void setAward_level(String award_level) {
        this.award_level = award_level;
    }

    public String getAward_desc() {
        return award_desc;
    }

    public void setAward_desc(String award_desc) {
        this.award_desc = award_desc;
    }
}
