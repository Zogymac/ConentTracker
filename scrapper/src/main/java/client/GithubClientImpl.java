package client;

import dto.CommitResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public class GithubClientImpl implements GitHubClient {
    private final WebClient webClient;

    public GithubClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.github.com").build();
    }


    @Override
    public List<CommitResponse> getCommits(String owner, String repo) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/repos/{owner}/{repo}/commits")
                        .build(owner, repo))
                .retrieve()
                .bodyToFlux(CommitResponse.class)
                .collectList()
                .block();
    }
}
