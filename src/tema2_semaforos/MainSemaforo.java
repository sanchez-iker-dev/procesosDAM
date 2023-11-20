package tema2_semaforos;

import java.util.concurrent.Semaphore;

public class MainSemaforo implements Runnable {

    static long x = 0;
   
    Semaphore semaphore;

    MainSemaforo(Semaphore s) {
        this.semaphore = s;
    }

    public static void main(String[] args) throws InterruptedException {
    	
    	Semaphore s = new Semaphore(1);// mutex => Semaforo con 1 recurso

        Thread t1 = new Thread(new MainSemaforo(s));
        t1.start();

        Thread t2 = new Thread(new MainSemaforo(s));
        t2.start();

        t1.join();
        t2.join();

        System.out.println(x);
    }

    @Override
    public void run() {

	          for (int i = 0; i < 10000; i++) {
	        	 try {  
	            	semaphore.acquire(); // El hilo adquiere el semáforo
	            	
	            	long temp= x;
	            	temp++;
	            	x = temp;
	            
	            	semaphore.release(); // El hilo libera el semáforo
		           
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        } 
	        	 
	          }// fin del for
    }
}