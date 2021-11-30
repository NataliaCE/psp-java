
public class Carpintero extends Thread{

	Aserradero aserradero;
	Object finalCarpintero;
	int mueblesEncargados;
		
	public Carpintero(Aserradero aserradero, Object finalCarpintero, int numeroMuebles) {
		super();
		this.aserradero = aserradero;
		this.finalCarpintero = finalCarpintero;
		this.mueblesEncargados = numeroMuebles;
	}

	@Override
	public void run() {
		int mueblesCreados = 0;
		//El carpintero debe crear muebles hasta que los muebles creados sean los muebles encargados.
		//Comprobará la disponibilidad de madera antes de lanzarse a crear un mueble (los muebles cuestan 5 unidades)
		//Si no hay madera, se quedará esperando una notificación sobre el propio aserradero
		//Cuando haya finalizado notificará sobre el objeto finalCarpintero
		while(mueblesEncargados > mueblesCreados) {
			synchronized (aserradero) {
				if(!aserradero.hayMadera(5)) { //Comprueba si hay suficiente madera
					try {
						aserradero.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			mueblesCreados++;
			System.out.println("Mueble creado.");
		}

		synchronized (finalCarpintero) {//Ya ha terminado y notifica al pricipal
			finalCarpintero.notify();
		}
	}
}
