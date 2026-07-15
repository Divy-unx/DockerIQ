package com.divyanshu.dockeriq.model;

public class Recommendation {

    private String title;

    private Severity severity;

    private String description;

    private String recommendation;


    public Recommendation() {
    }

    public Recommendation(
        String title,
        Severity severity,
        String description,
        String recommendation) {

    this.title = title;
    this.severity = severity;
    this.description = description;
    this.recommendation = recommendation;
}

    public Severity getSeverity() {
    return severity;
}

    public void setSeverity(Severity severity) {
    this.severity = severity;
} 

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}