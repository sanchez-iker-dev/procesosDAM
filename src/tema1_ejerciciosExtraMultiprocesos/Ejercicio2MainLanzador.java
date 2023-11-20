package tema1_ejerciciosExtraMultiprocesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio2MainLanzador {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cuantos procesos quieres tener?");
		int numeroProcesos = sc.nextInt();
	
		ProcessBuilder pb = new ProcessBuilder("java","-cp","./bin","ejerciciosExtraMultiprocesos/Ejercicio2Output");;
		Process p = null;
		String cadena = "";
		BufferedReader br = null;
		Process[] procesos = new Process[numeroProcesos];
		
		for (int i = 0; i < numeroProcesos; i++) {
			
			try {
				p = pb.start();
				procesos[i]=p;
			}  catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
				
		try {
			for (int i = 0; i < procesos.length; i++) {
				br = new BufferedReader(new InputStreamReader(procesos[i].getInputStream()));	
				Thread.sleep(5000);
				
					cadena= br.readLine();
					if(cadena==null) {break;}
					System.out.println(cadena);
					procesos[i].destroy();
					
				
			}
		}  catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		sc.close();
	}

}
