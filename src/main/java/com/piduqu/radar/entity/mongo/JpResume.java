package com.piduqu.radar.entity.mongo;

import java.util.List;

public class JpResume {

    //简历id，也就是talent_resume_id
    private String id;
    //性别
    private String gender;
    //年龄
    private String age;
    //学历
    private String degree;
    //婚姻状况
    private String marital_status;
    //工作年限
    private String work_year;
    //现居住地
    private String living;
    //目标职位
    private String expect_position;
    //行业领域
    private String expect_industry;
    //上岗时间
    private String starting_date;
    //目标城市
    private String expect_city;
    //期望薪资
    private String expect_salary;
    //自我评价
    private String self_introduction;
    //大学名称
    private String college_name;
    //专业
    private String profession_name;

    //上家单位
    private String last_enterprise_name;
    //上个职位
    private String last_position_name;
    //人名
    private String name;
    //邮箱
    private String email;
    //电话
    private String phone;
    //简历URL
    private String resume_url;

    //简历更新时间
    private String update_time;
    //简历详情ID
    private String search_detail_id;
    private String resume_mail;

    private String source;//简历来源
    private String resume_img;//简历头像

    public String getResume_img() {
        return resume_img;
    }

    public void setResume_img(String resume_img) {
        this.resume_img = resume_img;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    private List<WorkExperienceList> workExperienceList;

    private List<ProjectList> projectList;

    private List<EducationList> educationList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getWork_year() {
        return work_year;
    }

    public void setWork_year(String work_year) {
        this.work_year = work_year;
    }

    public String getLiving() {
        return living;
    }

    public void setLiving(String living) {
        this.living = living;
    }

    public String getExpect_position() {
        return expect_position;
    }

    public void setExpect_position(String expect_position) {
        this.expect_position = expect_position;
    }

    public String getExpect_industry() {
        return expect_industry;
    }

    public void setExpect_industry(String expect_industry) {
        this.expect_industry = expect_industry;
    }

    public String getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(String starting_date) {
        this.starting_date = starting_date;
    }

    public String getExpect_city() {
        return expect_city;
    }

    public void setExpect_city(String expect_city) {
        this.expect_city = expect_city;
    }

    public String getSelf_introduction() {
        return self_introduction;
    }

    public void setSelf_introduction(String self_introduction) {
        this.self_introduction = self_introduction;
    }

    public List<WorkExperienceList> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperienceList> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public List<ProjectList> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ProjectList> projectList) {
        this.projectList = projectList;
    }

    public List<EducationList> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<EducationList> educationList) {
        this.educationList = educationList;
    }

    public String getExpect_salary() {
        return expect_salary;
    }

    public void setExpect_salary(String expect_salary) {
        this.expect_salary = expect_salary;
    }

    public String getResume_mail() {
        return resume_mail;
    }

    public void setResume_mail(String resume_mail) {
        this.resume_mail = resume_mail;
    }

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

    public String getLast_enterprise_name() {
        return last_enterprise_name;
    }

    public void setLast_enterprise_name(String last_enterprise_name) {
        this.last_enterprise_name = last_enterprise_name;
    }

    public String getLast_position_name() {
        return last_position_name;
    }

    public void setLast_position_name(String last_position_name) {
        this.last_position_name = last_position_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getSearch_detail_id() {
        return search_detail_id;
    }

    public void setSearch_detail_id(String search_detail_id) {
        this.search_detail_id = search_detail_id;
    }

    public String getResume_url() {
        return resume_url;
    }

    public void setResume_url(String resume_url) {
        this.resume_url = resume_url;
    }
}
