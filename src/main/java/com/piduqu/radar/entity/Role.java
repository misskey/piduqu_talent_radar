package com.piduqu.radar.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.piduqu.radar.entity.support.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author 无聊的挂面
 * @since 2017-07-11 15:12
 */
@Entity
@Table(name = "t_role")
public class Role extends BaseEntity {

    private static final long serialVersionUID = -1894166644285296223L;
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String name;

    private String roleKey;

    private Integer status;

    private String description;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ManyToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinTable(name = "t_role_function", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = { @JoinColumn(name = "function_id") })
    private java.util.Set<Function> functions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Set<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(Set<Function> functions) {
        this.functions = functions;
    }
}
