package com.piduqu.radar.entity.mongo;

/**
 * 培训经历
 * Created by jiangwei on 2016/4/25 0025.
 */
public class Train {
   
    private String start_date;//开始时间
    private String end_date;//结束时间
    private String train_name;//培训的项目
    private String train_school;//培训机构
    private String train_city;//培训地点
    private String train_desc;//培训描述
    private String train_certificate;//证书

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

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public String getTrain_school() {
        return train_school;
    }

    public void setTrain_school(String train_school) {
        this.train_school = train_school;
    }

    public String getTrain_city() {
        return train_city;
    }

    public void setTrain_city(String train_city) {
        this.train_city = train_city;
    }

    public String getTrain_desc() {
        return train_desc;
    }

    public void setTrain_desc(String train_desc) {
        this.train_desc = train_desc;
    }

    public String getTrain_certificate() {
        return train_certificate;
    }

    public void setTrain_certificate(String train_certificate) {
        this.train_certificate = train_certificate;
    }
}
