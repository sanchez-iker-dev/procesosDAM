package tema3_monitoresDosVariablesMasMas;

import java.util.ArrayList;
import java.util.Scanner;

public class MainThread implements Runnable {
	

    private static long c1 = 0;
    private static long c2 = 0;
    private static Object candado1 = new Object();
    private static Object candado2 = new Object();

    public static void main(String[] args) throws InterruptedException {
    	
    	
    	MainThread m1 = new MainThread();
    	
    	long tiempo = System.currentTimeMillis();
    	
    	System.out.println( tiempo + " inicio");

        ArrayList<Thread> hilos = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("¿Cuántos hilos quieres tener?");

        int numeroHilos = sc.nextInt();

        for (int i = 0; i < numeroHilos; i++) {
            Thread t = new Thread(m1);
            t.start();
            hilos.add(t);
        }

        for (Thread thread : hilos) {
            thread.join();
        }

        System.out.println(c1);
        System.out.println(c2);
        

        sc.close();
        
        System.out.println( System.currentTimeMillis() - tiempo  + " final");
        
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (candado1) {
                inc1();
            }
            synchronized (candado2) {
                inc2();
            }
        }
    }

    private static void inc1() {
    	c1++;
    }

    private static void inc2() {
        c2++;
    }
}
