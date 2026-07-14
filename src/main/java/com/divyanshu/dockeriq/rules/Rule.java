package com.divyanshu.dockeriq.rules;

import java.util.List;

import com.divyanshu.dockeriq.model.DockerInstruction;
import com.divyanshu.dockeriq.model.Recommendation;

public interface Rule {

    List<Recommendation> check(List<DockerInstruction> instructions);

}