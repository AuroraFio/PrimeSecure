import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Clase principal
public class SafeVoteSystem {
    public static void main(String[] args) throws Exception {
        Object lock = new Object();
        PrimeList primesList = new PrimeList();

        // Colección sincronizada
        List<Integer> synchronizedList = Collections.synchronizedList(primesList);

        // Carga inicial de primos desde archivo
        List<Integer> filePrimes = FileUtils.readPrimesFromCSV("primes.csv");
        synchronizedList.addAll(filePrimes);

        // Cola y topic
        PrimeQueueManager queueManager = new PrimeQueueManager();
        Topic topic = new Topic();

        // Bloqueo explícito
        Lock reentrantLock = new ReentrantLock();

        // Crea y lanza hilos
        int numThreads = 5;
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new PrimeThread(primesList, lock));
            threads[i].start();
        }

        // Espera la finalización de hilos
        for (Thread t : threads) t.join();

        // Prueba de cola y topic
        queueManager.enqueue(17);
        queueManager.enqueue(19);
        topic.publish(23);

        // Uso de lock para acceso seguro
        reentrantLock.lock();
        try {
            // Agrega un primo protegido por lock
            primesList.add(29);
        } finally {
            reentrantLock.unlock();
        }

        // Escribe mensaje cifrado con código primo
        FileUtils.writeEncryptedMessage("mensajes.txt", "Mensaje de prueba", 17);

        // Muestra cantidad de primos
        System.out.println("Cantidad de números primos: " + primesList.getPrimesCount());
    }
}