package tema1_practicaFinalMultiproceso;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		String rutaFichero ="data.txt";
		String cadena,resultadoFinal = "";
		String entradaNumberCounter="";
		boolean fin=false;
		ProcessBuilder pb = new ProcessBuilder("java","-cp","./bin","practicaFinalMultiproceso/DataRead",rutaFichero);
		Process proceso1 = null;
		Process proceso2= null;
		pb.start();
		
		try {
			proceso1=pb.start();	
			BufferedReader br = new BufferedReader(new InputStreamReader(proceso1.getInputStream()));			
			while (!fin) {
				cadena = br.readLine();
				if(cadena==null) {fin=true;}
				else entradaNumberCounter=cadena ;
			}
			
			// aqui empezamos el numberCounter↓↓↓↓↓↓↓↓↓↓↓
			ProcessBuilder pb2 = new ProcessBuilder("java","-cp","./bin","practicaFinalMultiproceso/NumberCounter",entradaNumberCounter);
			proceso2=pb2.start();
			BufferedReader br2 = new BufferedReader(new InputStreamReader(proceso2.getInputStream()));			
			fin=false;
			while (!fin) {
				resultadoFinal = br2.readLine();
				if(resultadoFinal==null) {fin=true;}
				else System.out.println(resultadoFinal);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}//fin del try catch
			
		
	}

	
	
		
}
