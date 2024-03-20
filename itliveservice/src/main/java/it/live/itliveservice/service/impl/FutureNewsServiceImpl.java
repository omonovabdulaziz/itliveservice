package it.live.itliveservice.service.impl;

import it.live.itliveservice.Payload.ApiResponse;
import it.live.itliveservice.entity.FutureNews;
import it.live.itliveservice.repository.FutureNewsRepository;
import it.live.itliveservice.service.FutureNewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FutureNewsServiceImpl implements FutureNewsService {
    private final FutureNewsRepository futureNewsRepository;

    @Override
    public List<FutureNews> getAll() {
        return futureNewsRepository.findAll();
    }

    @Override
    public ResponseEntity<ApiResponse> add(FutureNews news) {
        futureNewsRepository.save(news);
        return ResponseEntity.ok(ApiResponse.builder().message("Ok").status(201).object(null).build());
    }

    @Override
    public ResponseEntity<ApiResponse> update(Long id, FutureNews news) {
        FutureNews futureNews = futureNewsRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found Future News"));
        futureNews.setDescription(news.getDescription());
        futureNews.setTitle(news.getTitle());
        futureNews.setIconUrl(news.getIconUrl());
        futureNewsRepository.save(futureNews);
        return ResponseEntity.ok(ApiResponse.builder().message("Ok").status(200).build());
    }

    @Override
    public ResponseEntity<ApiResponse> delete(Long id) {
        try {
            futureNewsRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Not Deleted");
        }
        return ResponseEntity.ok(ApiResponse.builder().message("Ok").status(200).build());
    }
}
