import java.util.ArrayList;
import java.util.Collection;

// Lista de números primos con validaciones y métodos extra
public class PrimeList extends ArrayList<Integer> {
    // Verifica si el número es primo
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Override
    public boolean add(Integer e) {
        if (!isPrime(e)) throw new IllegalArgumentException("No es primo: " + e);
        return super.add(e);
    }

    @Override
    public void add(int index, Integer element) {
        if (!isPrime(element)) throw new IllegalArgumentException("No es primo: " + element);
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        for (Integer i : c) if (!isPrime(i)) throw new IllegalArgumentException("No es primo: " + i);
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        for (Integer i : c) if (!isPrime(i)) throw new IllegalArgumentException("No es primo: " + i);
        return super.addAll(index, c);
    }

    @Override
    public Integer remove(int index) {
        return super.remove(index);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    // Cantidad de primos
    public int getPrimesCount() {
        return this.size();
    }
}