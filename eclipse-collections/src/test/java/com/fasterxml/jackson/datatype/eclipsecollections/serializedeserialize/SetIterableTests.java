package com.fasterxml.jackson.datatype.eclipsecollections.serializedeserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.datatype.eclipsecollections.ModuleTestBase;
import org.eclipse.collections.api.factory.Sets;
import org.eclipse.collections.api.factory.SortedSets;
import org.eclipse.collections.api.set.FixedSizeSet;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.junit.Test;

public class SetIterableTests
        extends ModuleTestBase {
    @Test
    public void mutableSortedSet() throws JsonProcessingException {
        this.verifySerializeDeserialize(SortedSets.mutable.of(Comparators.reverseNaturalOrder(), 5, 10, 0),
                new TypeReference<MutableSortedSet<Integer>>() {});
    }

    @Test
    public void immutableSortedSet() throws JsonProcessingException {
        this.verifySerializeDeserialize(SortedSets.immutable.of(Comparators.reverseNaturalOrder(), 5, 10, 0)
                        .toImmutable(),
                new TypeReference<ImmutableSortedSet<Integer>>() {});
    }

    @Test
    public void mutableSet() throws JsonProcessingException {
        this.verifySerializeDeserialize(Sets.mutable.of(20, 3, 100, -1), new TypeReference<MutableSet<Integer>>() {});
    }


    @Test
    public void immutableSet() throws JsonProcessingException {
        ImmutableSet<Integer> set = Sets.immutable.of(20, 3, 100, -1);
        this.verifySerializeDeserialize(set, new TypeReference<ImmutableSet<Integer>>() {});
    }
}
