package com.piduqu.radar.entity.mongo;


import java.util.ArrayList;
import java.util.List;

/**
 * 简历
 * Created by jiangwei on 2016/4/12 0012.
 */

public class Resume{

    private String id;//mongo的objectId简历id，也作为本地数据库关联mongo的外键id
    private String last_enterprise_name;//最后上班的公司
    private String interests;//兴趣爱好
    private String last_enterprise_industry;//最后上班的公司行业
    private String hometown;//籍贯
    private List<Education> educationList=new ArrayList<Education>();//教育信息集合
    private String special_skills;//特殊技能
    private String last_position_name;//最后工作的职位名称
    private String height;//身高
    private String expect_position;//期望职位
    private List<Award> awardList=new ArrayList<Award>();//奖项集合
    private  String drive_name;//驾驶证名称
    private String politics;//省份，如党员，团员
    private String career_goal;//职业目标
    private String enterprise_type;//公司性质
    private String work_status;//工作状态，如在职，离职
    private String living;//现居住地
    private String osExperience;//海外工作经验，如3个月
    private String profession_name;//专业名称
    private List<Product> productList=new ArrayList<Product>();//作品集
    private String source;//简历来源，如极聘，智联 英才 前程无忧
    private String last_year_salary;//目前年薪
    private String cv_id;//简历ID，更新标识
    private boolean dimension_flag=false;//默认false
    private String last_enterprise_salary;//最后上班的公司薪资
    private List<String> version = new ArrayList<String>();//版本号连接
    private String expect_job_type;//期望工作类型，全职兼职
    private List<String> keyword_id = new ArrayList<String>();//关键词ID链表
    private String email;//邮箱
    private List<Language> languageList = new ArrayList<Language>();//语言
    private String status;//简历状态关键字: -1:简历有问题,不能存入MySQL 0:新曾或已修改简历,未存入MySQL 1:已存入MySQL 2:算法已经读取
    private String update_time;//更新时间
    private String degree;//学历
    private List<Skill> skillList;//专业技能集合
    private String expect_industry;//期望工作行业
    private String specialty;//特长
    private String last_enterprise_time;//最后工作时长
    private String work_year;//工作年限
    private String phone;//电话
    private String flag;//算法状态关键字: 0:算法未更新导入 1:算法已经更新导入
    private List<Train> trainList=new ArrayList<Train>();//培训经历集合
    private String expect_occupation;//期望职位
    private String expect_salary;//期望薪资
    private String resume_keyword;//简历关键词
    private String expect_city;//期望工作城市
    private String starting_date;//上岗时间
    private String resume_img;//简历头像
    private String name;//姓名
    private String self_introduction;//自我介绍
    private String gender;//性别
    private String age;//年龄
    private String marital_status;//婚姻状态
    private List<SchoolPosition> schoolPositionList=new ArrayList<SchoolPosition>();//校内职务集合
    private List<String> resumeUpdateTimeList = new ArrayList<String>();//简历更新时间记录
    private List<Project> projectList;//项目经历
    private String birthday;//生日
    private List<Scholarship> scholarshipList = new ArrayList<Scholarship>();//奖学金
    private String crawled_time;//简历抓取时间
    private String country;//国家
    private List<Certificate> certificateList = new ArrayList<Certificate>();//证书
    private List<Social> socialList = new ArrayList<Social>();//社会实践
    private List<WorkExperience> workExperienceList = new ArrayList<WorkExperience>();//工作信息
    private String college_name;//大学名称
    private String resume_id;//数据库UUId。这个值是从mysql的数据到mongo时设置，从mongo的数据保存到mysql时的外键关联是用mongo的objectId。该字段基本不需要使用

    private String industry_field;//行业领域
    private String expert_type;//人才级别
    private String source_type;//区分外部人才是寻英还是高端人才，高端人才为1，寻英为2
    private String type;//统一字段为外部人才，目前定义为
    private String create_time;//创建时间
    private String source_code;//人才类型




    public String getSource_type() {
        return source_type;
    }

