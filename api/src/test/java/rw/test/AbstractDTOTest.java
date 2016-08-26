package rw.test;

import rw.utils.JsonObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public abstract class AbstractDTOTest<T> {

    private ObjectMapper mapper = new JsonObjectMapper().objectMapper();

    @Test
    public void shouldMapToJSON() throws IOException {
        // Sample javascript object
        T instance = instance();
        String json = mapper.writeValueAsString(instance);
        assertNotNull(json);
        T obj = mapper.readValue(json, clazz());
        assertNotNull(obj);
    }

    protected abstract T instance();

    protected abstract Class<T> clazz();

    protected ObjectMapper getMapper() {
        return mapper;
    }
}
