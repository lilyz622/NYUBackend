package json.get;


import json.BaseJson;

public class HomeworkJson extends BaseJson {
    private String description;
    private String dateDue;
    private String timeDue;
    private String courseName;

    public void setAssignment(String description){this.description = description;}
    public void setTimeDue(String timeDue){this.timeDue = timeDue;}
    public void setDateDue(String dateDue){this.dateDue = dateDue;}
    public void setCourseName(String courseName){this.courseName = courseName;}
}
