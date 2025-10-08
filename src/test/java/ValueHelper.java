package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ValueHelper {
    private static JsonNode values;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            values = mapper.readTree(new File("src/test/resources/values.json"));
        } catch (IOException e) {
            throw new RuntimeException("values.json okunamadı: " + e.getMessage(), e);
        }
    }

    public static String getValue(String key) {
        JsonNode node = values.get(key);
        if (node == null) {
            throw new RuntimeException("values.json içinde " + key + " bulunamadı!");
        }
        return node.asText();
    }
}
