package it.live.itliveservice.controller;

import com.google.gson.Gson;
import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.Customer;
import it.live.itliveservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @GetMapping("/get-all")
    public List<Customer> getAll() {
        return service.getAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> add(@RequestPart(name = "customer") String customerJson,
                                           @RequestPart(name = "file") MultipartFile file) {
        Customer customer = convertJsonToCustomer(customerJson);
        return service.add(customer, file);
    }

    private Customer convertJsonToCustomer(String customerJson) {
        Gson gson = new Gson();
        return gson.fromJson(customerJson, Customer.class);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        return service.delete(id);
    }


}
