package tema2_Semaforos_Worker_Generator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

	static ArrayList<Worker> listaWorker = new ArrayList<>();
	
	static ArrayList<Generator> listaGenerator = new ArrayList<>();
	
	static ArrayList<Thread> listaHilos = new ArrayList<>();
	
	static Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) {
		
		create_Add(); // aqui creo y aniado todos los workers y generator que el usuario quiera y los aniado a las listas
		
		ArrayList<Semaphore> listaSemaphore = new ArrayList<>();
		
		for (int i = 0; i < listaWorker.size(); i++) {
			
			Semaphore s = new Semaphore(1);
			
			listaSemaphore.add(s);
			
		}
		
		for (int i = 1; i < listaWorker.size()+1; i++) {
			
			Thread t = new Thread(new classRunnable(listaWorker,listaGenerator,listaSemaphore));
			
			t.setName("Thread "+ i);
			
			listaHilos.add(t);
			
		}
		
		for (Generator g : listaGenerator) {
			System.out.println(g.getId());
		}
		for (Worker w : listaWorker) {
			System.out.println(w.getId());
		}
		
		
	}
	
	static void create_Add(){
		
		
		int numeroWorkers;
		
		System.out.println("¿ Cuántos workers quieres tener ? ");
		
		numeroWorkers = sc.nextInt();
		
		
		
		for (int i = 0; i < numeroWorkers; i++) {
			
			Worker w = new Worker("Worker "+(i+1));
			listaWorker.add(w);
		}
		
		for (int i = 0; i < (numeroWorkers * 10); i++) {
			
			Generator g = new Generator("Generator " + (i+1));
			listaGenerator.add(g);
		}
		sc.close();
	}

	
	
	
}
