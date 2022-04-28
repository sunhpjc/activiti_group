package com.sunhp.activiti.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author sunhp
 * @since 2021-10-25 13:46:37
 */
public class User implements Serializable {
    private static final long serialVersionUID = 581443032723786585L;
    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private String realname;
    
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}