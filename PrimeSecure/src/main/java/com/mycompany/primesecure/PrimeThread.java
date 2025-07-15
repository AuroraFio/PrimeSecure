import java.util.Random;

// Hilo que verifica y añade números primos a la lista
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
        // Genera y verifica un primo del 2 al 10_000
        do {
            number = 2 + rand.nextInt(9999);
        } while (!PrimeList.isPrime(number));

        // Sincroniza acceso a la lista
        synchronized (lock) {
            primesList.add(number);
            lock.notify(); // Notifica otro hilo
        }
    }
}