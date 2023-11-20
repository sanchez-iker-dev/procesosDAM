package tema2_RunnableFibonacci;

public class Runnable_Fibonacci implements Runnable {
private int number;
 

	public Runnable_Fibonacci(int number) {
		this.number = number;
}

	@Override
	public void run() {
		 System.out.println("Los primeros " + number + " términos de la serie de Fibonacci son:");
	        for (int i = 0; i < number; i++) {
	            System.out.print(calcular_Fibonacci(i) + " ");
	        }
		
	}

	int calcular_Fibonacci(int n) {
		if(n<=1) {
			return n;
		}else {
			return calcular_Fibonacci(n-1)+calcular_Fibonacci(n-2);
		}
	}
}
