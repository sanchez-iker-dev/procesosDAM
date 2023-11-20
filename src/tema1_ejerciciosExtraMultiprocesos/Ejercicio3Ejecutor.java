package tema1_ejerciciosExtraMultiprocesos;

import java.io.*;

public class Ejercicio3Ejecutor {
    public static void main(String[] args) {
        try {
            Process proceso = Runtime.getRuntime().exec(args[0]);
            
            BufferedReader entrada = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String linea;
            while ((linea = entrada.readLine()) != null) {
                System.out.println(linea);
            }

            entrada.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}