    public void setSource_type(String source_type) {
        this.source_type = source_type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLast_enterprise_name() {
        return last_enterprise_name;
    }

    public void setLast_enterprise_name(String last_enterprise_name) {
        this.last_enterprise_name = last_enterprise_name;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getLast_enterprise_industry() {
        return last_enterprise_industry;
    }

    public void setLast_enterprise_industry(String last_enterprise_industry) {
        this.last_enterprise_industry = last_enterprise_industry;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public String getSpecial_skills() {
        return special_skills;
    }

    public void setSpecial_skills(String special_skills) {
        this.special_skills = special_skills;
    }

    public String getLast_position_name() {
        return last_position_name;
    }

    public void setLast_position_name(String last_position_name) {
        this.last_position_name = last_position_name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getExpect_position() {
        return expect_position;
    }

    public void setExpect_position(String expect_position) {
        this.expect_position = expect_position;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public List<Award> getAwardList() {
        return awardList;
    }

    public void setAwardList(List<Award> awardList) {
        this.awardList = awardList;
    }

    public String getDrive_name() {
        return drive_name;
    }

    public void setDrive_name(String drive_name) {
        this.drive_name = drive_name;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getCareer_goal() {
        return career_goal;
    }

    public void setCareer_goal(String career_goal) {
        this.career_goal = career_goal;
    }

    public String getEnterprise_type() {
        return enterprise_type;
    }

    public void setEnterprise_type(String enterprise_type) {
        this.enterprise_type = enterprise_type;
    }

    public String getWork_status() {
        return work_status;
    }

    public void setWork_status(String work_status) {
        this.work_status = work_status;
    }

    public String getLiving() {
        return living;
    }

    public void setLiving(String living) {
        this.living = living;
    }

    public String getOsExperience() {
        return osExperience;
    }

    public void setOsExperience(String osExperience) {
        this.osExperience = osExperience;
    }

    public String getProfession_name() {
        return profession_name;
    }

    public void setProfession_name(String profession_name) {
        this.profession_name = profession_name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLast_year_salary() {
        return last_year_salary;
    }

    public void setLast_year_salary(String last_year_salary) {
        this.last_year_salary = last_year_salary;
    }

    public String getCv_id() {
        return cv_id;
    }

    public void setCv_id(String cv_id) {
        this.cv_id = cv_id;
    }

    public boolean isDimension_flag() {
        return dimension_flag;
    }

    public void setDimension_flag(boolean dimension_flag) {
        this.dimension_flag = dimension_flag;
    }

    public String getLast_enterprise_salary() {
        return last_enterprise_salary;
    }

    public void setLast_enterprise_salary(String last_enterprise_salary) {
        this.last_enterprise_salary = last_enterprise_salary;
    }

    public List<String> getVersion() {
        return version;
    }

    public void setVersion(List<String> version) {
        this.version = version;
    }

    public String getExpect_job_type() {
        return expect_job_type;
    }

    public void setExpect_job_type(String expect_job_type) {
        this.expect_job_type = expect_job_type;
    }

    public List<String> getKeyword_id() {
        return keyword_id;
    }

    public void setKeyword_id(List<String> keyword_id) {
        this.keyword_id = keyword_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Language> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public String getExpect_industry() {
        return expect_industry;
    }

    public void setExpect_industry(String expect_industry) {
        this.expect_industry = expect_industry;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getLast_enterprise_time() {
        return last_enterprise_time;
    }

    public void setLast_enterprise_time(String last_enterprise_time) {
        this.last_enterprise_time = last_enterprise_time;
    }

    public String getWork_year() {
        return work_year;
    }

    public void setWork_year(String work_year) {
        this.work_year = work_year;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<Train> getTrainList() {
        return trainList;
    }

    public void setTrainList(List<Train> trainList) {
        this.trainList = trainList;
    }

    public String getExpect_occupation() {
        return expect_occupation;
    }

    public void setExpect_occupation(String expect_occupation) {
        this.expect_occupation = expect_occupation;
    }

    public String getExpect_salary() {
        return expect_salary;
    }

    public void setExpect_salary(String expect_salary) {
        this.expect_salary = expect_salary;
    }

    public String getResume_keyword() {
        return resume_keyword;
    }

    public void setResume_keyword(String resume_keyword) {
        this.resume_keyword = resume_keyword;
    }

    public String getExpect_city() {
        return expect_city;
    }

    public void setExpect_city(String expect_city) {
        this.expect_city = expect_city;
    }

    public String getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(String starting_date) {
        this.starting_date = starting_date;
    }

    public String getResume_img() {
        return resume_img;
    }

    public void setResume_img(String resume_img) {
        this.resume_img = resume_img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelf_introduction() {
        return self_introduction;
    }

    public void setSelf_introduction(String self_introduction) {
        this.self_introduction = self_introduction;
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

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public List<SchoolPosition> getSchoolPositionList() {
        return schoolPositionList;
    }

    public void setSchoolPositionList(List<SchoolPosition> schoolPositionList) {
        this.schoolPositionList = schoolPositionList;
    }

    public List<String> getResumeUpdateTimeList() {
        return resumeUpdateTimeList;
    }

    public void setResumeUpdateTimeList(List<String> resumeUpdateTimeList) {
        this.resumeUpdateTimeList = resumeUpdateTimeList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Scholarship> getScholarshipList() {
        return scholarshipList;
    }

    public void setScholarshipList(List<Scholarship> scholarshipList) {
        this.scholarshipList = scholarshipList;
    }

    public String getCrawled_time() {
        return crawled_time;
    }

    public void setCrawled_time(String crawled_time) {
        this.crawled_time = crawled_time;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Certificate> getCertificateList() {
        return certificateList;
    }

    public void setCertificateList(List<Certificate> certificateList) {
        this.certificateList = certificateList;
    }

    public List<Social> getSocialList() {
        return socialList;
    }

    public void setSocialList(List<Social> socialList) {
        this.socialList = socialList;
    }

    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getResume_id() {
        return resume_id;
    }

    public void setResume_id(String resume_id) {
        this.resume_id = resume_id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource_code() {
        return source_code;
    }

    public void setSource_code(String source_code) {
        this.source_code = source_code;
    }
}
