import java.util.ArrayList;

public class Ejecutor {

	public static void main(String[] args) {
		long inicio = System.nanoTime();
		ArrayList<String> ficheros = new ArrayList<String>();
		ficheros.add("/home/alumno/repos/psp-c/prog12-productorSeparado/main.c");
		ficheros.add("/home/alumno/repos/psp-c/prog12-productorSeparado/Makefile");
		ficheros.add("/home/alumno/repos/psp-c/prog12-productorSeparado/funciones.c");
		ficheros.add("/home/alumno/repos/psp-c/prog12-productorSeparado/funciones.h");
		ficheros.add("/home/alumno/repos/psp-c/prog12-productorSeparado/productor.c");
		
		ArrayList<HiloEjecutor> listaHilos = new ArrayList<HiloEjecutor>();
		
		//Se van ejecutando paralelamente
		for(String rutaFichero : ficheros) {
			listaHilos.add(new HiloEjecutor(rutaFichero));
		}
		System.out.println("Hilos creados tardé " + (System.nanoTime()-inicio)/1000000 + " ms.");
		
		for(HiloEjecutor hilo : listaHilos) {
			hilo.start();
		}
		System.out.println("Hilos lanzados tardé " + (System.nanoTime()-inicio)/1000000  + " ms.");
		
		for(HiloEjecutor hilo : listaHilos) {
			try {
				hilo.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Hilos finalizados tardé " + (System.nanoTime()-inicio)/1000000  + " ms.");
		
		//HiloEjecutor h1 = new HiloEjecutor(rutaFichero);
		//h1.start();
	}

}
