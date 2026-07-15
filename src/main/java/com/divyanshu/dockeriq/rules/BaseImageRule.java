package com.divyanshu.dockeriq.rules;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.divyanshu.dockeriq.model.DockerInstruction;
import com.divyanshu.dockeriq.model.Recommendation;
import com.divyanshu.dockeriq.model.Severity;

@Component
public class BaseImageRule implements Rule {

    @Override
    public List<Recommendation> check(List<DockerInstruction> instructions) {

        List<Recommendation> recommendations = new ArrayList<>();

        for (DockerInstruction instruction : instructions) {

            if ("FROM".equalsIgnoreCase(instruction.getInstruction())) {

                String image = instruction.getValue();

                if (image.startsWith("ubuntu")) {

                    recommendations.add(
                            new Recommendation(
                            "Large Base Image",
                            Severity.MEDIUM,
                            "Ubuntu images are larger than necessary for Java applications.",
                            "Use eclipse-temurin:21-jre instead."
)
                    );
                }
            }
        }

        return recommendations;
    }
}