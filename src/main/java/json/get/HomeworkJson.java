package json.get;


import json.BaseJson;

public class HomeworkJson extends BaseJson {
    private String assignment;
    private String dateDue;
    private String courseName;

    public void setAssignment(String assignment){this.assignment = assignment;}
    public void setDateDue(String dateDue){this.dateDue = dateDue;}
    public void setCourseName(String courseName){this.courseName = courseName;}
}
