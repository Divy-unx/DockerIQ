package com.divyanshu.dockeriq.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.divyanshu.dockeriq.model.DockerInstruction;
import com.divyanshu.dockeriq.model.Recommendation;
import com.divyanshu.dockeriq.parser.DockerfileParser;
import com.divyanshu.dockeriq.rules.Rule;

@Service
public class DockerAnalysisService {

    private final DockerfileParser parser;
    private final List<Rule> rules;

    public DockerAnalysisService(DockerfileParser parser,
                                 List<Rule> rules) {
        this.parser = parser;
        this.rules = rules;
    }

    public List<Recommendation> analyze(String dockerfileContent) {

        List<DockerInstruction> instructions = parser.parse(dockerfileContent);

        List<Recommendation> recommendations = new ArrayList<>();

        for (Rule rule : rules) {

            Recommendation recommendation = rule.check(instructions);

            if (recommendation != null) {
                recommendations.add(recommendation);
            }
        }

        return recommendations;
    }
}