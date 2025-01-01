package org.openapitools.jackson.nullable;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonNullJacksonServiceLoadingTest {

    @Test
    public void testJacksonJsonNullableModuleServiceLoading() {
        String foundModuleName = ObjectMapper.findModules().get(0).getModuleName();
        assertEquals(new JsonNullableModule().getModuleName(), foundModuleName);
    }
}