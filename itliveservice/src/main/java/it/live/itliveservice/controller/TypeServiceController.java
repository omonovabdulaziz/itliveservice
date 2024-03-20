package it.live.itliveservice.controller;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.Payload.TypeServiceDTO;
import it.live.itliveservice.entity.Service;
import it.live.itliveservice.entity.TypeService;
import it.live.itliveservice.service.TypeServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/type-service")
@RequiredArgsConstructor
public class TypeServiceController {
    private final TypeServiceService service;

    @GetMapping("/get-by-serviceId")
    public List<TypeService> getByServiceId(@RequestParam Long serviceid){
        return service.getByServiceId(serviceid);
    }

    @GetMapping("/get-all")
    public List<TypeService> getAll() {
        return service.getAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> add(@RequestBody TypeServiceDTO typeServiceDTO) {
        return service.add(typeServiceDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        return service.delete(id);
    }

}
