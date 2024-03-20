package it.live.itliveservice.service;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.CommunicateMessage;
import it.live.itliveservice.entity.FutureNews;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommunicateMessageService {


    Page<CommunicateMessage> getAll(int page, int size);

    ResponseEntity<ApiResponse> add(CommunicateMessage communicateMessage);

    ResponseEntity<ApiResponse> delete(Long id);
}
