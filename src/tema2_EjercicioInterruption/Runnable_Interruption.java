package tema2_EjercicioInterruption;

public class Runnable_Interruption implements Runnable{

	int i = 0;
	
	@Override
	public void run() {
		
		i++;
		System.out.println("Me aburro de esperar " + i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
