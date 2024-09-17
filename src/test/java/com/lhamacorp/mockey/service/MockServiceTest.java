package com.lhamacorp.mockey.service;

import com.lhamacorp.mockey.App;
import com.lhamacorp.mockey.model.Mockey;
import com.lhamacorp.mockey.repository.MockRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {App.class})
public class MockServiceTest {

    @Autowired
    private MockRepository repository;

    private MockService service;
    private String createdId;

    @BeforeEach
    public void setup() {
        service = new MockService(repository);
    }

    @AfterEach
    public void cleanup() {
        if (createdId != null) {
            service.delete(createdId);
        }
    }

    @Test
    public void shouldCreateSimpleMock() {
        //given
        String content = "simple content mock";

        //when
        Mockey result = service.create(content, "text/plain");

        createdId = result.getId();

        //then
        assertNotNull(result.getId());
        assertNotNull(result.getContent());
        assertNotNull(result.getLastModified());
        assertEquals(result.getContent(), content);
    }

    @Test
    public void shouldUpdateSimpleMock() {
        //given
        String content = "simple content mock";
        String updatedContent = "updated content mock update";
        Mockey mock = service.create(content, "text/plain");

        //when
        Mockey result = service.update(mock.getId(), updatedContent);

        createdId = result.getId();

        //then
        assertNotNull(result.getId());
        assertNotNull(result.getContent());
        assertNotNull(result.getLastModified());
        assertEquals(result.getContent(), updatedContent);
    }

    @Test
    public void shouldCreateJsonMock() {
        // given
        String jsonContent = "{\"key\":\"value\",\"anotherKey\":\"anotherValue\"}";

        // when
        Mockey result = service.create(jsonContent, "application/json");

        createdId = result.getId();

        // then
        assertNotNull(result.getId());
        assertNotNull(result.getContent());
        assertNotNull(result.getLastModified());
        assertEquals(result.getContent(), jsonContent);
    }

}
