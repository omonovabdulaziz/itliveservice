package it.live.itliveservice.controller;

import com.google.gson.Gson;
import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.Customer;
import it.live.itliveservice.entity.FutureNews;
import it.live.itliveservice.entity.HappyDay;
import it.live.itliveservice.service.HappyDayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/happy-day")
@RequiredArgsConstructor
public class HappyDayController {
    private final HappyDayService service;


    @GetMapping("/get-all")
    public List<HappyDay> getAll() {
        return service.getAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> add(@RequestPart(name = "happyDay") String happyDay,
                                           @RequestPart(name = "file") MultipartFile file) {
        return service.add(convertJsonToHappyDay(happyDay), file);
    }

    private HappyDay convertJsonToHappyDay(String happyDayJson) {
        Gson gson = new Gson();
        return gson.fromJson(happyDayJson, HappyDay.class);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        return service.delete(id);
    }

}
