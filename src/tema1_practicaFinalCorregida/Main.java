package tema1_practicaFinalCorregida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner escaner = new Scanner(System.in);

        System.out.println("¿Cuántas líneas quieres que mande el LectorDeDatos al Principal?");
        String lineasRecibidas = escaner.next();
        System.out.println("¿Cuántos contadores de números quieres que lance el programa?");
        int cantidadContadores = escaner.nextInt();

        ProcessBuilder constructorProcesoLector = new ProcessBuilder("java", "-cp", "./bin", "tema1_practicaFinalCorregida/DataReader", lineasRecibidas);
        constructorProcesoLector.redirectError(new File("errorLector"));

        Process procesoLector = constructorProcesoLector.start();
        BufferedReader lectorLector = new BufferedReader(new InputStreamReader(procesoLector.getInputStream()));

        ProcessBuilder constructorProcesoContador = new ProcessBuilder("java", "-cp", "./bin", "tema1_practicaFinalCorregida/NumberCounter");

        constructorProcesoContador.redirectError(new File("errorContador"));

        Process[] procesosContador = new Process[cantidadContadores];
        BufferedWriter[] escritores = new BufferedWriter[cantidadContadores];
        BufferedReader[] lectores = new BufferedReader[cantidadContadores];

        for (int i = 0; i < cantidadContadores; i++) {

            procesosContador[i] = constructorProcesoContador.start(); // Esto será una lista de procesos contador

            escritores[i] = new BufferedWriter(new OutputStreamWriter(procesosContador[i].getOutputStream()));

            lectores[i] = new BufferedReader(new InputStreamReader(procesosContador[i].getInputStream()));
        }

        String datos;
        int contador = 0;
        while ((datos = lectorLector.readLine()) != null) {
            escritores[contador].write(datos);
            escritores[contador].newLine();
            escritores[contador].flush();
            contador++;
            if (contador == cantidadContadores) {
                contador = 0;
            }
        }

        ArrayList<String[]> resultados = new ArrayList<String[]>();

        for (int i = 0; i < cantidadContadores; i++) {
            escritores[i].close();
            String leido = lectores[i].readLine();
            if (leido != null) {
                leido = leido.replace("]", "");
                resultados.add(leido.replace("[", "").split(", "));
            }
        }
        calcularResultado(resultados);

        escaner.close();
    }

    private static void calcularResultado(ArrayList<String[]> resultados) {
        int[] res = new int[10];

        for (String[] s : resultados) {
            for (int i = 0; i < s.length; i++) {
                res[i] += Integer.parseInt(s[i]);
            }
        }

        for (int i = 0; i < res.length; i++) {
            System.out.println(i + "=" + res[i]);
        }
    }
}