package com.mycompany.primesecure;

public class PrimeAdderThread extends Thread {
    private final PrimeList primeList;
    private final int numberToCheck;

    public PrimeAdderThread(PrimeList primeList, int numberToCheck) {
        this.primeList = primeList;
        this.numberToCheck = numberToCheck;
    }

    @Override
    public void run() {
        try {
            primeList.add(numberToCheck);
            System.out.println("Hilo " + this.getName() + ": Agregado " + numberToCheck + " a la lista de primos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Hilo " + this.getName() + ": " + numberToCheck + " no es primo (" + e.getMessage() + ")");
        }
    }
}