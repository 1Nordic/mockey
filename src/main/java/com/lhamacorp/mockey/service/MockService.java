package com.lhamacorp.mockey.service;

import com.lhamacorp.mockey.exception.NotFoundException;
import com.lhamacorp.mockey.model.Mockey;
import com.lhamacorp.mockey.repository.MockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static java.time.Instant.now;
import static java.util.UUID.randomUUID;

@Service
@AllArgsConstructor
public class MockService {

    private final MockRepository repository;

    public Mockey get(String id) {
        Mockey mock = repository.findById(id).orElseThrow(() -> new NotFoundException("Mockey not found"));
        repository.updateLastAccessed(mock.getId(), now());
        return mock;
    }

    public Mockey create(String content) {
        return repository.save(new Mockey(randomUUID().toString(), content, now(), now()));
    }

    public Mockey update(String id, String content) {
        Mockey toUpdate = get(id);
        toUpdate.setContent(content);
        toUpdate.setLastModified(now());
        return repository.save(toUpdate);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

}
