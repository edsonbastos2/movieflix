package com.edsonBastos.catalog.controller;

import com.edsonBastos.catalog.controller.request.StreamingRequest;
import com.edsonBastos.catalog.controller.response.StreamingResponse;
import com.edsonBastos.catalog.entity.Streaming;
import com.edsonBastos.catalog.mapper.StreamingMapper;
import com.edsonBastos.catalog.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogo-filmes/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService service;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> getAll() {
        List<StreamingResponse> list = service.getAll()
                .stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> saveStreaming(@RequestBody StreamingRequest request) {
        Streaming streaming = StreamingMapper.toStreaming(request);
        Streaming streamingSave = service.save(streaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(streamingSave));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
