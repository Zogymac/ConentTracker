package client;

import dto.QuestionResponse;
import org.springframework.web.reactive.function.client.WebClient;


public class StackOverflowClientImpl implements StackOverflowClient {
    private final WebClient webClient;

    public StackOverflowClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.stackexchange.com/2.3").build();
    }

    @Override
    public QuestionResponse getQuestion(long questionId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/questions/{questionId}")
                        .queryParam("site", "stackoverflow")
                        .build(questionId))
                .retrieve()
                .bodyToMono(QuestionResponse.class)
                .block();
    }

}
