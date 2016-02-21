package json.get;


import json.BaseJson;

public class HomeworkReplyJson extends BaseJson{
    private String commentContent;
    private String commentTime;
    private String firstName;
    private String lastName;
    private boolean status;
    private int score;
    private String homework;

    public void setCommentContent(String commentContent){this.commentContent = commentContent;}
    public void setCommentTime(String commentTime){this.commentTime = commentTime;}
    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void setStatus(boolean status){this.status = status;}
    public void setScore(int score){this.score = score;}
    public void setHomework(String homework){this.homework = homework;}
}
