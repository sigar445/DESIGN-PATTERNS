package org.sigar.JavaCRef12Part2Lib.chap20_collection.MYCOLLECTION;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

class MyCollectionTest {
    private MyCollection<Integer> collection;

    @BeforeEach
    void setUp() {
        collection = new MyCollection<>(10);
    }

    @Test
    void testSize() {
        assertEquals(0, collection.size(), "Size should be zero initially.");
        collection.add(1);
        assertEquals(1, collection.size(), "Size should increase when an element is added.");
    }

    @Test
    void testIsEmpty() {
        assertTrue(collection.isEmpty(), "Collection should be empty initially.");
        collection.add(1);
        assertFalse(collection.isEmpty(), "Collection should not be empty after adding an element.");
    }

    @Test
    void testContains() {
        collection.add(10);
        assertTrue(collection.contains(10), "Collection should contain the element.");
        assertFalse(collection.contains(5), "Collection should not contain an element that was not added.");
        assertFalse(collection.contains(null), "Collection should not contain null.");
    }

    @Test
    void testIterator() {
        collection.add(1);
        collection.add(2);
        Iterator<Integer> iterator = collection.iterator();
        assertTrue(iterator.hasNext(), "Iterator should have next elements.");
        assertEquals(1, iterator.next(), "Iterator should return the first element.");
        assertEquals(2, iterator.next(), "Iterator should return the second element.");
        assertFalse(iterator.hasNext(), "Iterator should not have more elements.");
    }

    @Test
    void testToArray() {
        collection.add(1);
        collection.add(2);
        Object[] array = collection.toArray();
        assertArrayEquals(new Object[]{1, 2}, array, "toArray should return an array with collection elements.");
    }

    @Test
    void testToArrayWithGivenArray() {
        collection.add(1);
        collection.add(2);
        Integer[] array = new Integer[2];
        Integer[] result = collection.toArray(array);
        assertArrayEquals(new Integer[]{1, 2}, result, "toArray should fill the given array correctly.");

        array = new Integer[1];
        result = collection.toArray(array);
        assertArrayEquals(new Integer[]{1, 2}, result, "toArray should create a new array if given one is too small.");

        array = new Integer[5];
        result = collection.toArray(array);
        assertEquals(5, result.length, "Returned array should have the original size.");
        assertNull(result[2], "Extra space in array should be filled with null.");
    }

    @Test
    void testAdd() {
        assertTrue(collection.add(5), "Add should return true when an element is successfully added.");
        assertTrue(collection.contains(5), "Element should be present in the collection after adding.");
    }

    @Test
    void testGrow() {
        for (int i = 0; i < 15; i++) {
            collection.add(i);
        }
        assertEquals(15, collection.size(), "Collection should resize dynamically as elements are added.");
    }

    @Test
    void testAddAll() {
        Collection<Integer> newElements = Arrays.asList(1, 2, 3, 4);
        assertTrue(collection.addAll(newElements), "addAll should return true when elements are added.");
        assertTrue(collection.containsAll(newElements), "All added elements should be in the collection.");
    }

    @Test
    void testContainsAll() {
        collection.add(1);
        collection.add(2);
        Collection<Integer> elements = Arrays.asList(1, 2);
        assertTrue(collection.containsAll(elements), "Collection should contain all elements.");

        elements = Arrays.asList(1, 3);
        assertFalse(collection.containsAll(elements), "Collection should not contain elements not added.");
    }

    @Test
    void testClear() {
        collection.add(1);
        collection.add(2);
        collection.clear();
        assertTrue(collection.isEmpty(), "Collection should be empty after clear.");
        assertEquals(0, collection.size(), "Size should be zero after clear.");
    }

    @Test
    void testRemoveThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> collection.remove(1), "remove should throw UnsupportedOperationException.");
    }

    @Test
    void testRemoveAllThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> collection.removeAll(Arrays.asList(1, 2)), "removeAll should throw UnsupportedOperationException.");
    }

    @Test
    void testRetainAllThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> collection.retainAll(Arrays.asList(1, 2)), "retainAll should throw UnsupportedOperationException.");
    }
}

