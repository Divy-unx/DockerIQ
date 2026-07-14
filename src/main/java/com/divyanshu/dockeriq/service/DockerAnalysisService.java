package com.divyanshu.dockeriq.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.divyanshu.dockeriq.model.AnalysisResult;
import com.divyanshu.dockeriq.model.DockerInstruction;
import com.divyanshu.dockeriq.model.Recommendation;
import com.divyanshu.dockeriq.parser.DockerfileParser;
import com.divyanshu.dockeriq.rules.Rule;

@Service
public class DockerAnalysisService {

    private final DockerfileParser parser;
    private final List<Rule> rules;
    private final ScoreCalculator scoreCalculator;

    public DockerAnalysisService(
            DockerfileParser parser,
            List<Rule> rules,
            ScoreCalculator scoreCalculator) {

        this.parser = parser;
        this.rules = rules;
        this.scoreCalculator = scoreCalculator;
    }

    public AnalysisResult analyze(String dockerfileContent) {

        List<DockerInstruction> instructions = parser.parse(dockerfileContent);

        List<Recommendation> recommendations = new ArrayList<>();

    for (Rule rule : rules) {

        List<Recommendation> ruleRecommendations = rule.check(instructions);

        recommendations.addAll(ruleRecommendations);

    }

        int score = scoreCalculator.calculate(recommendations);

        String riskLevel = calculateRiskLevel(score);

        return new AnalysisResult(
                score,
                riskLevel,
                instructions.size(),
                recommendations
        );
    }

    private String calculateRiskLevel(int score) {

        if (score >= 90) {
            return "LOW";
        }

        if (score >= 70) {
            return "MEDIUM";
        }

        return "HIGH";
    }
}