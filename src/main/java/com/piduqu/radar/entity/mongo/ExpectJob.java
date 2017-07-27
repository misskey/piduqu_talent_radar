package com.piduqu.radar.entity.mongo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangwei on 2016/4/12 0012.
 */
public class ExpectJob {


    private List<Address> Location=new ArrayList<>();//
    private String salary;
    private String  jobPosition;
    private String industry;



    private String type;

    public List<Address> getLocation() {
        return Location;
    }

    public void setLocation(List<Address> location) {
        Location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
