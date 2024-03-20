package it.live.itliveservice.service;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.Service;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServiceService {

    List<Service> getAll();

    ResponseEntity<ApiResponse> add(Service servicedto);

    ResponseEntity<ApiResponse> update(Long id, Service servicedto);

    ResponseEntity<ApiResponse> delete(Long id);

}
