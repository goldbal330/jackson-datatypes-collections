package com.fasterxml.jackson.datatype.eclipsecollections.serializedeserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.datatype.eclipsecollections.ModuleTestBase;
import org.eclipse.collections.api.bimap.ImmutableBiMap;
import org.eclipse.collections.api.bimap.MutableBiMap;
import org.eclipse.collections.api.factory.*;
import org.eclipse.collections.api.map.FixedSizeMap;
import org.eclipse.collections.api.map.MutableOrderedMap;
import org.eclipse.collections.api.map.sorted.ImmutableSortedMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.set.FixedSizeSet;
import org.eclipse.collections.api.stack.ImmutableStack;
import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.map.ordered.mutable.OrderedMapAdapter;
import org.junit.Ignore;
import org.junit.Test;

import java.util.LinkedHashMap;

@Ignore
public class FailingTests
        extends ModuleTestBase {

    @Test
    public void mutableSortedMap() throws JsonProcessingException {
        MutableSortedMap<String, Integer> sortedMap =
                SortedMaps.mutable.<String, Integer>of(Comparators.reverseNaturalOrder())
                        .withKeyValue("A", 1)
                        .withKeyValue("C", 10).
                        withKeyValue("B", 50);
        this.verifySerializeDeserialize(sortedMap, new TypeReference<MutableSortedMap<String, Integer>>() {});
    }

    @Test
    public void immutableSortedMap() throws JsonProcessingException {
        ImmutableSortedMap<String, Integer> sortedMap =
                SortedMaps.mutable.<String, Integer>of(Comparators.reverseNaturalOrder())
                        .withKeyValue("A", 1)
                        .withKeyValue("C", 10)
                        .withKeyValue("B", 50)
                        .toImmutable();
        this.verifySerializeDeserialize(sortedMap, new TypeReference<ImmutableSortedMap<String, Integer>>() {});
    }

    @Test
    public void mutableOrderedMap() throws JsonProcessingException {
        MutableOrderedMap<String, Integer> map = OrderedMapAdapter.adapt(new LinkedHashMap<>());
        map.put("A", 1);
        map.put("C", 10);
        map.put("B", 50);
        this.verifySerializeDeserialize(map, new TypeReference<MutableOrderedMap<String, Integer>>() {});
    }

    @Test
    public void mutableBiMap() throws JsonProcessingException {
        this.verifySerializeDeserialize(BiMaps.mutable.of("A", 1, "C", 10, "B", 50),
                new TypeReference<MutableBiMap<String, Integer>>() {});
    }

    @Test
    public void immutableBiMap() throws JsonProcessingException {
        this.verifySerializeDeserialize(BiMaps.immutable.of("A", 1, "C", 10, "B", 50),
                new TypeReference<ImmutableBiMap<String, Integer>>() {});
    }

    @Test
    public void fixedSizeMap() throws JsonProcessingException {
        this.verifySerializeDeserialize(Maps.fixedSize.of("A", 1, "C", 10, "B", 50),
                new TypeReference<FixedSizeMap<String, Integer>>() {});
    }

    @Test
    public void mutableStackTest() throws JsonProcessingException {
        this.verifySerializeDeserialize(Stacks.mutable.of(5, 10, 3),
                new TypeReference<MutableStack<Integer>>() {});
    }

    @Test
    public void immutableStackTest() throws JsonProcessingException {
        this.verifySerializeDeserialize(Stacks.immutable.of(5, 10, 3),
                new TypeReference<ImmutableStack<Integer>>() {});
    }

    @Test
    public void fixedSizeSet() throws JsonProcessingException {
        this.verifySerializeDeserialize(Sets.fixedSize.of(5, 10, 20),
                new TypeReference<FixedSizeSet<Integer>>() {});
    }
}
