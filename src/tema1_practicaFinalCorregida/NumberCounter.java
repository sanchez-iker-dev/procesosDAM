package tema1_practicaFinalCorregida;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class NumberCounter {

    // HashMap para almacenar el recuento de ocurrencias de cada d�gito
    static HashMap<Integer, Long> digitCounts = new HashMap<Integer, Long>();

    public static void main(String[] args) {

        // Inicializar el HashMap con recuento de d�gitos a cero
        for (int i = 0; i < 10; i++) {
            digitCounts.put(i, (long) 0);
        }

        // Scanner para leer las l�neas de entrada
        Scanner scanner = new Scanner(System.in);
        String inputLine;

        try {
            // Leer l�neas hasta que se alcance el final de la entrada
            while ((inputLine = scanner.nextLine()) != null) {
                // Contar los d�gitos en la l�nea
                countDigits(inputLine);
            }
        } catch (NoSuchElementException e) {
            // Capturar excepci�n NoSuchElementException (final de entrada)
        }

        // Imprimir el recuento de ocurrencias de d�gitos
        System.out.println(digitCounts.values());

        scanner.close();
    }

    // M�todo para contar ocurrencias de d�gitos en una cadena
    public static void countDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Verificar si el car�cter es un d�gito
            if (Character.isDigit(currentChar)) {
                int digit = Character.getNumericValue(currentChar);
                // Incrementar el recuento para el d�gito correspondiente
                digitCounts.put(digit, digitCounts.get(digit) + 1);
            }
        }
    }
}