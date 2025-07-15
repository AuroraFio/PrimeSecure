package com.mycompany.primesecure;

import java.util.Random;

public class PrimeThread implements Runnable {
    private final PrimeList primesList;
    private final Object lock; // Para sincronización

    public PrimeThread(PrimeList primesList, Object lock) {
        this.primesList = primesList;
        this.lock = lock;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int number;
        // Genera y verifica un primo entre 2 y 10000
        do {
            number = 2 + rand.nextInt(9999);
        } while (!PrimeList.isPrime(number));

        synchronized (lock) {
            primesList.add(number);
            lock.notify(); // Notifica a otro hilo
        }
    }
}