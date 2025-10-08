package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ElementHelper {
    private static JsonNode elements;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            elements = mapper.readTree(new File("src/test/resources/elements.json"));
        } catch (IOException e) {
            throw new RuntimeException("elements.json okunamadı: " + e.getMessage(), e);
        }
    }

    public static WebElement getElement(WebDriver driver, String key) {
        JsonNode elementNode = elements.get(key);
        if (elementNode == null) {
            throw new RuntimeException("elements.json içinde " + key + " bulunamadı!");
        }

        String by = elementNode.get("by").asText();
        String value = elementNode.get("value").asText();
        int index = elementNode.has("index") ? elementNode.get("index").asInt() : 0;

        By locator;
        switch (by.toLowerCase()) {
            case "id":
                locator = By.id(value);
                break;
            case "xpath":
                locator = By.xpath(value);
                break;
            case "css":
                locator = By.cssSelector(value);
                break;
            case "name":
                locator = By.name(value);
                break;
            case "classname":
                locator = By.className(value);
                break;
            default:
                throw new IllegalArgumentException("Desteklenmeyen locator tipi: " + by);
        }

        List<WebElement> elementsFound = driver.findElements(locator);
        if (elementsFound.isEmpty()) {
            throw new RuntimeException("Element bulunamadı: " + key + " (" + by + " = " + value + ")");
        }

        if (index >= elementsFound.size()) {
            throw new RuntimeException("Element bulundu ama index geçersiz: " + key + " index=" + index);
        }

        return elementsFound.get(index);
    }
}
