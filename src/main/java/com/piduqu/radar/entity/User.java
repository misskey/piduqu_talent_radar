package com.piduqu.radar.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.piduqu.radar.entity.support.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author 无聊的挂面
 * @since 2017-07-11 14:49
 */
@Entity
@Table(name = "t_user")
public class User extends BaseEntity{

    private static final long serialVersionUID = -1894163644285296213L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String userName;

    private String nickName;

    private String password;

    private String userEmail;

    private Integer userStatus;

    private Integer isFirst;

    private String orgId;
    private String pID;

    private String isAdmin;

    private String nickId;//层级id

    private String parentId;//父级的层级id

    private String avatar_url;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ManyToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinTable(name = "t_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private java.util.Set<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(Integer isFirst) {
        this.isFirst = isFirst;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getNickId() {
        return nickId;
    }

    public void setNickId(String nickId) {
        this.nickId = nickId;
    }
}
