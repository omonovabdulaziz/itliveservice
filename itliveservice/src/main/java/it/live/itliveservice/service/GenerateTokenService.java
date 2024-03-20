package it.live.itliveservice.service;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.Payload.GenerateDTO;
import org.springframework.http.ResponseEntity;

public interface GenerateTokenService {
    ResponseEntity<ApiResponse> generateToken(GenerateDTO generateDTO);
}
