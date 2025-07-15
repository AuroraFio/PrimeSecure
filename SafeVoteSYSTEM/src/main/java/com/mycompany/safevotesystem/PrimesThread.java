package com.mycompany.safevotesystem;

import java.util.Random;

public class PrimesThread implements Runnable {
    private final PrimesList primesList;
    private final int maxRandom;

    public PrimesThread(PrimesList primesList, int maxRandom) {
        this.primesList = primesList;
        this.maxRandom = maxRandom;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int candidate = rand.nextInt(maxRandom - 2) + 2; // [2, maxRandom)
        if (primesList.isPrime(candidate)) {
            try {
                primesList.add(candidate);
                System.out.println("Hilo " + Thread.currentThread().getName() + " agregó el primo: " + candidate);
            } catch (IllegalArgumentException e) {
                // Intento de agregar algo no primo (no debería ocurrir aquí)
            }
        }
    }
}