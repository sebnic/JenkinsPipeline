package org.sebastien.demo.pipeline;

import org.sebastien.demo.pipeline.model.DefaultCrumbIssuer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PipelineConfiguration {

    @Bean
    public RestTemplate workFlowPipelineRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder.rootUri("http://172.17.0.2:8080")
                                  .additionalInterceptors(new BasicAuthenticationInterceptor("Admin", "f9e0c466f0e3413c88c0dcc53ca97806"))
                                  .build();
        DefaultCrumbIssuer defaultCrumbIssuer = restTemplate.getForObject("/crumbIssuer/api/json", DefaultCrumbIssuer.class);
        ClientHttpRequestInterceptor crumbHttpRequestInterceptor = createCrumbHttpRequestInteceptor(defaultCrumbIssuer.getCrumbRequestField(), defaultCrumbIssuer.getCrumb());
        restTemplate.getInterceptors().add(crumbHttpRequestInterceptor);
        return restTemplate;
    }

    private ClientHttpRequestInterceptor createCrumbHttpRequestInteceptor(String crumbField, String crumb) {
        return (httpRequest, body, clientHttpRequestExecution) -> {
            httpRequest.getHeaders().add(crumbField, crumb);
            return clientHttpRequestExecution.execute(httpRequest, body);
        };
    }
}
