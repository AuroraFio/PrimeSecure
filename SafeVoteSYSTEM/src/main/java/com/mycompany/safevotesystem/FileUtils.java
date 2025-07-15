package com.mycompany.safevotesystem;

import java.io.*;
import java.util.List;

public class FileUtils {

    // Carga números primos desde un archivo CSV (un número por línea)
    public static void loadPrimesFromCSV(String filePath, PrimesList primesList) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int prime = Integer.parseInt(line.trim());
                    primesList.add(prime);
                } catch (NumberFormatException e) {
                    // Ignorar líneas no válidas
                } catch (IllegalArgumentException e) {
                    // Ignorar números no primos
                }
            }
        }
    }

    // Guarda mensajes encriptados y sus códigos primos en un archivo de texto
    public static void saveEncryptedMessagesWithPrimes(String filePath, List<String> encryptedMessages, List<Integer> primeCodes) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int i = 0; i < encryptedMessages.size(); i++) {
                writer.write(encryptedMessages.get(i) + " - Código Primo: " + primeCodes.get(i) + "\n");
            }
        }
    }
}
