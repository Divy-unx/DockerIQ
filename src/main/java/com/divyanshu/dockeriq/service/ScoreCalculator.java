package com.divyanshu.dockeriq.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.divyanshu.dockeriq.model.Recommendation;

@Component
public class ScoreCalculator {

    public int calculate(List<Recommendation> recommendations) {

        int score = 100;

        for (Recommendation recommendation : recommendations) {
            score -= recommendation.getPenalty();
        }

        return Math.max(score, 0);
    }
}