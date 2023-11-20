package tema1_ejerciciosExtraMultiprocesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1MainLanzador {

	public static void main(String[] args) {
		String cadena ="";
		int contador=0;
		ProcessBuilder pb = new ProcessBuilder("java","-cp","./bin","ejerciciosExtraMultiprocesos/Ejercicio1Output");
		Process p = null;
		try { 
			p = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));			
			while (contador!=5) {
				cadena = br.readLine();
				Thread.sleep(1000);
				contador++;
				System.out.println(cadena);
			}
		} catch (InterruptedException e ){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
