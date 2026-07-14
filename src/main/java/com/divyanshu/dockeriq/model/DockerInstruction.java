package com.divyanshu.dockeriq.model;

public class DockerInstruction {

    private String instruction;

    private String value;

    public DockerInstruction() {
    }

    public DockerInstruction(String instruction, String value) {
        this.instruction = instruction;
        this.value = value;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}