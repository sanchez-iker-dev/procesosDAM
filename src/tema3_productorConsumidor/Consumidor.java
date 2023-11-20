package tema3_productorConsumidor;

import java.util.ArrayList;

public class Consumidor implements Runnable{

	private String nombre;
	
	ArrayList<Productos> stock;
	
	int longitud;
	
	Object locker = new Object();
	
	

	public Consumidor(String nombre, ArrayList<Productos> stock, Object o) {
		
		this.nombre = nombre;
		this.stock = stock;
		this.locker = o;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		
		int vecesQueCompra=(int)(Math.random()*3);
		
		synchronized (locker) {
			
			for (int i = 0; i < vecesQueCompra; i++) {
				ComprarProducto();
			}
		}
		
		
	} // fin del run
	
	void ComprarProducto(){
		
		int posicionProducto = (int) Math.round((Math.random()*(stock.size()-1)));
		
		try {
			
			longitud = stock.size();
			
			if (longitud>0) {
				
				Thread.sleep(1000);
				
				if (longitud == stock.size()) {
					
					stock.remove(posicionProducto);
				}
			}
			
		} catch (InterruptedException e) {
			
			
			e.printStackTrace();
		}
	}
	
	
	
}
