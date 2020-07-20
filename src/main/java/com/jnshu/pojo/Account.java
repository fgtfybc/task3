package com.jnshu.pojo;

public class Account {
    private Long id;

    private String name;

    private String pwd;

    private String role;

    private String creatby;

    private Long creatat;

    private String updateby;

    private Long updateat;

    public Account(Long id, String name, String pwd, String role, String creatby, Long creatat, String updateby, Long updateat) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.role = role;
        this.creatby = creatby;
        this.creatat = creatat;
        this.updateby = updateby;
        this.updateat = updateat;
    }

    public Account() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getCreatby() {
        return creatby;
    }

    public void setCreatby(String creatby) {
        this.creatby = creatby == null ? null : creatby.trim();
    }

    public Long getCreatat() {
        return creatat;
    }

    public void setCreatat(Long creatat) {
        this.creatat = creatat;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }

    public Long getUpdateat() {
        return updateat;
    }

    public void setUpdateat(Long updateat) {
        this.updateat = updateat;
    }
}