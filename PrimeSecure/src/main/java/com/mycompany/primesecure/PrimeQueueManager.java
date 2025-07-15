import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

// Maneja una cola concurrente de tareas relacionadas con primos
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