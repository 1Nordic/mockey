package com.lhamacorp.mockey.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lhamacorp.mockey.api.dto.MockRequest;
import com.lhamacorp.mockey.model.Mockey;
import com.lhamacorp.mockey.service.MockService;
import com.lhamacorp.mockey.util.ContentParser;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/mocks")
@AllArgsConstructor
public class MockController {

    private final MockService service;

    @GetMapping(value = "{id}")
    public ResponseEntity<?> get(@PathVariable String id) throws JsonProcessingException {
        Mockey response = service.get(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", response.getType());

        return ResponseEntity.ok()
            .headers(headers)
            .body(ContentParser.parse(response.getContent()));
    }

    @PostMapping
    public ResponseEntity<Mockey> create(@RequestBody MockRequest request) {
        Mockey response = service.create(request.content(), request.type());
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<Mockey> update(@PathVariable String id, @RequestBody MockRequest request) {
        Mockey response = service.update(id, request.content());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
