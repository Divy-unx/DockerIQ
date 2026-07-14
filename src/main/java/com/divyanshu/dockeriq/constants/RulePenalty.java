package com.divyanshu.dockeriq.constants;

public final class RulePenalty {

    private RulePenalty() {
        // Prevent instantiation
    }

    public static final int BASE_IMAGE = 10;

    public static final int ROOT_USER = 15;

    public static final int MISSING_HEALTHCHECK = 5;

    public static final int MULTIPLE_RUN = 5;

    public static final int MISSING_DOCKERIGNORE = 5;
}