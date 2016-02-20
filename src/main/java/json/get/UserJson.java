package json.get;

import json.BaseJson;

@SuppressWarnings("unused")
public class UserJson extends BaseJson {
    private String firstName;
    private String lastName;
    private int age;
    private int gradeLevel;
    private String major;
    private String schoolName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}