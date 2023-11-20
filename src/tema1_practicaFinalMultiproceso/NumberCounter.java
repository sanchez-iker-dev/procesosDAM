package tema1_practicaFinalMultiproceso;


public class NumberCounter {

	public static void main(String[] args)  {
		
		String cadena = args[0];
		
		int array[] = new int[10];
		
		for (int i = 0; i < cadena.length(); i++) {
			String letra = cadena.charAt(i)+"";
			if (isNumeric(letra)) {
				int index=Integer.parseInt(letra);
				array[index]=array[index]+1;
			}
		}
		 for (Object o : array){
			   System.out.println(o);
			}
	}

	 static boolean isNumeric(String chain) {
		 
	    if (chain == null) {
	        return false;
	    }
	    try {
	    	
	        for (int i = 0; i < chain.length(); i++) {
				if((int)chain.charAt(i)!=0) return true;
			}
	        return true;
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    
	}
}

