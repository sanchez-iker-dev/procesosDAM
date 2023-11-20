package tema2_Semaforos_Worker_Generator;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class classRunnable implements Runnable {
	
	private ArrayList<Worker> listaWorker;
	
	private ArrayList<Generator> listaGenerator;
	
	private ArrayList<Semaphore> listaSemaforos;
	
	
	classRunnable(ArrayList<Worker> listaWorker,ArrayList<Generator> listaGenerator,ArrayList<Semaphore> listaSemaforos){
		
		this.listaWorker = listaWorker;
		
		this.listaGenerator=listaGenerator;
		
		this.listaSemaforos = listaSemaforos;
		
	}
	

	

	@Override
	public void run() {
		
		
		
	}
	
	
	// SETTERS Y GETTERS ->->->->->->->->->
	


	public ArrayList<Worker> getListaWorker() {
		return listaWorker;
	}


	public void setListaWorker(ArrayList<Worker> listaWorker) {
		this.listaWorker = listaWorker;
	}


	public ArrayList<Generator> getListaGenerator() {
		return listaGenerator;
	}


	public void setListaGenerator(ArrayList<Generator> listaGenerator) {
		this.listaGenerator = listaGenerator;
	}

	public ArrayList<Semaphore> getListaSemaforos() {
		return listaSemaforos;
	}


	public void setListaSemaforos(ArrayList<Semaphore> listaSemaforos) {
		this.listaSemaforos = listaSemaforos;
	}

	
	

}
