package it.live.itliveservice.service;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.Payload.TypeServiceDTO;
import it.live.itliveservice.entity.TypeService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TypeServiceService {
    List<TypeService> getAll();

    ResponseEntity<ApiResponse> add(TypeServiceDTO typeServiceDTO);

    ResponseEntity<ApiResponse> delete(Long id);

    List<TypeService> getByServiceId(Long serviceid);

}
