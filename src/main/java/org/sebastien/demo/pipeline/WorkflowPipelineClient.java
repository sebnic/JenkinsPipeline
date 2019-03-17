package org.sebastien.demo.pipeline;

import org.sebastien.demo.pipeline.model.WorkflowBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WorkflowPipelineClient {

    @Autowired
    private RestTemplate restTemplate;

    public void launchNewBuild(String jobName,String branchName) {
        String url = getRootUrl(jobName, branchName) + "/build";
        restTemplate.postForObject(url, null, Void.class);
    }

    public String getLastBuildStatus(String jobName, String branchName) {
     String url = getRootUrl(jobName, branchName) + "/wfapi/runs";
     WorkflowBuild[] workflowBuilds = restTemplate.getForObject(url, WorkflowBuild[].class);
     return workflowBuilds[0].getStatus();
    }

    private String getRootUrl(String jobName, String branchName) {
        return "/job/" + jobName + "/job/" + branchName;
    }
}
