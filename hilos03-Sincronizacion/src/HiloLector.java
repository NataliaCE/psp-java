import java.util.ArrayList;

public class HiloLector implements Runnable {

	private ArrayList<String> listaCompra;
	
	
	
	public HiloLector(ArrayList<String> listaCompra) {
		super();
		this.listaCompra = listaCompra;
	}



	@Override
	public void run() {
		synchronized (listaCompra) {
			System.out.println(listaCompra);
		}

	}

}
