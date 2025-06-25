package com.edsonBastos.catalog.service;

import com.edsonBastos.catalog.entity.Streaming;
import com.edsonBastos.catalog.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository repository;

    public List<Streaming> getAll() {
        return repository.findAll();
    }

    public Streaming save(Streaming streaming) {
        return repository.save(streaming);
    }

    public Optional<Streaming> getById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
