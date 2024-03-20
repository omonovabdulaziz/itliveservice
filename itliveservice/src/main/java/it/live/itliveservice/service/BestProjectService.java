package it.live.itliveservice.service;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.BestProject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BestProjectService {
    List<BestProject> getAll();

    ResponseEntity<ApiResponse> add(BestProject bestProject, MultipartFile file);

    ResponseEntity<ApiResponse> delete(Long id);
}
