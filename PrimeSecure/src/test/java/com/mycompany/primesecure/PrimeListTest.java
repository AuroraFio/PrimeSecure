package com.mycompany.primesecure;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeListTest {
    @Test
    void testAddAndCount() {
        PrimeList list = new PrimeList();
        list.add(2);
        list.add(3);
        list.add(5);
        assertEquals(3, list.getPrimesCount());
    }

    @Test
    void testAddNonPrimeThrows() {
        PrimeList list = new PrimeList();
        assertThrows(IllegalArgumentException.class, () -> list.add(4));
    }

    @Test
    void testRemove() {
        PrimeList list = new PrimeList();
        list.add(2);
        list.remove((Integer)2);
        assertEquals(0, list.getPrimesCount());
    }
}