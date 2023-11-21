package com.example.myapplication.HomeScreen;

public class StudyGroup {
    private String title;
    private String studyTopic;

    public StudyGroup(String title, String studyTopic) {
        this.title = title;
        this.studyTopic = studyTopic;
    }

    public String getTitle() {
        return title;
    }

    public String getStudyTopic() {
        return studyTopic;
    }
}
