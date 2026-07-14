package com.divyanshu.dockeriq.model;

import java.util.List;

public class AnalysisResult {

    private int score;
    private String riskLevel;
    private int instructionCount;
    private List<Recommendation> recommendations;

    public AnalysisResult() {
    }

    public AnalysisResult(int score,
                          String riskLevel,
                          int instructionCount,
                          List<Recommendation> recommendations) {
        this.score = score;
        this.riskLevel = riskLevel;
        this.instructionCount = instructionCount;
        this.recommendations = recommendations;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public int getInstructionCount() {
        return instructionCount;
    }

    public void setInstructionCount(int instructionCount) {
        this.instructionCount = instructionCount;
    }

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }
}