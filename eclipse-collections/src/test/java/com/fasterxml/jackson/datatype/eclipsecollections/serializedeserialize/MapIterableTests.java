package com.fasterxml.jackson.datatype.eclipsecollections.serializedeserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.datatype.eclipsecollections.ModuleTestBase;
import org.eclipse.collections.api.bimap.ImmutableBiMap;
import org.eclipse.collections.api.bimap.MutableBiMap;
import org.eclipse.collections.api.factory.BiMaps;
import org.eclipse.collections.api.factory.Maps;
import org.eclipse.collections.api.factory.SortedMaps;
import org.eclipse.collections.api.map.FixedSizeMap;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.MutableOrderedMap;
import org.eclipse.collections.api.map.sorted.ImmutableSortedMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.map.mutable.ConcurrentHashMap;
import org.eclipse.collections.impl.map.ordered.mutable.OrderedMapAdapter;
import org.junit.Test;

import java.util.LinkedHashMap;

public class MapIterableTests
        extends ModuleTestBase {

    @Test
    public void mutableMap() throws JsonProcessingException {
        this.verifySerializeDeserialize(Maps.mutable.of("A", 1, "C", 10, "B", 50),
                new TypeReference<MutableMap<String, Integer>>() {});
    }

    @Test
    public void immutableMap() throws JsonProcessingException {
        this.verifySerializeDeserialize(Maps.immutable.of("A", 1, "C", 10, "B", 50),
                new TypeReference<ImmutableMap<String, Integer>>() {});
    }

    @Test
    public void concurrentMutableMap() throws JsonProcessingException {
        ConcurrentHashMap<String, Integer> map =
                ConcurrentHashMap.newMap(Maps.mutable.of("A", 1, "C", 10, "B", 50));
        this.verifySerializeDeserialize(map, new TypeReference<ConcurrentHashMap<String, Integer>>() {});
    }
}
