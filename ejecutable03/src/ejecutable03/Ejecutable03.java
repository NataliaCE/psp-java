package ejecutable03;

import java.io.IOException;

public class Ejecutable03 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ProcessBuilder constructor = new ProcessBuilder("firefox");
		Process firefox = constructor.start();
		
		System.out.println(firefox.pid());
		//esta linea detiene la ejecucion (sin afectar al procesador) durante los
		//milisegundos del parámetro.
		Thread.sleep(3000);
		if(firefox.isAlive()) {
			System.out.println("El proceso está vivo y con el pid: " + firefox.pid());
		} else {
			System.out.println("El proceso está muerto.");
		}
		
		firefox.destroy();
		Thread.sleep(1000);
		
		if(firefox.isAlive()) {
			System.out.println("El proceso está vivo y con el pid: " + firefox.pid());
		} else {
			System.out.println("El proceso está muerto.");
		}
	}

}
