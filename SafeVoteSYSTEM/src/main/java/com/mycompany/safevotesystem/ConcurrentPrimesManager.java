package com.safevotesystem;

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentPrimesManager {
    private final Queue<Integer> primeQueue = new ConcurrentLinkedQueue<>();
    private final List<String> topic = Collections.synchronizedList(new ArrayList<>());

    public void addPrimeToQueue(int prime) {
        primeQueue.add(prime);
    }

    public Integer pollPrimeFromQueue() {
        return primeQueue.poll();
    }

    public void publishToTopic(String message) {
        topic.add(message);
        synchronized (topic) {
            topic.notifyAll();
        }
    }

    public String consumeFromTopic() throws InterruptedException {
        synchronized (topic) {
            while (topic.isEmpty()) {
                topic.wait();
            }
            return topic.remove(0);
        }
    }
}