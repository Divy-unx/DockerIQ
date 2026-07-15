package com.divyanshu.dockeriq.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.divyanshu.dockeriq.model.Recommendation;
import com.divyanshu.dockeriq.model.Severity;

@Component
public class ScoreCalculator {

    public int calculate(List<Recommendation> recommendations) {

        int score = 100;

        for (Recommendation recommendation : recommendations) {

            Severity severity = recommendation.getSeverity();

            switch (severity) {

                case LOW -> score -= 5;

                case MEDIUM -> score -= 10;

                case HIGH -> score -= 15;

                case CRITICAL -> score -= 25;
            }
        }

        return Math.max(score, 0);
    }
}