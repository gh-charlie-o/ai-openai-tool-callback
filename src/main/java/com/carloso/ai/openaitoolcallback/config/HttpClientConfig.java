package com.carloso.ai.openaitoolcallback.config;

import com.carloso.ai.openaitoolcallback.client.AlphavantageHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpClientConfig {
    @Bean
    public AlphavantageHttpClient buildAlphavantageHttpClient(@Value("${app.alphavantage.base-url}") String baseUrl){
        final RestClient restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();

        final HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();

        return factory.createClient(AlphavantageHttpClient.class);
    }
}
