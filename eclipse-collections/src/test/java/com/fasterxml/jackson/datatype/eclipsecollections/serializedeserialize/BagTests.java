package com.fasterxml.jackson.datatype.eclipsecollections.serializedeserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.datatype.eclipsecollections.ModuleTestBase;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.sorted.ImmutableSortedBag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.factory.Bags;
import org.eclipse.collections.api.factory.SortedBags;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.junit.Test;

public class BagTests
        extends ModuleTestBase {
    @Test
    public void mutableSortedBagTest() throws JsonProcessingException
    {
        MutableSortedBag<Integer> bag =
                SortedBags.mutable.of(Comparators.reverseNaturalOrder(), 1, 5, 5, 0, 3, 3, 3, 7);
        this.verifySerializeDeserialize(bag, new TypeReference<MutableSortedBag<Integer>>() {});
    }

    @Test
    public void immutableSortedBag() throws JsonProcessingException
    {
        ImmutableSortedBag<Integer> bag =
                SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 5, 5, 0, 3, 3, 3, 7);
        this.verifySerializeDeserialize(bag, new TypeReference<ImmutableSortedBag<Integer>>() {});
    }

    @Test
    public void mutableBag() throws JsonProcessingException
    {
        this.verifySerializeDeserialize(Bags.mutable.of(1, 5, 5, 0, 3, 3, 3, 7),
                new TypeReference<MutableBag<Integer>>() {});
    }

    @Test
    public void immutableBag() throws JsonProcessingException
    {
        this.verifySerializeDeserialize(Bags.immutable.of(1, 5, 5, 0, 3, 3, 3, 7),
                new TypeReference<ImmutableBag<Integer>>() {});
    }
}
