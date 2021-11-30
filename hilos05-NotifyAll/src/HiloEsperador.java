
public class HiloEsperador implements Runnable {

	Object compartido;
	
	public HiloEsperador(Object compartido) {
		super();
		this.compartido = compartido;
	}

	@Override
	public void run() {
		synchronized (compartido) {
			try {
				System.out.println("Esperando sobre " + compartido); //Siempre el mismo objeto
				compartido.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("["+Thread.currentThread().getName()+"]: He sido notificado.");
	}

}
