import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Métodos para lectura y escritura de archivos
public class FileUtils {
    // Lee números primos de un archivo CSV (una columna)
    public static List<Integer> readPrimesFromCSV(String filePath) throws IOException {
        List<Integer> primes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int num = Integer.parseInt(line.trim());
                    if (PrimeList.isPrime(num)) primes.add(num);
                } catch (NumberFormatException ignore) {}
            }
        }
        return primes;
    }

    // Escribe mensaje y código primo en un archivo
    public static void writeEncryptedMessage(String filePath, String message, int primeCode) throws IOException {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write("Mensaje: " + message + " | Código primo: " + primeCode + "\n");
        }
    }
}