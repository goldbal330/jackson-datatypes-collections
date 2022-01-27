package com.fasterxml.jackson.datatype.eclipsecollections.serializedeserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.datatype.eclipsecollections.ModuleTestBase;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.factory.Stacks;
import org.eclipse.collections.api.list.FixedSizeList;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.stack.ImmutableStack;
import org.eclipse.collections.api.stack.MutableStack;
import org.junit.Test;

public class OrderedIterableTests
        extends ModuleTestBase {



    @Test
    public void mutableList() throws JsonProcessingException {
        this.verifySerializeDeserialize(Lists.mutable.of(5, 10, 3),
                new TypeReference<MutableList<Integer>>() {});
    }

    @Test
    public void immutableList() throws JsonProcessingException {
        this.verifySerializeDeserialize(Lists.immutable.of(5, 10, 3),
                new TypeReference<ImmutableList<Integer>>() {});
    }

    @Test
    public void fixedSizeList() throws JsonProcessingException {
        this.verifySerializeDeserialize(Lists.fixedSize.of(5, 10, 20),
                new TypeReference<FixedSizeList<Integer>>() {});
    }
}
