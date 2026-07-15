package com.divyanshu.dockeriq.rules;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.divyanshu.dockeriq.model.DockerInstruction;
import com.divyanshu.dockeriq.model.Recommendation;
import com.divyanshu.dockeriq.model.Severity;

@Component
public class HealthCheckRule implements Rule {

    @Override
    public List<Recommendation> check(List<DockerInstruction> instructions) {

        List<Recommendation> recommendations = new ArrayList<>();

        boolean hasHealthCheck = instructions.stream()
                .anyMatch(i -> "HEALTHCHECK".equalsIgnoreCase(i.getInstruction()));

        if (!hasHealthCheck) {

            recommendations.add(
                    new Recommendation(
                            "Missing HEALTHCHECK Instruction",
                            Severity.MEDIUM,
                            "No HEALTHCHECK instruction was found. Docker cannot determine whether the container is healthy.",
                            "Add a HEALTHCHECK instruction to monitor your application."
                    )
            );
        }

        return recommendations;
    }
}