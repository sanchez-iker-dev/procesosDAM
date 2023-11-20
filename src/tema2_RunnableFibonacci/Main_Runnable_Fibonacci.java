package tema2_RunnableFibonacci;

import java.util.Scanner;

public class Main_Runnable_Fibonacci {

	public static void main(String[] args) {
		
		int n;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿ Cuántos números quieres ?");
		
		n = sc.nextInt();
		
		Thread t1 = new Thread(new Runnable_Fibonacci(n));
		
		t1.start();
		
		cerrarScanner(sc);
	}

	static  void cerrarScanner(Scanner sc) {
		sc.close();
	}
}
