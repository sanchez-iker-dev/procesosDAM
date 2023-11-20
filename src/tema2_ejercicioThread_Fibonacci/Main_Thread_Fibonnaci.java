package tema2_ejercicioThread_Fibonacci;

import java.util.Scanner;

public class Main_Thread_Fibonnaci {

	public static void main(String[] args) {
		
		int consola;
		Scanner sc = new Scanner(System.in);
		System.out.println("¿ Qué número quieres de la serie fibonacci ?");
		consola = sc.nextInt();
		
		Thread t1 = new Thread_Fibonacci(consola);
		t1.start();
		
		sc.close();
	}

}
