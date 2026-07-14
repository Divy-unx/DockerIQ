package com.divyanshu.dockeriq.model;

import java.util.List;

public class AnalysisResult {

    private int score;
    private int totalInstructions;
    private List<Recommendation> recommendations;

    public AnalysisResult() {
    }

    public AnalysisResult(int score,
                          int totalInstructions,
                          List<Recommendation> recommendations) {
        this.score = score;
        this.totalInstructions = totalInstructions;
        this.recommendations = recommendations;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalInstructions() {
        return totalInstructions;
    }

    public void setTotalInstructions(int totalInstructions) {
        this.totalInstructions = totalInstructions;
    }

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }
}