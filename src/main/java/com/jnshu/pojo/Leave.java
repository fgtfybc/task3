package com.jnshu.pojo;

public class Leave {
    private Long id;

    private String creatby;

    private Long creatat;

    private String updateby;

    private Long updateat;

    private String content;

    public Leave(Long id, String creatby, Long creatat, String updateby, Long updateat, String content) {
        this.id = id;
        this.creatby = creatby;
        this.creatat = creatat;
        this.updateby = updateby;
        this.updateat = updateat;
        this.content = content;
    }

    public Leave() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}