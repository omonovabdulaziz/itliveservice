package it.live.itliveservice.service;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.HappyDay;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HappyDayService {
    List<HappyDay> getAll();

    ResponseEntity<ApiResponse> add(HappyDay happyDay , MultipartFile multipartFile);

    ResponseEntity<ApiResponse> delete(Long id);
}
