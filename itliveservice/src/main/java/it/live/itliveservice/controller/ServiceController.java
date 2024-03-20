package it.live.itliveservice.controller;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.FutureNews;
import it.live.itliveservice.entity.Service;
import it.live.itliveservice.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/service")
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceService service;


    @GetMapping("/get-all")
    public List<Service> getAll() {
        return service.getAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> add(@RequestBody Service servicedto) {
        return service.add(servicedto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @RequestBody Service servicedto) {
        return service.update(id, servicedto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        return service.delete(id);
    }

}
