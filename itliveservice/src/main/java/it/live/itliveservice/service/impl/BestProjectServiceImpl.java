package it.live.itliveservice.service.impl;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.BestProject;
import it.live.itliveservice.entity.HappyDay;
import it.live.itliveservice.repository.BestProjectRepository;
import it.live.itliveservice.service.BestProjectService;
import it.live.itliveservice.utils.ImageUploader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class BestProjectServiceImpl implements BestProjectService {
    private final BestProjectRepository repository;
    private static final String MAIN_UPLOAD_DIRECTORY = "documents";

    @Override
    public List<BestProject> getAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<ApiResponse> add(BestProject bestProject, MultipartFile file) {
        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
        ImageUploader.worker(MAIN_UPLOAD_DIRECTORY, fileName, file);
        repository.save(BestProject.builder().imageUrl("/api/v1/file/getFile?path=" + MAIN_UPLOAD_DIRECTORY + "/" + fileName).description(bestProject.getDescription()).link(bestProject.getLink()).build());
        return ResponseEntity.ok(ApiResponse.builder().status(200).message("Ok").build());
    }

    @Override
    public ResponseEntity<ApiResponse> delete(Long id) {
        try {
            repository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Error");
        }
        return ResponseEntity.ok(ApiResponse.builder().status(200).message("ok").build());
    }
}
