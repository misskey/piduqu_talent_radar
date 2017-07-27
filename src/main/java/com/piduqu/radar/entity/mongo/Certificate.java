package com.piduqu.radar.entity.mongo;

/**
 * 证书
 * Created by jiangwei on 2016/4/25 0025.
 */
public class Certificate {

    private String get_time;// 获取证书的时间
    private String certificate_name;// 证书名称
    private String certificate_school;// 证书发放机构
    private String certificate_score;// 证书分数(评级) 一般一等奖 优秀 553 合格 学习进步奖学金等

    public String getGet_time() {
        return get_time;
    }

    public void setGet_time(String get_time) {
        this.get_time = get_time;
    }

    public String getCertificate_name() {
        return certificate_name;
    }

    public void setCertificate_name(String certificate_name) {
        this.certificate_name = certificate_name;
    }

    public String getCertificate_school() {
        return certificate_school;
    }

    public void setCertificate_school(String certificate_school) {
        this.certificate_school = certificate_school;
    }

    public String getCertificate_score() {
        return certificate_score;
    }

    public void setCertificate_score(String certificate_score) {
        this.certificate_score = certificate_score;
    }
}
