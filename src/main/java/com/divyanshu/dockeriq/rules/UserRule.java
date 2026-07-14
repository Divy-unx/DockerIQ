package com.divyanshu.dockeriq.rules;

import com.divyanshu.dockeriq.constants.RulePenalty;
import com.divyanshu.dockeriq.model.DockerInstruction;
import com.divyanshu.dockeriq.model.Recommendation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRule implements Rule {

    @Override
    public List<Recommendation> check(List<DockerInstruction> instructions) {

        List<Recommendation> recommendations = new ArrayList<>();

        String currentUser = null;

        // Docker follows the last USER instruction
        for (DockerInstruction instruction : instructions) {

            if ("USER".equalsIgnoreCase(instruction.getInstruction())) {
                currentUser = instruction.getValue().trim();
            }
        }

        // No USER instruction found
        if (currentUser == null) {

            recommendations.add(
                    new Recommendation(
                            "Missing USER Instruction",
                            "HIGH",
                            "No USER instruction was found. The container runs as root by default.",
                            "Create a non-root user and switch using the USER instruction.",
                            RulePenalty.ROOT_USER
                    )
            );

            return recommendations;
        }

        // USER root
        if ("root".equalsIgnoreCase(currentUser)) {

            recommendations.add(
                    new Recommendation(
                            "Container Running as Root",
                            "HIGH",
                            "The Dockerfile explicitly sets the container user to root.",
                            "Create a non-root user and switch using the USER instruction.",
                            RulePenalty.ROOT_USER
                    )
            );
        }

        return recommendations;
    }
}