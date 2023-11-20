package tema2_ejercicioThread_Fibonacci;

public class Thread_Fibonacci extends Thread {
	private int number;
	public Thread_Fibonacci (int n) {
		this.number = n;
	}
	@Override
	public void run() {
		 System.out.println("Los primeros " + number + " términos de la serie de Fibonacci son:");
	        for (int i = 0; i < number; i++) {
	            System.out.print(calcular_Fibonacci(i) + " ");
	        }
	}
	   public int calcular_Fibonacci(int n) {
		    if (n <= 1) {
	            return n;
	        } else {
	            return calcular_Fibonacci(n - 1) + calcular_Fibonacci(n - 2);
	        }
	    }
}
