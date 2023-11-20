package tema2_Semaforos_Worker_Generator;

public class Generator {

	int numeroAleatorio = (int) (Math.random()*100);
	String id;
	
	public Generator(String id) {
		this.id = id;
	}
	
	
	String interrumpt (){
		
		 Worker w1 = new Worker(id);
		
		 return w1.Por1000()+"";
	}
	

	public int getNumeroAleatorio() {
		return numeroAleatorio;
	}

	public void setNumeroAleatorio(int numeroAleatorio) {
		this.numeroAleatorio = numeroAleatorio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
