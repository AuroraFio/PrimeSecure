package com.mycompany.primesecure;

public class Main {
    public static void main(String[] args) {
        PrimeList primeList = new PrimeList();

        // Números a verificar/agregar
        int[] numeros = {2, 3, 4, 5, 15, 17, 19, 20, 23, 25, 29, 33, 37};

        // Creamos y arrancamos un hilo por cada número
        Thread[] threads = new Thread[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            threads[i] = new PrimeAdderThread(primeList, numeros[i]);
            threads[i].start();
        }

        // Esperamos que todos los hilos terminen
        for (Thread t : threads) {
            try { t.join(); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        // Imprimimos el resultado final
        System.out.println("\nLista final de primos: " + primeList);
        System.out.println("Cantidad total de primos: " + primeList.getPrimesCount());
    }
}