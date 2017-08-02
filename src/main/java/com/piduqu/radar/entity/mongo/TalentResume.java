package com.piduqu.radar.entity.mongo;

import com.alibaba.fastjson.JSONArray;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 简历
 * Created by yangxue on 2016/4/12 0012.
 */
@Document(collection = "talent_resume")
public class TalentResume implements Serializable {
    @Id
    private String id;                   //mongo的objectId简历id，也作为本地数据库关联mongo的外键id
    @Field("name")
    private String name;                 //姓名
    @Field("gender")
    private String gender;               //性别

    @Field("birthday")
    private String birthday;             //生日
    @Field("age")
    private Integer age;                  //年龄
    @Field("degree")
    private String degree;               //学历
    @Field("telphone")
    private String telphone;             //电话;
    @Field("email")
    private String email;                //邮箱;
    @Field("politics_status")
    private String politics_status;      //政治面貌;
    @Field("nation")
    private String nation;               //名族;
    @Field("contry")
    private String contry;               //国籍
    @Field("location")
    private String location;             //现居地;
    @Field("birthplace")
    private String birthplace;           //出生地
    @Field("industry")
    private String industry;             //所属行业（领域）
    @Field("expert_type")
    private String expert_type;          //人才级别
    @Field("department_level")
    private String department_level;     //十支人才类别
    @Field("qualification")
    private String qualification;        //职业资格
    @Field("position")
    private String position;             //职称
    @Field("status")
    private String status;               //状态
    @Field("self_description")
    private String self_description;     //自我描述
    @Field("experience")
    private List<JSONArray> experience;     //自我描述

    public Date getImport_time() {
        return import_time;
    }

    public void setImport_time(Date import_time) {
        this.import_time = import_time;
    }

    @Field

    private Date import_time;

    public List<JSONArray> getExperience() {
        return experience;
    }

    public void setExperience(List<JSONArray> experience) {
        this.experience = experience;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSelf_description() {
        return self_description;
    }

    public void setSelf_description(String self_description) {
        this.self_description = self_description;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDepartment_level() {
        return department_level;
    }

    public void setDepartment_level(String department_level) {
        this.department_level = department_level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpert_type() {
        return expert_type;
    }

    public void setExpert_type(String expert_type) {
        this.expert_type = expert_type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPolitics_status() {
        return politics_status;
    }

    public void setPolitics_status(String politics_status) {
        this.politics_status = politics_status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getQualification() {
        return qualification;
    }


    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
}
