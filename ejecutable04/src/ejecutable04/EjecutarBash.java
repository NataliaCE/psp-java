package ejecutable04;

import java.io.IOException;

public class EjecutarBash {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ProcessBuilder constructor = new ProcessBuilder("bash", "/home/alumno/repos/psp-test/retorno.sh", "2");
		Process proceso1 = constructor.start();
		int retorno = proceso1.waitFor();
		
		constructor = new ProcessBuilder("bash", "/home/alumno/repos/psp-test/retorno.sh", Integer.toString(retorno));
		Process proceso2 = constructor.start();
		int retorno2 = proceso2.waitFor();
		System.out.println(retorno2);
	}

}
