package com.divyanshu.dockeriq.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divyanshu.dockeriq.model.AnalysisResult;
import com.divyanshu.dockeriq.service.DockerAnalysisService;

@RestController
@RequestMapping("/api")
public class AnalyzeController {

    private final DockerAnalysisService service;

    public AnalyzeController(DockerAnalysisService service) {
        this.service = service;
    }

    @PostMapping("/analyze")
    public AnalysisResult analyze(@RequestBody String dockerfile) {
        return service.analyze(dockerfile);
    }
}