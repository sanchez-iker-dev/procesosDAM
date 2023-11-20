package tema3_productorConsumidor;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Productor {

	private String nombre;
	DecimalFormat df = new DecimalFormat("#.##");

	public Productor(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	 
	
	ArrayList<Productos> mirarSiHayProductos(ArrayList<Productos> stock) {
		
		if (stock.size()==0) {
			
			for (int i = 1; i < 11; i++) {
				
				Productos p1 = new Productos("Producto " +(i),(df.format((Math.random()*100))));
				stock.add(p1);
			}
		}
		return stock;
	}
	
	
}
