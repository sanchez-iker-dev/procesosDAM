package tema2_ComunicacionThread;

public class MiMain {

	public static void main(String[] args) throws InterruptedException {
		
		Mensaje m1 = new Mensaje("Este es el mensaje sin modificar");
		
		System.out.println(m1.getMensaje());
		
		Thread t1 = new Thread(new MiThread(m1));
		
		t1.start();
		
		Thread.sleep(3000);
		
		System.out.println(m1.getMensaje());
		

	}

}
