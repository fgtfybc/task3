package com.jnshu.pojo;

public class Module {
    private Long id;

    private String name;

    private Long node;

    private String url;

    private String creatby;

    private Long creatat;

    private String updateby;

    private Long updateat;

    public Module(Long id, String name, Long node, String url, String creatby, Long creatat, String updateby, Long updateat) {
        this.id = id;
        this.name = name;
        this.node = node;
        this.url = url;
        this.creatby = creatby;
        this.creatat = creatat;
        this.updateby = updateby;
        this.updateat = updateat;
    }

    public Module() {
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

    public Long getNode() {
        return node;
    }

    public void setNode(Long node) {
        this.node = node;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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