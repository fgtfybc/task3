package com.jnshu.pojo;

public class Banner {
    private Long id;

    private String url;

    private String img;

    private String creatby;

    private Long creatat;

    private String updateby;

    private Long updateat;

    public Banner(Long id, String url, String img, String creatby, Long creatat, String updateby, Long updateat) {
        this.id = id;
        this.url = url;
        this.img = img;
        this.creatby = creatby;
        this.creatat = creatat;
        this.updateby = updateby;
        this.updateat = updateat;
    }

    public Banner() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
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