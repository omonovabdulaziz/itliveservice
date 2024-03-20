package it.live.itliveservice.service.impl;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.Customer;
import it.live.itliveservice.repository.CustomerRepository;
import it.live.itliveservice.service.CustomerService;
import it.live.itliveservice.utils.ImageUploader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

    private static final String MAIN_UPLOAD_DIRECTORY = "documents";

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<ApiResponse> add(Customer customer, MultipartFile multipartFile) {
        String fileName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
        ImageUploader.worker(MAIN_UPLOAD_DIRECTORY, fileName, multipartFile);
        repository.save(Customer.builder().description(customer.getDescription()).fullName(customer.getFullName()).logoUrl("/api/v1/file/getFile?path=" + MAIN_UPLOAD_DIRECTORY + "/" + fileName).build());
        return ResponseEntity.ok(ApiResponse.builder().status(200).message("Ok").build());
    }

    @Override
    public ResponseEntity<ApiResponse> delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Not uploaded");
        }
        return ResponseEntity.ok(ApiResponse.builder().status(200).message("Ok").build());
    }
}
