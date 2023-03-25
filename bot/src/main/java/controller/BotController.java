package controller;

import dto.LinkUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BotController {
    @PostMapping("/updates")
    public ResponseEntity<LinkUpdateRequest> handleUpdate(@RequestBody LinkUpdateRequest linkUpdateRequest) {
        return ResponseEntity.ok().build();
    }
}
