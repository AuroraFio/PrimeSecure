import java.util.LinkedList;
import java.util.Queue;

// Estructura tipo 'Topic' para pub/sub entre hilos
public class Topic {
    private final Queue<Integer> messages = new LinkedList<>();

    public synchronized void publish(int value) {
        messages.offer(value);
        notifyAll();
    }

    public synchronized int subscribe() throws InterruptedException {
        while (messages.isEmpty()) {
            wait();
        }
        return messages.poll();
    }
}