package com.mycompany.primesecure;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PrimeQueueManager {
    private final Queue<Integer> taskQueue = new ConcurrentLinkedQueue<>();

    public void enqueue(int primeCandidate) {
        taskQueue.offer(primeCandidate);
    }

    public Integer dequeue() {
        return taskQueue.poll();
    }

    public boolean isEmpty() {
        return taskQueue.isEmpty();
    }
}