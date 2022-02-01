package conexionFTP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class SubirArchivo {

	public static void main(String[] args) {
		String servidor = "192.168.102.200";
		int puerto = 21; //puerto por defecto de ftp
		String usuario = "uftp";
		String password = "alumno";
		
		FTPClient cliente = new FTPClient();
		
		try {
			cliente.connect(servidor, puerto);
			System.out.println("Conectado.");
			if(cliente.login(usuario, password)) {
				System.out.println("Login correcto :)");
			} else {
				System.out.println("Login incorrecto :(");
			}
			
			//FTP adminte datos de texto y binarios
			cliente.setFileType(FTP.BINARY_FILE_TYPE);
			File archivoLocal = new File("Natalia.txt"); //abro el fichero local
			String archivoRemoto = "FicheroNatalia.txt"; //establezco el nombre de destino
			InputStream is = new FileInputStream(archivoLocal);
			
			System.out.println("Comenzando subida...");
			boolean terminado = cliente.storeFile(archivoRemoto, is);
			is.close(); //enviar no cierra el flujo
			if(terminado) {
				System.out.println("Archivo enviado");
			} else {
				System.out.println("Error en la transmisión");
			}
			
			
		} catch(IOException e) {
			System.err.println("Error: " + e.getMessage());
			
		} finally {
			if(cliente.isConnected()) {
				try {
					cliente.logout();
					cliente.disconnect();
					System.out.println("Cliente desconectado.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		

	}

}
