package tema3_productorConsumidor;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Lanzadores {

	static ArrayList<Productos> productos = new ArrayList<>();
	static ArrayList<Thread> hilos = new ArrayList<>();
	static Object locker = new Object();
	
	public static void main ( String [] args) throws InterruptedException {
		
		
		
		Productor producer = new Productor("Iker Sanchez");
		
		Scanner sc = new Scanner(System.in);
		
		int numberOfConsumer=0;
		
		
		 Timer timer = new Timer();
		 
	        timer.scheduleAtFixedRate(new TimerTask() {
	        	
	            @Override
	            public void run() {
	            
	               synchronized (locker) {
	            	   producer.mirarSiHayProductos(productos);
	            	   
	            	   for (Productos x : productos) {
		            	   
	   					System.out.println(x.getNombre() + " " + " y cuesta " + x.getPrecio());
	   					
	   				}
	            	   System.out.println();
	   					System.out.println();
				}
	               
	               
	            }
	        }, 0, 2000);
		
	        System.out.println("Cuantos consumirdores quieres ? ");
	        
			numberOfConsumer = sc.nextInt();
	       
		
		for (int i = 0; i < numberOfConsumer; i++) {
			
			Consumidor c1 = new Consumidor("Consumidor " + i,productos,locker);
			
			Thread t1 = new Thread(c1);
			t1.start();
			hilos.add(t1);
		}
		
		for (Thread hilo : hilos) {
			
			hilo.join();
		}
		
		cerrar(sc);
	}
	
	
	static void cerrar(Scanner sc) {
		sc.close();
	}
}
