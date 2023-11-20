package tema2_EjercicioInterruption;



public class MainInterruption {

	public static void main(String[] args) {
		
		
		Thread t1 = new Thread(new Runnable_Interruption());

		t1.start();
		
		try {
			System.out.println("he creado el runnable y el hijo esta vivo "+ t1.isAlive());
			
			Thread.sleep(5000);
			
			t1.interrupt();
			
			t1.join();
			
			System.out.println("he acabado el runnable y el hijo esta vivo "+ t1.isAlive());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	
}
