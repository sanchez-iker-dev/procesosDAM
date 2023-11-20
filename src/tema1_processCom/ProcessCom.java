package tema1_processCom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProcessCom {

	// Haz un programa ProcessCom que crea otro proceso ( ping ) pasado por linea de comando y recupere la salida de ese proceso para
	// escribirlo en la consola del padre
	
	public static void main(String [] args) throws IOException {
		Process p  = new ProcessBuilder(args).start();
		InputStream is = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		
		System.out.println("Salida del proceso: "+ Arrays.toString(args));
	
		while ((line=br.readLine())!=null) {
			System.out.println(line);
		}
	} 
}
