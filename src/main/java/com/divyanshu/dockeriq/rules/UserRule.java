package com.divyanshu.dockeriq.rules;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.divyanshu.dockeriq.model.DockerInstruction;
import com.divyanshu.dockeriq.model.Recommendation;
import com.divyanshu.dockeriq.model.Severity;

@Component
public class UserRule implements Rule {

    @Override
    public List<Recommendation> check(List<DockerInstruction> instructions) {

        List<Recommendation> recommendations = new ArrayList<>();

        String currentUser = null;

        for (DockerInstruction instruction : instructions) {

            if ("USER".equalsIgnoreCase(instruction.getInstruction())) {
                currentUser = instruction.getValue().trim();
            }
        }

        if (currentUser == null) {

            recommendations.add(
                    new Recommendation(
                            "Missing USER Instruction",
                            Severity.HIGH,
                            "No USER instruction was found. The container runs as root by default.",
                            "Create a non-root user and switch using the USER instruction."
                    )
            );

            return recommendations;
        }

        if ("root".equalsIgnoreCase(currentUser)) {

            recommendations.add(
                    new Recommendation(
                            "Container Running as Root",
                            Severity.HIGH,
                            "The Dockerfile explicitly sets the container user to root.",
                            "Create a non-root user and switch using the USER instruction."
                    )
            );
        }

        return recommendations;
    }
}