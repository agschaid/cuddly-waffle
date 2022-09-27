package at.agschaid;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

@MicronautTest
class NullInMapsTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    ObjectMapper objectMapper;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testNullInMap() throws JsonMappingException, JsonProcessingException {
      final String mapWithNullValue = "{\"foo\":\"bar\", \"testNull\": null}";
      Map<?,?> untypedMap = objectMapper.readValue(mapWithNullValue, Map.class);

      assertTrue(untypedMap.containsKey("testNull"));
      assertNull(untypedMap.get("testNull"));
    }

}
