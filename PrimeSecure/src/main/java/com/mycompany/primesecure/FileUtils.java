package com.mycompany.primesecure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
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

    public static void writeEncryptedMessage(String filePath, String message, int primeCode) throws IOException {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write("Mensaje: " + message + " | Código primo: " + primeCode + "\n");
        }
    }
}