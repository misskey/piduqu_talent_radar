package com.piduqu.radar.entity.mongo;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenwei on 2017/7/4.
 */
public class Talent_radar {

    @Id
    private String id;
    private String 	name;//姓名
    private String 	phone;//电话
    private String 	email;//邮件
    private String 	birthday;//	出生日期
    private String 	marital_status	;//婚姻状况
    private String 	hometown;//籍贯
    private String 	living;//现居住地
    private String city="";//城市  by chenwei  赵曾首页统计使用
    private String 	politics;//	身份
    private String 	gender;//性别
    private String 	self_introduction;//自我介绍
    private String 	age;//年龄
    private String 	degree;//学历
    private String 	osExperience;//海外工作经验
    private String 	work_status;//工作状态
    private String title;//职称
    private String 	source;//来源
    private String 	college_name;//学校名称
    private String 	last_year_salary;//目前年薪
    private String 	profession_name;//专业名称
    private String 	work_year;//工作年限
    private String 	height;//身高
    private String 	interests	;//	兴趣爱好
    private String 	specialty	;//	特长
    private String 	special_skills	;//	特殊技能
    private String 	country	;//	国籍
    private List<Education> educationList=new ArrayList<Education>();//教育信息集合
    private List<WorkExperience> workExperienceList = new ArrayList<WorkExperience>();//工作信息
    private List<Project> projectList = new ArrayList<>();//项目经历
    private List<Train> trainList=new ArrayList<Train>();//培训经历集合
    private List<Certificate> certificateList = new ArrayList<Certificate>();//证书
    private List<Language> languageList = new ArrayList<Language>();//语言
    private List<Skill> skillList = new ArrayList<Skill>();//专业技能集合
    private List<Award> awardList=new ArrayList<Award>();//奖项集合
    private List<Social> socialList = new ArrayList<Social>();//社会实践
    private List<SchoolPosition> schoolPositionList=new ArrayList<SchoolPosition>();//校内职务集合
    private List<Product> productList=new ArrayList<Product>();//作品集
    private List<Scholarship> scholarshipList = new ArrayList<Scholarship>();//奖学金

    private List<SocialContact> socialContactList = new ArrayList<SocialContact>();//社交信息
    private List<AdditionalMsg> additionalMsgList = new ArrayList<AdditionalMsg>();//附加信息

    private String industry_field;//行业领域
    private String expert_type;//人才级别
    private String source_type;//区分外部人才是寻英还是高端人才，高端人才为1，寻英为2
    private String type;//统一字段为外部人才，目前定义为1 外部寻英人才，2 组织部内部人才
    private String create_time;//创建时间

    private String user_id;//用户id

    private String update_time;
    private String update_user_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getLiving() {
        return living;
    }

    public void setLiving(String living) {
        this.living = living;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSelf_introduction() {
        return self_introduction;
    }

    public void setSelf_introduction(String self_introduction) {
        this.self_introduction = self_introduction;
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

    public String getOsExperience() {
        return osExperience;
    }

    public void setOsExperience(String osExperience) {
        this.osExperience = osExperience;
    }

    public String getWork_status() {
        return work_status;
    }

    public void setWork_status(String work_status) {
        this.work_status = work_status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getLast_year_salary() {
        return last_year_salary;
    }

    public void setLast_year_salary(String last_year_salary) {
        this.last_year_salary = last_year_salary;
    }

    public String getProfession_name() {
        return profession_name;
    }

    public void setProfession_name(String profession_name) {
        this.profession_name = profession_name;
    }

    public String getWork_year() {
        return work_year;
    }

    public void setWork_year(String work_year) {
        this.work_year = work_year;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSpecial_skills() {
        return special_skills;
    }

    public void setSpecial_skills(String special_skills) {
        this.special_skills = special_skills;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Train> getTrainList() {
        return trainList;
    }

    public void setTrainList(List<Train> trainList) {
        this.trainList = trainList;
    }

    public List<Certificate> getCertificateList() {
        return certificateList;
    }

    public void setCertificateList(List<Certificate> certificateList) {
        this.certificateList = certificateList;
    }

    public List<Language> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public List<Award> getAwardList() {
        return awardList;
    }

    public void setAwardList(List<Award> awardList) {
        this.awardList = awardList;
    }

    public List<Social> getSocialList() {
        return socialList;
    }

    public void setSocialList(List<Social> socialList) {
        this.socialList = socialList;
    }

    public List<SchoolPosition> getSchoolPositionList() {
        return schoolPositionList;
    }

    public void setSchoolPositionList(List<SchoolPosition> schoolPositionList) {
        this.schoolPositionList = schoolPositionList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Scholarship> getScholarshipList() {
        return scholarshipList;
    }

    public void setScholarshipList(List<Scholarship> scholarshipList) {
        this.scholarshipList = scholarshipList;
    }

    public String getIndustry_field() {
        return industry_field;
    }

    public void setIndustry_field(String industry_field) {
        this.industry_field = industry_field;
    }

    public String getExpert_type() {
        return expert_type;
    }

    public void setExpert_type(String expert_type) {
        this.expert_type = expert_type;
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

    public List<SocialContact> getSocialContactList() {
        return socialContactList;
    }

    public void setSocialContactList(List<SocialContact> socialContactList) {
        this.socialContactList = socialContactList;
    }

    public List<AdditionalMsg> getAdditionalMsgList() {
        return additionalMsgList;
    }

    public void setAdditionalMsgList(List<AdditionalMsg> additionalMsgList) {
        this.additionalMsgList = additionalMsgList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getUpdate_user_id() {
        return update_user_id;
    }

    public void setUpdate_user_id(String update_user_id) {
        this.update_user_id = update_user_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
