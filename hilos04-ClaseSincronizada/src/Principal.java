
public class Principal {

	public static void main(String[] args) throws InterruptedException {
		ListaCompra lista = new ListaCompra();
	
		new Thread(new HiloMonitor(lista)).start();
		synchronized (lista) {
			lista.notify();
		}
		
		new Thread(new HiloInsertador(lista, "Tomates")).start();
		new Thread(new HiloInsertador(lista, "Patatas")).start();
		new Thread(new HiloInsertador(lista, "Naranjas")).start();
		new Thread(new HiloInsertador(lista, "Atún")).start();
		new Thread(new HiloInsertador(lista, "Pasta")).start();

		Thread.sleep(500);
		System.out.println(lista);
	}

}
