import java.net.URI;

public record GithubLink(String username, String repository) implements Link {
    public GithubLink {
        if (username == null || repository == null) {
            throw new IllegalArgumentException("Username and repository cannot be null");
        }
    }

    public static GithubLink parseGithubLink(URI uri) {
        if (uri.getHost() == null) {
            return null;
        }
        if (!uri.getHost().equals("github.com")) {
            return null;
        }

        String[] pathSegments = uri.getPath().split("/");
        if (pathSegments.length < 3) {
            return null;
        }

        String username = pathSegments[1];
        String repository = pathSegments[2];
        return new GithubLink(username, repository);
    }


}