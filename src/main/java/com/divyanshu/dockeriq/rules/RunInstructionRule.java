package com.divyanshu.dockeriq.rules;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.divyanshu.dockeriq.model.DockerInstruction;
import com.divyanshu.dockeriq.model.Recommendation;
import com.divyanshu.dockeriq.model.Severity;

@Component
public class RunInstructionRule implements Rule {

    @Override
    public List<Recommendation> check(List<DockerInstruction> instructions) {

        List<Recommendation> recommendations = new ArrayList<>();

        int runCount = 0;

        for (DockerInstruction instruction : instructions) {

            if ("RUN".equalsIgnoreCase(instruction.getInstruction())) {
                runCount++;
            }
        }

        if (runCount > 1) {

            recommendations.add(
                    new Recommendation(
                            "Multiple RUN Instructions",
                            Severity.LOW,
                            "Multiple RUN instructions create additional image layers and may increase image size.",
                            "Combine related RUN instructions to improve build efficiency and reduce image layers."
                    )
            );
        }

        return recommendations;
    }
}