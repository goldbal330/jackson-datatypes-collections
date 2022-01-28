package com.fasterxml.jackson.datatype.eclipsecollections.serializedeserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.eclipsecollections.ModuleTestBase;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

public class TupleTests
        extends ModuleTestBase {
    @Test
    public void twin() throws JsonProcessingException {
        Twin<String> twin = Tuples.twin("One", "Two");
        ObjectMapper objectMapper = this.mapperWithModule();
        String s = objectMapper.writeValueAsString(twin);
        Twin<String> deserialized = objectMapper.readValue(s, new TypeReference<Twin<String>>() {});
        Assert.assertEquals(twin, deserialized);
    }

    @Test
    public void pair() throws JsonProcessingException {
        Pair<String, Integer> pair = Tuples.pair("A", 25);
        ObjectMapper objectMapper = this.mapperWithModule();
        String s = objectMapper.writeValueAsString(pair);
        Pair<String, Integer> deserialized = objectMapper.readValue(s, new TypeReference<Pair<String, Integer>>() {});
        Assert.assertEquals(deserialized, deserialized);
    }
}
