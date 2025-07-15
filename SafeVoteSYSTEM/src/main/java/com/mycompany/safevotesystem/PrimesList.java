package com.mycompany.safevotesystem;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class PrimesList extends ArrayList<Integer> {
    private final ReentrantLock lock = new ReentrantLock();

    public boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    @Override
    public boolean add(Integer n) {
        lock.lock();
        try {
            if (!isPrime(n)) throw new IllegalArgumentException("No es primo: " + n);
            return super.add(n);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean remove(Object o) {
        lock.lock();
        try {
            return super.remove(o);
        } finally {
            lock.unlock();
        }
    }

    public int getPrimesCount() {
        lock.lock();
        try {
            return this.size();
        } finally {
            lock.unlock();
        }
    }
}