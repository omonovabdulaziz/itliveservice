package it.live.itliveservice.service;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();

    ResponseEntity<ApiResponse> add(Customer customer, MultipartFile multipartFile);

    ResponseEntity<ApiResponse> delete(Long id);
}
