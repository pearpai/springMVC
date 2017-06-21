package com.bq.entity;

public class UserInfo {
    private Integer id;

    private String userid;

    private String nickname;

    private String phoneno;

    private String password;

    private String historypassword;

    private String email;

    private String tbuserid;

    private String tbpassword;

    private String headpic;

    private Byte gender;

    private Byte platform;

    private Byte level;

    private String signature;

    private Integer fanscount;

    private Integer attentioncount;

    private Integer friendscount;

    private Byte status;

    private String rytoken;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno == null ? null : phoneno.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHistorypassword() {
        return historypassword;
    }

    public void setHistorypassword(String historypassword) {
        this.historypassword = historypassword == null ? null : historypassword.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTbuserid() {
        return tbuserid;
    }

    public void setTbuserid(String tbuserid) {
        this.tbuserid = tbuserid == null ? null : tbuserid.trim();
    }

    public String getTbpassword() {
        return tbpassword;
    }

    public void setTbpassword(String tbpassword) {
        this.tbpassword = tbpassword == null ? null : tbpassword.trim();
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic == null ? null : headpic.trim();
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Byte getPlatform() {
        return platform;
    }

    public void setPlatform(Byte platform) {
        this.platform = platform;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public Integer getFanscount() {
        return fanscount;
    }

    public void setFanscount(Integer fanscount) {
        this.fanscount = fanscount;
    }

    public Integer getAttentioncount() {
        return attentioncount;
    }

    public void setAttentioncount(Integer attentioncount) {
        this.attentioncount = attentioncount;
    }

    public Integer getFriendscount() {
        return friendscount;
    }

    public void setFriendscount(Integer friendscount) {
        this.friendscount = friendscount;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRytoken() {
        return rytoken;
    }

    public void setRytoken(String rytoken) {
        this.rytoken = rytoken == null ? null : rytoken.trim();
    }
}