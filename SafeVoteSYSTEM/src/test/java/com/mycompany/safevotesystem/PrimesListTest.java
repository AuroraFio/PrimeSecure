package com.mycompany.safevotesystem;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PrimesListTest {
    private PrimesList primesList;

    @Before
    public void setUp() {
        primesList = new PrimesList();
    }

    @Test
    public void testAddPrime() {
        primesList.add(13);
        assertEquals(1, primesList.getPrimesCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNonPrime() {
        primesList.add(15);
    }

    @Test
    public void testRemovePrime() {
        primesList.add(17);
        primesList.remove((Integer)17);
        assertEquals(0, primesList.getPrimesCount());
    }
}