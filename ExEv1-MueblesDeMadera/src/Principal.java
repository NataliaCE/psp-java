
public class Principal {

	public static void main(String[] args) throws InterruptedException {
		//crear un objeto finalCarpintero (clase Object)
		Object finalCarpintero = new Object();
		//Crear el aserradero
		Aserradero ase = new Aserradero();
		// Crear 2 lenyadores pasándoles el aserradero y lanzarlos.
		new Thread(new Lenyador(ase)).start();
		new Thread(new Lenyador(ase)).start();
		// Crear un carpintero. Pasándole el aserradero, el Objeto para que notifique que
		// ya ha terminado y el número de muebles que tiene que hacer y lanzarlo.
		Carpintero car = new Carpintero(ase, finalCarpintero, 10);
		car.start();
		//Esperar la notificación sobre el objeto finalCarpinteros.
		synchronized (finalCarpintero) {
			finalCarpintero.wait();
		}
		//imprimir el estado del aserradero.
		System.out.println(ase.aserraderoParado());
		//Esperar al carpintero con join.
		car.join();
		//Parar el aserradero.
		ase.parar();
		//esperar la finalización de los lenyadores con join.
		//imprimir el estado final del aserradero.
	}

}
