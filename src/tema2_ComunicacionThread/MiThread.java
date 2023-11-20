package tema2_ComunicacionThread;

public class MiThread implements Runnable{

	Mensaje m ;
	
	

	public MiThread(Mensaje m) {
		super();
		this.m = m;
	}
	
	@Override
		public void run() {
		
			m.setMensaje("Mensaje Modificado");
			
		}
}
