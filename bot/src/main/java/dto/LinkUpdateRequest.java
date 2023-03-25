package dto;

import java.util.List;

public class LinkUpdateRequest {
    private Long id;
    private String url;
    private String description;
    private List<Long> thChatIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getThChatIds() {
        return thChatIds;
    }

    public void setThChatIds(List<Long> thChatIds) {
        this.thChatIds = thChatIds;
    }
}
