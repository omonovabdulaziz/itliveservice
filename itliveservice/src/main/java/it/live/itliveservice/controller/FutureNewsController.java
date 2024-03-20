package it.live.itliveservice.controller;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.FutureNews;
import it.live.itliveservice.service.FutureNewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/future")
@RequiredArgsConstructor
public class FutureNewsController {
    private final FutureNewsService service;


    @GetMapping("/get-all")
    public List<FutureNews> getAll() {
        return service.getAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> add(@RequestBody FutureNews news) {
        return service.add(news);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id , @RequestBody FutureNews news) {
        return service.update(id , news);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        return service.delete(id);
    }

}
