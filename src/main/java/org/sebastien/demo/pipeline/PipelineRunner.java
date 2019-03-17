package org.sebastien.demo.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PipelineRunner implements CommandLineRunner {

    @Autowired
    private WorkflowPipelineClient workflowPipelineClient;

    @Override
    public void run(String... args) throws Exception {
        // workflowPipelineClient.launchNewBuild("Test", "master");
        System.out.println(workflowPipelineClient.getLastBuildStatus("Test", "master"));
    }
}
