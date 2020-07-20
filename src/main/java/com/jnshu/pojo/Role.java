package com.jnshu.pojo;

public class Role {
    private Long id;

    private String name;

    private String jur;

    private String creatby;

    private Long creatat;

    private String updateby;

    private Long updateat;

    public Role(Long id, String name, String jur, String creatby, Long creatat, String updateby, Long updateat) {
        this.id = id;
        this.name = name;
        this.jur = jur;
        this.creatby = creatby;
        this.creatat = creatat;
        this.updateby = updateby;
        this.updateat = updateat;
    }

    public Role() {
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

    public String getJur() {
        return jur;
    }

    public void setJur(String jur) {
        this.jur = jur == null ? null : jur.trim();
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