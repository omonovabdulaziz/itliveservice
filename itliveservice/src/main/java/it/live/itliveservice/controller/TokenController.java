package it.live.itliveservice.controller;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.Payload.GenerateDTO;
import it.live.itliveservice.service.GenerateTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/token")
@RequiredArgsConstructor
public class TokenController {
    private final GenerateTokenService generateTokenService;
    @PostMapping("/generate")
    public ResponseEntity<ApiResponse> generateToken(@Valid @RequestBody GenerateDTO generateDTO) {
        return generateTokenService.generateToken(generateDTO);
    }
}
