
public class Principal {

	public static void main(String[] args) throws InterruptedException {
		Object objCompartido = new Object();

		System.out.println("[Principal]: Lanzando hilos");
		for (int i = 0; i < 5; i++) {
			new Thread(new HiloEsperador(objCompartido)).start();
		}

		System.out.println("[Principal]: Hilos lanzados, espero 1 segundo");
		Thread.sleep(1000);
		System.out.println("[Principal]: Notificando a todos");
		synchronized (objCompartido) {
			objCompartido.notifyAll();
			/*
			 * NotifyAll despierta a todos los hilos. Si pusiera solamente Notify,
			 * despertaría al primer hilo y el resto se quedarían esperando
			 */
		}
		System.out.println("[Principal]: Hilos notificados");

	}

}
//Control + Shift + F --> Arregla indentación
/*
 * Si la notificación se hace antes de que que se haga el wait, la notificación se guarda y funciona igualmente.
 * Solo se guarda si está dentro del synchronized
 * La notificación debe suceder después de haberse creado el hilo.
 * 
 */
