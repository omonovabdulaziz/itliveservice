package it.live.itliveservice.service.impl;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.Payload.GenerateDTO;
import it.live.itliveservice.entity.User;
import it.live.itliveservice.jwt.JwtProvider;
import it.live.itliveservice.repository.UserRepository;
import it.live.itliveservice.service.GenerateTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenerateTokenServiceImpl implements GenerateTokenService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public ResponseEntity<ApiResponse> generateToken(GenerateDTO generateDTO) {
        User user = userRepository.findByName(generateDTO.getName()).orElseThrow(() -> new RuntimeException("Forbidden"));
        if (!passwordEncoder.matches(generateDTO.getPassword(), user.getPassword()))
            throw new RuntimeException("Forbidden");
        return ResponseEntity.ok(ApiResponse.builder().message("Ok").status(200).object(jwtProvider.generateToken(user)).build());
    }
}
