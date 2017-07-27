package com.piduqu.radar.entity.mongo;

/**
 * 专业技能
 * Created by jiangwei on 2016/4/25 0025.
 */
public class Skill {
    
    private String skill_name;//技能名称
    private String skill_degree ;//技能程度
    private String skill_time;//使用时间长度

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getSkill_degree() {
        return skill_degree;
    }

    public void setSkill_degree(String skill_degree) {
        this.skill_degree = skill_degree;
    }

    public String getSkill_time() {
        return skill_time;
    }

    public void setSkill_time(String skill_time) {
        this.skill_time = skill_time;
    }
}
