package tema1_lanzarProceso;



public class Sumador1 {

	public static void main(String[] args) {
		
		long inicio = Long.parseLong(args[0]);
		long fin = Long.parseLong(args[1]);
		long time = Long.parseLong(args[2]); 
		
		long resultado = inicio;
		for (long i = inicio+1; i <=fin; i++) {
			resultado += i;
		}
		// aqui pones el fin del contador,cuando todo el proceso haya acabado
		System.out.println("El tiempo que ha tardado es: "+ totalTime(time)+ " milisegundos");
		System.out.println("El resultado de la suma es: "+resultado);
		
		
	}

	static long totalTime(long tiempo) {
		
		long tiempoTotal = (System.currentTimeMillis()- tiempo);
		
		return tiempoTotal;
	}
}
