package client;

import dto.QuestionResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface StackOverflowClient {
    @GetMapping("/questions/{questionId}")
    QuestionResponse getQuestion(@PathVariable("questionId") long questionId);
}
