package client;

import dto.CommitResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GitHubClient {
    @GetMapping("/repos/{owner}/{repo}/commits")
    List<CommitResponse> getCommits(@PathVariable("owner") String owner,
                                    @PathVariable("repo") String repo);
}
