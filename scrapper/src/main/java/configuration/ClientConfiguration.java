package configuration;

import client.GitHubClient;
import client.GithubClientImpl;
import client.StackOverflowClient;
import client.StackOverflowClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfiguration {
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public GitHubClient gitHubClient(WebClient.Builder webClientBuilder) {
        return new GithubClientImpl(webClientBuilder);
    }

    @Bean
    public StackOverflowClient stackOverflowClient(WebClient.Builder webClientBuilder) {
        return new StackOverflowClientImpl(webClientBuilder);
    }
}
