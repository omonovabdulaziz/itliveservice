package it.live.itliveservice.service.impl;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.Service;
import it.live.itliveservice.repository.ServiceRepo;
import it.live.itliveservice.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceImpl implements ServiceService {
    private final ServiceRepo serviceRepo;

    @Override
    public List<Service> getAll() {
        return serviceRepo.findAll();
    }

    @Override
    public ResponseEntity<ApiResponse> add(Service servicedto) {
        serviceRepo.save(servicedto);
        return ResponseEntity.ok(ApiResponse.builder().status(201).message("Ok").build());
    }

    @Override
    public ResponseEntity<ApiResponse> update(Long id, Service servicedto) {
        Service service = serviceRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found service"));
        service.setDescription(service.getDescription());
        service.setIconUrl(servicedto.getIconUrl());
        serviceRepo.save(service);
        return ResponseEntity.ok(ApiResponse.builder().message("ok").status(200).build());
    }

    @Override
    public ResponseEntity<ApiResponse> delete(Long id) {
        try {
            serviceRepo.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
        return ResponseEntity.ok(ApiResponse.builder().status(200).message("ok").build());
    }
}
