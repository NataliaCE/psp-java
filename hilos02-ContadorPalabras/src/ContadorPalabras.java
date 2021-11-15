import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContadorPalabras {
	/**
	 * Cuenta palabras de un fichero proporcionado
	 * @param args
	 * @throws FileNotFoundException 
	 */

	public static void main(String[] args) {
		String rutaFichero = "/home/alumno/texto.txt";
		
		//Si se pasa fichero por argumento, usa ese en lugar de texto.txt
		if(args.length > 0) {
			rutaFichero = args[0];
		}
		Scanner lector;
		
		try {
			lector = new Scanner(new File(rutaFichero));
			int contador = 0;
			
			while(lector.hasNext()) {
				lector.next();
				contador++;
			}
			System.out.println("Total palabras: " + contador + ".");
			
		} catch (FileNotFoundException e) {
			System.err.println("Fichero " + rutaFichero + " no encontrado.");
			e.printStackTrace();
		}
		

	}

}
