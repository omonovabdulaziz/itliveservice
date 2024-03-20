package it.live.itliveservice.Payload;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenerateDTO {
    @NotNull(message = "name")
    private String name;
    @NotNull(message = "password")
    private String password;
}
