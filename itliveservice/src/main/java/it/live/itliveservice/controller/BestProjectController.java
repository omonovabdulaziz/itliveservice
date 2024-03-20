package it.live.itliveservice.controller;

import com.google.gson.Gson;
import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.BestProject;
import it.live.itliveservice.entity.HappyDay;
import it.live.itliveservice.service.BestProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/best-project")
@RequiredArgsConstructor
public class BestProjectController {
    private final BestProjectService service;


    @GetMapping("/get-all")
    public List<BestProject> getAll() {
        return service.getAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> add(@RequestPart(name = "bestproject") String bestProject,
                                           @RequestPart(name = "file") MultipartFile file) {
        return service.add(convertJsonToHappyDay(bestProject), file);
    }

    private BestProject convertJsonToHappyDay(String bestProject) {
        Gson gson = new Gson();
        return gson.fromJson(bestProject, BestProject.class);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        return service.delete(id);
    }

}
