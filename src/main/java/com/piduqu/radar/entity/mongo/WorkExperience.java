package com.piduqu.radar.entity.mongo;


/**
 * 工作经历
 * Created by jiangwei on 2016/4/12 0012.
 */
public class WorkExperience {
    private String enterprise_name;//公司名称
    private String position_name;//职位名称
    private String experience_desc;//工作简介
    private String start_date;//开始时间
    private String end_date ;//结束时间
    private String enterprise_size;//公司规模
    private String enterprise_type;//公司性质
    private String work_time;//在职时长,统一化为工作月数 格式包含60-80 和24
    private String enterprise_industry;//公司行业
    private String salary;//工作薪资
    private String department;//所在部门
    private String second_job_type;//第二工作类型
    private String first_job_type;//第一工作类型

    public String getEnterprise_name() {
        return enterprise_name;
    }

    public void setEnterprise_name(String enterprise_name) {
        this.enterprise_name = enterprise_name;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getExperience_desc() {
        return experience_desc;
    }

    public void setExperience_desc(String experience_desc) {
        this.experience_desc = experience_desc;
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

    public String getEnterprise_size() {
        return enterprise_size;
    }

    public void setEnterprise_size(String enterprise_size) {
        this.enterprise_size = enterprise_size;
    }

    public String getEnterprise_type() {
        return enterprise_type;
    }

    public void setEnterprise_type(String enterprise_type) {
        this.enterprise_type = enterprise_type;
    }

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public String getEnterprise_industry() {
        return enterprise_industry;
    }

    public void setEnterprise_industry(String enterprise_industry) {
        this.enterprise_industry = enterprise_industry;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSecond_job_type() {
        return second_job_type;
    }

    public void setSecond_job_type(String second_job_type) {
        this.second_job_type = second_job_type;
    }

    public String getFirst_job_type() {
        return first_job_type;
    }

    public void setFirst_job_type(String first_job_type) {
        this.first_job_type = first_job_type;
    }
}
