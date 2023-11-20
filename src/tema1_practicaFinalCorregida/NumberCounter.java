package tema1_practicaFinalCorregida;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class NumberCounter {

    // HashMap para almacenar el recuento de ocurrencias de cada dígito
    static HashMap<Integer, Long> digitCounts = new HashMap<Integer, Long>();

    public static void main(String[] args) {

        // Inicializar el HashMap con recuento de dígitos a cero
        for (int i = 0; i < 10; i++) {
            digitCounts.put(i, (long) 0);
        }

        // Scanner para leer las líneas de entrada
        Scanner scanner = new Scanner(System.in);
        String inputLine;

        try {
            // Leer líneas hasta que se alcance el final de la entrada
            while ((inputLine = scanner.nextLine()) != null) {
                // Contar los dígitos en la línea
                countDigits(inputLine);
            }
        } catch (NoSuchElementException e) {
            // Capturar excepción NoSuchElementException (final de entrada)
        }

        // Imprimir el recuento de ocurrencias de dígitos
        System.out.println(digitCounts.values());

        scanner.close();
    }

    // Método para contar ocurrencias de dígitos en una cadena
    public static void countDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Verificar si el carácter es un dígito
            if (Character.isDigit(currentChar)) {
                int digit = Character.getNumericValue(currentChar);
                // Incrementar el recuento para el dígito correspondiente
                digitCounts.put(digit, digitCounts.get(digit) + 1);
            }
        }
    }
}