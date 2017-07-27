package com.piduqu.radar.entity.mongo;

/**
 * Created by jiangwei on 2016/4/19 0019.
 */
public class ProjectExperience {

    private String id;
    private String projectName;//项目名称
    private String projectDesc;//项目描述
    private String projectDuty;//担任职责
    private String start;//开始时间
    private String end;//结束时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getProjectDuty() {
        return projectDuty;
    }

    public void setProjectDuty(String projectDuty) {
        this.projectDuty = projectDuty;
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
}
