package it.live.itliveservice.Payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeServiceDTO {
    private Long serviceId;
    private Integer beginPrice;
    private Integer lastPrice;
}
