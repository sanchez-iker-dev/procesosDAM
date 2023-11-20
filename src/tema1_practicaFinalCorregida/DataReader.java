package tema1_practicaFinalCorregida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

	public static void main(String[] args) {

		File file = new File("data.dat");

		try {
			BufferedReader bur = new BufferedReader(new FileReader(file));

			String linea;
			int numLineas = Integer.parseInt(args[0]); // sera args[n]
			while ((linea = bur.readLine()) != null) {
				String data = "";
				for (int i = 1; i < numLineas; i++) {
					if ((data = bur.readLine()) != null) {
						linea += data;
					}
				}
					System.out.println(linea);
			}

			bur.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
