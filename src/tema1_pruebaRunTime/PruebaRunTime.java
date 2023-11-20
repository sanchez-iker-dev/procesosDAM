package tema1_pruebaRunTime;

import java.io.IOException;
import java.util.Arrays;

public class PruebaRunTime {

	public static void main(String[] args) {
		
		// comando pasado por parametro args
		try {
			Process proceso = Runtime.getRuntime().exec(args);
			
			//Esperamos 3 segundos y lo destruimos
			//Thread.sleep(3000);
			//proceso.destroy();
			int result = proceso.waitFor();
			
			if (result==0) 
				System.out.println("El comando " + Arrays.toString(args) + " se ha ejecutado correctamente");
			else 
				System.out.println("Error, el comando " + Arrays.toString(args) +" no ha podido ser ejecutado. Error "+ result);
			
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
