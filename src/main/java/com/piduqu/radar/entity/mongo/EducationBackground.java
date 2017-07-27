package com.piduqu.radar.entity.mongo;


/**
 * 教育经历
 * Created by jiangwei on 2016/4/12 0012.
 */
public class EducationBackground {
    private String id;
    private String schoolName;
    private String start;
    private String end;
    private String major;
    private String level;


    public enum EducationalLevel {
        BACHELOR("本科", 50), MASTER("硕士", 60), PHD("博士", 70), COLLEGE("专科", 40), JUNIOR_TECH("中技", 30), POLYTECHNIC("中专", 20), UNDER_HIGH_SCHOOL("高中以下", 10);

        private final String presentation;
        private final int level;

        public String getPresentation() {
            return presentation;
        }

        public int getLevel() {
            return level;
        }

        EducationalLevel(String presentation, int level) {
            this.presentation = presentation;
            this.level = level;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
