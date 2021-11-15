
public class HiloEjecutor extends Thread {

	private String rutaFichero;
	
	public HiloEjecutor(String rutaFichero) {
		super();
		this.rutaFichero = rutaFichero;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Este vector hace de args para el otro programa
		String[] vectorArgs = {rutaFichero};
		ContadorPalabras.main(vectorArgs);
	}

}
