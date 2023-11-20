package tema1_practicaFinalMultiproceso;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class DataRead {
static String cadena ="";
	public static void main(String[] args) throws IOException {
		File f = new File(args[0]);
		leerFichero(f);
		//System.out.println(cadena);
	}

	static String leerFichero(File f){
		 try (BufferedReader br = new BufferedReader(new FileReader(f))) {
	  
	            while (((cadena = br.readLine()) != null)){
	              System.out.println(cadena);
	            }
	            return cadena;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "error: No se pudo leer";
	        }
	}
}
