package com.piduqu.radar.entity.mongo;

/**
 * Created on 2017/6/2.
 * 外部人才实体类
 * source_type 1为高端人才包括国外和中科院爬取的人才
 * 2为寻英人才
 * type 区分内部人才还是外部人才 具体为out in
 */
public class OuterResume {


    private String industry;   //行业一级类别

    private String create_time; //创建时间

    private String flag;  // 人才区分标志位，1中科院研究所人才，2 国外人才 3 中科院大学人才

    private String person_ID;

    private String url;  //来源地址

    private String source_name;  //来源网站

    private String industry_second; // 行业二级类别

    private String id;

    private String headImg;  // 头像

    private String subject_type; // 学科类别

    private String address; // 地址

    private String paper; //论文

    private String work_experience; //工作经历

    private String education; // 教育经历

    private String code; // 邮编

    private String en_name; // 英文名

    private String title; // 职称

    private String patent; // 专利

    private String zh_name; // 中文名

    private String expert_type; // 人才级别

    private String research; // 研究方向

    private String homepage; // 主页

    private String email; // 邮箱

    private String fax; // 传真

    private String degree; // 学历

    private String company; // 工作单位(公司)

    private String award; // 获奖情况

    private String nation; // 国家

    private String phone; // 电话

    private String job; // 职位

    private String ethnic; // 名族

    private String person_info; // 个人简介

    private String name; // 名字

    private String social_job; // 社会任职

    private String gender; // 性别

    private String project; // 承担科研项目

    private String source_type; // 1 为高端人才 2 为寻英人才

    private String type; // 人才来源 2为外部 , 1为内部

    private String city="";//城市  by chenwei  赵曾首页统计使用

    public String getIndustry_second() {
        return industry_second;
    }

    public void setIndustry_second(String industry_second) {
        this.industry_second = industry_second;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPerson_ID() {
        return person_ID;
    }

    public void setPerson_ID(String person_ID) {
        this.person_ID = person_ID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject_type() {
        return subject_type;
    }

    public void setSubject_type(String subject_type) {
        this.subject_type = subject_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public String getWork_experience() {
        return work_experience;
    }

    public void setWork_experience(String work_experience) {
        this.work_experience = work_experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEn_name() {
        return en_name;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPatent() {
        return patent;
    }

    public void setPatent(String patent) {
        this.patent = patent;
    }

    public String getZh_name() {
        return zh_name;
    }

    public void setZh_name(String zh_name) {
        this.zh_name = zh_name;
    }

    public String getExpert_type() {
        return expert_type;
    }

    public void setExpert_type(String expert_type) {
        this.expert_type = expert_type;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getPerson_info() {
        return person_info;
    }

    public void setPerson_info(String person_info) {
        this.person_info = person_info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocial_job() {
        return social_job;
    }

    public void setSocial_job(String social_job) {
        this.social_job = social_job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSource_type() {
        return source_type;
    }

    public void setSource_type(String source_type) {
        this.source_type = source_type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
