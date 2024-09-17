package com.lhamacorp.mockey.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContentParserTest {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldParseJson() throws JsonProcessingException {
        //given
        String content = "{\"key\":\"value\",\"anotherKey\":\"anotherValue\"}";
        Map<String, Object> expectedMap = mapper.readValue(content, Map.class);

        //when
        Object result = ContentParser.parse(content);

        //then
        assertNotNull(result);

        Map<String, Object> resultMap = (Map<String, Object>) result;

        assertEquals(expectedMap.size(), resultMap.size());
        assertEquals(expectedMap.get("key"), resultMap.get("key"));
        assertEquals(expectedMap.get("anotherKey"), resultMap.get("anotherKey"));
    }

    @Test
    public void shouldNotParseIfNotJson() throws JsonProcessingException {
        //given
        String content = "not json content";

        //when
        Object result = ContentParser.parse(content);

        //then
        assertEquals(result.toString(), content);
    }

}
