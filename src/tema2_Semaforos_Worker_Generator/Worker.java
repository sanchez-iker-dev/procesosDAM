package tema2_Semaforos_Worker_Generator;



public class Worker {

	private String numero;
	String id ;
	
	long Por1000(){
		
		 numero = Long.parseLong(numero)*1000 +"";
		 return 1;
	}

	Worker(String id){
		this.id= id;
	}
	

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
