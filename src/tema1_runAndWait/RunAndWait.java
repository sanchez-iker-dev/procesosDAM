package tema1_runAndWait;

import java.util.Scanner;

public class RunAndWait {

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		
		System.out.println("proceso:");
		
		String s=input.nextLine();
		
		ProcessBuilder pb=new ProcessBuilder(s);
		try {
			pb.wait();
			input.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	}


