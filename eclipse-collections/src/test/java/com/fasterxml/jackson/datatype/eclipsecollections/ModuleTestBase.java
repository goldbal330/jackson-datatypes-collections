package com.fasterxml.jackson.datatype.eclipsecollections;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.fail;

public abstract class ModuleTestBase {

    protected ObjectMapper mapperWithModule() {
        return new ObjectMapper().registerModule(new EclipseCollectionsModule());
    }

    protected  <T> void verifySerializeDeserialize(T source, TypeReference<T> type) throws JsonProcessingException {
        ObjectMapper objectMapper = mapperWithModule();
        String json = objectMapper.writeValueAsString(source);
        T deserializedValue = objectMapper.readValue(json, type);
        Assert.assertEquals(source, deserializedValue);
    }

    protected void verifyException(Throwable e, String... matches) {
        String msg = e.getMessage();
        String lmsg = (msg == null) ? "" : msg.toLowerCase();
        for (String match : matches) {
            String lmatch = match.toLowerCase();
            if (lmsg.indexOf(lmatch) >= 0) {
                return;
            }
        }
        fail("Expected an exception with one of substrings (" + Arrays.asList(matches) + "): got one with message \"" +
                msg + "\"");
    }
}
