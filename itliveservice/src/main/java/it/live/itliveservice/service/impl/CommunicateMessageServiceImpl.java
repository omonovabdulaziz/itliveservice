package it.live.itliveservice.service.impl;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.CommunicateMessage;
import it.live.itliveservice.repository.CommunicateMessageRepository;
import it.live.itliveservice.service.CommunicateMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommunicateMessageServiceImpl implements CommunicateMessageService {
    private final CommunicateMessageRepository repository;

    @Override
    public Page<CommunicateMessage> getAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    @Override
    public ResponseEntity<ApiResponse> add(CommunicateMessage communicateMessage) {
        repository.save(communicateMessage);
        return ResponseEntity.ok(ApiResponse.builder().status(200).message("Ok").build());
    }

    @Override
    public ResponseEntity<ApiResponse> delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
        return ResponseEntity.ok(ApiResponse.builder().message("ok").status(200).build());
    }
}
