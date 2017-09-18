package com.xiaoyb.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Integer age;

    private Date birthday;

    private String password;

    private List<Role> roleList;// 一个用户具有多个角色

    // 获取用户所有权限的权限名
    public Set<String> getRolesName() {
        List<Role> roles = this.getRoleList();
        Set<String> set = new HashSet<String>();
        for (Role role : roles) {
            set.add(role.getRolename());
        }
        return set;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String toString() {
        return this.name + ", " + this.age + ", " + this.birthday + ", " + this.password;
    }
}