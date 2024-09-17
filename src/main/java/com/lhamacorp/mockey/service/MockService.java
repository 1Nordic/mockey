package com.lhamacorp.mockey.service;

import com.lhamacorp.mockey.exception.NotFoundException;
import com.lhamacorp.mockey.model.Mockey;
import com.lhamacorp.mockey.repository.MockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MockService {

    private final MockRepository repository;

    public Mockey get(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Mockey not found"));
    }

    public Mockey create(String content) {
        return repository.save(new Mockey(UUID.randomUUID().toString(), content, Instant.now()));
    }

    public Mockey update(String id, String content) {
        Mockey toUpdate = get(id);
        toUpdate.setContent(content);
        toUpdate.setLastModified(Instant.now());

        return repository.save(toUpdate);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }


}
