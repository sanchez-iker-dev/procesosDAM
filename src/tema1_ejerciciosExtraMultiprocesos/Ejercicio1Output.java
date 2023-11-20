package tema1_ejerciciosExtraMultiprocesos;

public class Ejercicio1Output {

	public static void main(String[] args) {
		
		int a = 1;
			while(a>0) {
				try {
					Thread.sleep(1000);
					System.out.println(a);
					a++;
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
			
		}
	}


