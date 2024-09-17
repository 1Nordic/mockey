package com.lhamacorp.mockey.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ContentParser {

    private static final ObjectMapper mapper = new ObjectMapper();

    public Object parse(String content) throws JsonProcessingException {
        return isValidJson(content)
            ? mapper.readValue(content, Object.class)
            : content;
    }

    public boolean isValidJson(String jsonString) {
        try {
            JsonElement jsonElement = JsonParser.parseString(jsonString);
            return jsonElement.isJsonObject() || jsonElement.isJsonArray();
        } catch (JsonSyntaxException e) {
            return false;
        }
    }

}
