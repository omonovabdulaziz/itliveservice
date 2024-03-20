package it.live.itliveservice.config;

import it.live.itliveservice.entity.User;
import it.live.itliveservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class DataLoaderConfig implements CommandLineRunner {
    @Value("${spring.sql.init.mode}")
    private String sqlInitMode;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (Objects.equals(sqlInitMode, "always")) {
            userRepository.save(User.builder().name("ADMIN").password(passwordEncoder.encode("admin")).build());
        }
    }
}