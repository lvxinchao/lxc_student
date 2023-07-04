package com.system.po;

public class Course {

    private String cId;
    private String cName;
    private String cTeacher;

    public Course() {

    }
    public Course( String cId,String cName,String cTeacher) {
        super();
        this.cId = cId;
        this.cName = cName;
        this.cTeacher = cTeacher;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcTeacher() {
        return cTeacher;
    }

    public void setcTeacher(String cTeacher) {
        this.cTeacher = cTeacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cId='" + cId + '\'' +
                ", cName='" + cName + '\'' +
                ", cTeacher='" + cTeacher + '\'' +
                '}';
    }
}
