package com.fasterxml.jackson.datatype.eclipsecollections.serializedeserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.datatype.eclipsecollections.ModuleTestBase;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Test;

public class TupleTests
        extends ModuleTestBase {
    @Test
    public void twin() throws JsonProcessingException {
        Twin<String> twin = Tuples.twin("One", "Two");
        this.verifySerializeDeserialize(twin, new TypeReference<Twin<String>>() {});
    }

    @Test
    public void pair() throws JsonProcessingException {
        Pair<String, Integer> pair = Tuples.pair("A", 25);
        this.verifySerializeDeserialize(pair, new TypeReference<Pair<String, Integer>>() {});
    }

    @Test
    public void listOfPairs() throws JsonProcessingException {
        MutableList<Pair<String, Integer>> pairs =
                Lists.mutable.of(Tuples.pair("A", 25), Tuples.pair("B", 250));
        this.verifySerializeDeserialize(pairs, new TypeReference<MutableList<Pair<String, Integer>>>() {});
    }
}
