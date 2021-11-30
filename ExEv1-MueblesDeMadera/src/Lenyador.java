import java.util.concurrent.ThreadLocalRandom;

public class Lenyador implements Runnable {

	Aserradero aserradero;

	public Lenyador(Aserradero aserradero) {
		super();
		this.aserradero = aserradero;
	}

	@Override
	public void run() {
		// Mientras el aserradero no esté parado,
		// el carpintero dormirá un tiempo aleatorio entre 1 y 2 segundos:
		synchronized (aserradero) {
			boolean AserraderoParado = aserradero.aserraderoParado();
			while(AserraderoParado = true) {
				try {
					int dormir = ThreadLocalRandom.current().nextInt(1, 2 + 1);
					int madera = ThreadLocalRandom.current().nextInt(1, 3 + 1);
					Thread.sleep(dormir);
					aserradero.agregarMadera(madera);
					aserradero.notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		// int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		// y añadirá un número aleatorio entre 1 y 3 unidades de madera al aserradero.
		// después de añadir la madera, notificará sobre el propio objeto aserradero que
		// hay madera disponible.

	}

}
