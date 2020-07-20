package com.jnshu.pojo;

public class Reply {
    private Long id;

    private String name;

    private String reply;

    private String createby;

    private Long createat;

    private String updateby;

    private Long updateat;

    public Reply(Long id, String name, String reply, String createby, Long createat, String updateby, Long updateat) {
        this.id = id;
        this.name = name;
        this.reply = reply;
        this.createby = createby;
        this.createat = createat;
        this.updateby = updateby;
        this.updateat = updateat;
    }

    public Reply() {
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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public Long getCreateat() {
        return createat;
    }

    public void setCreateat(Long createat) {
        this.createat = createat;
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