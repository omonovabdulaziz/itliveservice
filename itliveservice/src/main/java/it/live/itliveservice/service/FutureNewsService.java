package it.live.itliveservice.service;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.FutureNews;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FutureNewsService {
    List<FutureNews> getAll();


    ResponseEntity<ApiResponse> add(FutureNews news);

    ResponseEntity<ApiResponse> update(Long id , FutureNews news);

    ResponseEntity<ApiResponse> delete(Long id);
}
