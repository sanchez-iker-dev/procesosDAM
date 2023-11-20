package tema1_ejerciciosExtraMultiprocesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio3MainLanzador {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String command=null;
		System.out.println("Que comando quieres ejecutar");
		command = sc.nextLine();
		
		ProcessBuilder pb = new ProcessBuilder("java","-cp","./bin","tema1_ejerciciosExtraMultiprocesos/Ejercicio3Ejecutor",command);
		try {
			Process p = pb.start();

			BufferedReader entrada = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String linea;
            while ((linea = entrada.readLine()) != null) {
                System.out.println(linea);
            }

            entrada.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		sc.close();
	}

}
