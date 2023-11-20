package tema3_monitoresContarVocales;

import java.util.ArrayList;
import java.util.Scanner;


public class MainContarVocales  {
	

	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		
		String palabra="";
		
		int contadorTotal = 0;
		
		ArrayList<Thread> hilos = new ArrayList<>();
		
		System.out.println("Que palabra quieres");
		
		palabra = sc.nextLine();
		
		String [] vocales = {"a","e","i","o","u"};
	
		ArrayList<Vocales> vs = new ArrayList<>();
		
		
		
		for (int i = 0; i < 5; i++) {
			
			Vocales v1 =new Vocales(vocales[i], palabra);
			
			vs.add(v1);
			
			Thread t1 = new Thread (v1);
			
			t1.start();
			
			hilos.add(t1);
		}
		
		for (Thread thread : hilos) {
			thread.join();
		} 
		
		for (int i = 0; i < 5; i++) {
			contadorTotal+= vs.get(i).getContador();
		}
		System.out.println(contadorTotal);
		
		sc.close();
		
	}


}
