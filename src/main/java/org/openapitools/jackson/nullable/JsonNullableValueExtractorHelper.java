package org.openapitools.jackson.nullable;

public abstract class JsonNullableValueExtractorHelper {
    public static void extractValues(JsonNullable<?> originalValue, ValueSetter valueSetter) {
        if (originalValue.isPresent()) {
            valueSetter.apply(null, originalValue.get());
        }
    }

    @FunctionalInterface
    public interface ValueSetter {
        void apply(String var1, Object var2);
    }
}
