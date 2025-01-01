package org.openapitools.jackson.nullable;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JsonNullWithEmptyTest  extends ModuleTestBase
{
    private final ObjectMapper MAPPER = mapperWithModule();

    static class BooleanBean {
        public JsonNullable<Boolean> value;

        public BooleanBean() { }
        public BooleanBean(Boolean b) {
            value = JsonNullable.of(b);
        }
    }

    @Test
    public void testJsonNullableFromEmpty() throws Exception {
        JsonNullable<?> value = MAPPER.readValue(quote(""), new TypeReference<JsonNullable<Integer>>() {});
        assertFalse(value.isPresent());
    }

    @Test
    // for [datatype-jdk8#23]
    public void testBooleanWithEmpty() throws Exception
    {
        // and looks like a special, somewhat non-conforming case is what a user had
        // issues with
        BooleanBean b = MAPPER.readValue(aposToQuotes("{'value':''}"), BooleanBean.class);
        assertNotNull(b.value);

        assertFalse(b.value.isPresent());
    }

}