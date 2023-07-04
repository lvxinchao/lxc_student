package com.system.po;

public class Student {

    private String id;
    private String sName;
    private String password;
    private String sex;
    private String major;
    private String collage;
    private String type;

    public Student() {

    }
    public Student( String id,String sName,String sex,String major,String collage) {
        super();
        this.id = id;
        this.sName = sName;
//        this.password = password;
        this.sex = sex;
        this.major = major;
        this.collage = collage;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", sName='" + sName + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", major='" + major + '\'' +
                ", collage='" + collage + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
