package ejecutable02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LanzaPrograma {

	public static void main(String[] args) throws IOException {
		Process proceso = Runtime.getRuntime().exec("sleep 3");
		//conectamos un reader (lector) a la salida del proceso
		BufferedReader salida = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
		
		//mientras haya datos a la salida, leelos de línea en línea
		//e imprimelos por la salida estandar.
		while(salida.ready()) {
			System.out.println(salida.readLine());
		}

	}

}
