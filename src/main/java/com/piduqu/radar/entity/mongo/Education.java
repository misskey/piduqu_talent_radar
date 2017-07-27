package com.piduqu.radar.entity.mongo;

/**
 * Created by ZhaoCeng on 2016/7/25.
 */
public class Education {

    private String  college_name="";// 学校名字
    private String profession_name="";// 专业名称
    private String degree="";//学历
    private String start_date="";// 开始时间
    private String end_date="";//结束时间
    private String desc="";//专业描述

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getProfession_name() {
        return profession_name;
    }

    public void setProfession_name(String profession_name) {
        this.profession_name = profession_name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
