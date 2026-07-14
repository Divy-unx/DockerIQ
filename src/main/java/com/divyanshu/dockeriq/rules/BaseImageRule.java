package com.divyanshu.dockeriq.rules;

import java.util.List;

import org.springframework.stereotype.Component;

import com.divyanshu.dockeriq.model.DockerInstruction;
import com.divyanshu.dockeriq.model.Recommendation;

@Component
public class BaseImageRule implements Rule {

    @Override
    public Recommendation check(List<DockerInstruction> instructions) {

        for (DockerInstruction instruction : instructions) {

            if ("FROM".equalsIgnoreCase(instruction.getInstruction())) {

                String image = instruction.getValue();

                if (image.startsWith("ubuntu")) {

                    return new Recommendation(
                            "Large Base Image",
                            "MEDIUM",
                            "Ubuntu images are larger than necessary for Java applications.",
                            "Use eclipse-temurin:21-jre instead."
                    );
                }
            }
        }

        return null;
    }
}