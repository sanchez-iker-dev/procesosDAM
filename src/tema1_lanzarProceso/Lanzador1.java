package tema1_lanzarProceso;

import java.io.File;
import java.io.IOException;

public class Lanzador1 {

	public static void main(String[] args) {
		
		File resultado = new File("resultado.txt");
		File a = new File("a.txt");
		File b = new File("b.txt");
		File c = new File("c.txt");
		File d = new File("d.txt");
		
		long inicio=0L;
		long fin=1000000000*4L;
		
		try {
			
			//marca temporal justo antes 
			try {
				resultado.createNewFile();
				a.createNewFile();
				b.createNewFile();
				c.createNewFile();
				d.createNewFile();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			ProcessBuilder pb = new ProcessBuilder("java","-cp","./bin","lanzarProceso/Sumador1",inicio+"",fin+"",(crono()+""));
			pb.redirectOutput(resultado);
			pb.start();
			//lanzando 4 procesos
			long tiempo =System.currentTimeMillis();
			
			ProcessBuilder pb1 = new ProcessBuilder("java","-cp","./bin","lanzarProceso/Sumador1",inicio+"",fin/4+"",(tiempo+""));
			pb1.redirectOutput(a);
			pb1.start();
			
			ProcessBuilder pb2 = new ProcessBuilder("java","-cp","./bin","lanzarProceso/Sumador1",(fin/4)+1+"",fin/2+"",(tiempo+""));
			pb2.redirectOutput(b);
			pb2.start();
			
			ProcessBuilder pb3 = new ProcessBuilder("java","-cp","./bin","lanzarProceso/Sumador1",(fin/2)+1+"",3*(fin/4)+"",(tiempo+""));
			pb3.redirectOutput(c);
			pb3.start();
			
			ProcessBuilder pb4 = new ProcessBuilder("java","-cp","./bin","lanzarProceso/Sumador1",3*(fin/4)+1+"",fin+"",(tiempo+""));
			pb4.redirectOutput(d);
			pb4.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// crear una funcion encima del main para llamar al constructor y asi no crear 4 pb
	
	static long crono() {
		return System.currentTimeMillis();
	}
}


