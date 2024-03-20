package it.live.itliveservice.controller;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.CommunicateMessage;
import it.live.itliveservice.service.CommunicateMessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/communicate-message")
@RequiredArgsConstructor
public class CommunicateMessageController {
    private final CommunicateMessageService service;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/get-all")
    public Page<CommunicateMessage> getAll(@RequestParam int page, @RequestParam int size) {
        return service.getAll(page, size);
    }


    @PostMapping("/add")
    public ResponseEntity<ApiResponse> add(@Valid @RequestBody CommunicateMessage communicateMessage) {
        return service.add(communicateMessage);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        return service.delete(id);
    }

}
