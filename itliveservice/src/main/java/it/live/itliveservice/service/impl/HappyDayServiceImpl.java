package it.live.itliveservice.service.impl;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.Customer;
import it.live.itliveservice.entity.HappyDay;
import it.live.itliveservice.repository.HappyDayRepository;
import it.live.itliveservice.service.HappyDayService;
import it.live.itliveservice.utils.ImageUploader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HappyDayServiceImpl implements HappyDayService {
    private final HappyDayRepository happyDayRepository;
    private static final String MAIN_UPLOAD_DIRECTORY = "documents";

    @Override
    public List<HappyDay> getAll() {
        return happyDayRepository.findAll();
    }

    @Override
    public ResponseEntity<ApiResponse> add(HappyDay happyDay, MultipartFile multipartFile) {
        String fileName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
        ImageUploader.worker(MAIN_UPLOAD_DIRECTORY, fileName, multipartFile);
        happyDayRepository.save(HappyDay.builder().description(happyDay.getDescription()).title(happyDay.getTitle()).happenedAt(happyDay.getHappenedAt()).imageUrl("/api/v1/file/getFile?path=" + MAIN_UPLOAD_DIRECTORY + "/" + fileName).build());
        return ResponseEntity.ok(ApiResponse.builder().status(200).message("Ok").build());
    }

    @Override
    public ResponseEntity<ApiResponse> delete(Long id) {
        try {
            happyDayRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("delted");
        }
        return ResponseEntity.ok(ApiResponse.builder().message("Deleted").status(200).build());
    }
}
