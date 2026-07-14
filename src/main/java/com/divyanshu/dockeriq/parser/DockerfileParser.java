package com.divyanshu.dockeriq.parser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.divyanshu.dockeriq.model.DockerInstruction;

@Component
public class DockerfileParser {

    public List<DockerInstruction> parse(String dockerfileContent) {

        List<DockerInstruction> instructions = new ArrayList<>();

        String[] lines = dockerfileContent.split("\n");

        for (String line : lines) {

            line = line.trim();

            if (line.isEmpty()) {
                continue;
            }

            int firstSpace = line.indexOf(" ");

            if (firstSpace == -1) {
                continue;
            }

            String instruction = line.substring(0, firstSpace);

            String value = line.substring(firstSpace + 1);

            instructions.add(new DockerInstruction(instruction, value));

        }

        return instructions;
    }
}