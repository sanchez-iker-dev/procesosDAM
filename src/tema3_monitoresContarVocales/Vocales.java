package tema3_monitoresContarVocales;


public class Vocales implements Runnable {

	String letra,palabra;	
	
	int contador;
	
	String [] letras ;
	
	Vocales (String letra, String palabra){
		
		this.letra= letra;
		this.palabra = palabra;
	
	}
	
	@Override
	public void run() {
		
		letras = palabra.split("");
		
		for (String caracter : letras) {
			
			
			if (caracter.contains(letra)) {
				
				incCounter();
			}
		}
		
	}

	synchronized void incCounter() {
		contador++;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	
	
	
}
