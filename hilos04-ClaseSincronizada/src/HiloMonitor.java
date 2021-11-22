
public class HiloMonitor implements Runnable {

	ListaCompra lista;
	
	
	
	public HiloMonitor(ListaCompra lista) {
		super();
		this.lista = lista;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (lista) {
				try {
					lista.wait(); //Se queda esperando hasta que tenga acceso exclusivo a lista(hasta que le notifique lista en Principal)
					System.out.println(lista);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
