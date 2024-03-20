package it.live.itliveservice.service.impl;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.Payload.TypeServiceDTO;
import it.live.itliveservice.entity.TypeService;
import it.live.itliveservice.repository.ServiceRepo;
import it.live.itliveservice.repository.TypeRepository;
import it.live.itliveservice.service.TypeServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeServiceService {
    private final TypeRepository repository;
    private final ServiceRepo serviceRepo;

    @Override
    public List<TypeService> getAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<ApiResponse> add(TypeServiceDTO typeServiceDTO) {
        it.live.itliveservice.entity.Service service = serviceRepo.findById(typeServiceDTO.getServiceId()).orElseThrow(() -> new RuntimeException("Not found service"));
        repository.save(TypeService.builder().service(service).beginPrice(typeServiceDTO.getBeginPrice()).lastPrice(typeServiceDTO.getLastPrice()).build());
        return ResponseEntity.ok(ApiResponse.builder().message("Ok").status(201).build());
    }

    @Override
    public ResponseEntity<ApiResponse> delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
        return ResponseEntity.ok(ApiResponse.builder().build());
    }

    @Override
    public List<TypeService> getByServiceId(Long serviceid) {
        return repository.findAllByServiceId(serviceid);
    }
}
