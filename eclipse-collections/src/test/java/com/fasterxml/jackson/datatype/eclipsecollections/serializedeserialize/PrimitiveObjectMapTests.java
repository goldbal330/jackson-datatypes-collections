package com.fasterxml.jackson.datatype.eclipsecollections.serializedeserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.datatype.eclipsecollections.ModuleTestBase;
import org.eclipse.collections.api.map.primitive.*;
import org.eclipse.collections.impl.factory.primitive.*;
import org.junit.Test;

public class PrimitiveObjectMapTests
        extends ModuleTestBase {
    @Test
    public void mutableIntObjectMap() throws JsonProcessingException {
        MutableIntObjectMap<String> map = IntObjectMaps.mutable.empty();
        map.put(1, "A");
        map.put(3, "D");
        map.put(2, "F");
        this.verifySerializeDeserialize(map, new TypeReference<MutableIntObjectMap<String>>() {});
    }

    @Test
    public void immutableIntObjectMap() throws JsonProcessingException {
        MutableIntObjectMap<String> mutableMap = IntObjectMaps.mutable.empty();
        mutableMap.put(1, "A");
        mutableMap.put(3, "D");
        mutableMap.put(2, "F");
        this.verifySerializeDeserialize(mutableMap.toImmutable(),
                new TypeReference<ImmutableIntObjectMap<String>>() {});
    }

    @Test
    public void mutableLongObjectMap() throws JsonProcessingException {
        MutableLongObjectMap<String> map = LongObjectMaps.mutable.empty();
        map.put(11, "A");
        map.put(33, "D");
        map.put(22, "F");
        this.verifySerializeDeserialize(map, new TypeReference<MutableLongObjectMap<String>>() {});
    }

    @Test
    public void immutableLongObjectMap() throws JsonProcessingException {
        MutableLongObjectMap<String> mutableLongObjectMap = LongObjectMaps.mutable.empty();
        mutableLongObjectMap.put(11, "A");
        mutableLongObjectMap.put(33, "D");
        mutableLongObjectMap.put(22, "F");
        this.verifySerializeDeserialize(mutableLongObjectMap.toImmutable(),
                new TypeReference<ImmutableLongObjectMap<String>>() {});
    }

    @Test
    public void mutableDoubleObjectMap() throws JsonProcessingException {
        MutableDoubleObjectMap<String> map = DoubleObjectMaps.mutable.empty();
        map.put(111, "A");
        map.put(333, "D");
        map.put(222, "C");
        this.verifySerializeDeserialize(map, new TypeReference<MutableDoubleObjectMap<String>>() {});
    }

    @Test
    public void immutableDoubleObjectMap() throws JsonProcessingException {
        MutableDoubleObjectMap<String> mutableMap = DoubleObjectMaps.mutable.empty();
        mutableMap.put(111.5d, "A");
        mutableMap.put(333.7d, "D");
        mutableMap.put(222.8d, "C");
        this.verifySerializeDeserialize(mutableMap.toImmutable(),
                new TypeReference<ImmutableDoubleObjectMap<String>>() {});
    }

    @Test
    public void mutableFloatObjectMap() throws JsonProcessingException {
        MutableFloatObjectMap<Integer> map = FloatObjectMaps.mutable.empty();
        map.put(111.07f, 5);
        map.put(333.09f, 7);
        map.put(343.06f, 9);
        this.verifySerializeDeserialize(map, new TypeReference<MutableFloatObjectMap<Integer>>() {});
    }

    @Test
    public void immutableFloatObjectMap() throws JsonProcessingException {
        MutableFloatObjectMap<Integer> mutableFloatObjectMap = FloatObjectMaps.mutable.empty();
        mutableFloatObjectMap.put(111.07f, 5);
        mutableFloatObjectMap.put(333.09f, 7);
        mutableFloatObjectMap.put(343.06f, 9);
        this.verifySerializeDeserialize(mutableFloatObjectMap.toImmutable(),
                new TypeReference<ImmutableFloatObjectMap<Integer>>() {});
    }

    @Test
    public void mutableShortObjectMap() throws JsonProcessingException {
        MutableShortObjectMap<String> map = ShortObjectMaps.mutable.empty();
        map.put((short) 1, "B");
        map.put((short) 2, "BB");
        map.put((short) 20, "BBBB");
        this.verifySerializeDeserialize(map, new TypeReference<MutableShortObjectMap<String>>() {});
    }

    @Test
    public void immutableShortObjectMap() throws JsonProcessingException {
        MutableShortObjectMap<String> mutableShortObjectMap = ShortObjectMaps.mutable.empty();
        mutableShortObjectMap.put((short) 1, "B");
        mutableShortObjectMap.put((short) 2, "BB");
        mutableShortObjectMap.put((short) 20, "BBBB");
        this.verifySerializeDeserialize(mutableShortObjectMap.toImmutable(),
                new TypeReference<ImmutableShortObjectMap<String>>() {});
    }

    @Test
    public void mutableByteObjectMap() throws JsonProcessingException {
        MutableByteObjectMap<String> map = ByteObjectMaps.mutable.empty();
        map.put((byte) 1, "A");
        map.put((byte) 2, "B");
        map.put((byte) 3, "C");
        this.verifySerializeDeserialize(map, new TypeReference<MutableByteObjectMap<String>>() {});
    }

    @Test
    public void immutableByteObjectMap() throws JsonProcessingException {
        MutableByteObjectMap<String> mutableByteObjectMap = ByteObjectMaps.mutable.empty();
        mutableByteObjectMap.put((byte) 1, "A");
        mutableByteObjectMap.put((byte) 2, "B");
        mutableByteObjectMap.put((byte) 3, "C");
        this.verifySerializeDeserialize(mutableByteObjectMap.toImmutable(),
                new TypeReference<ImmutableByteObjectMap<String>>() {});
    }

    @Test
    public void mutableCharObjectMap() throws JsonProcessingException {
        MutableCharObjectMap<String> map = CharObjectMaps.mutable.empty();
        map.put('a', "A");
        map.put('b', "B");
        map.put('c', "CC");
        this.verifySerializeDeserialize(map, new TypeReference<MutableCharObjectMap<String>>() {});
    }

    @Test
    public void immutableCharObjectMap() throws JsonProcessingException {
        MutableCharObjectMap<String> mutableCharObjectMap = CharObjectMaps.mutable.empty();
        mutableCharObjectMap.put('a', "A");
        mutableCharObjectMap.put('b', "B");
        mutableCharObjectMap.put('c', "CC");
        this.verifySerializeDeserialize(mutableCharObjectMap.toImmutable(),
                new TypeReference<ImmutableCharObjectMap<String>>() {});
    }
}
