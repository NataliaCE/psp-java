package conexionFTP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class DescargarArchivo {

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
			File archivoLocal = new File("FicheroDescargado.txt"); //abro el fichero local
			String archivoRemoto = "aaa/descargame.txt"; //establezco el nombre de destino
			OutputStream os = new FileOutputStream(archivoLocal);
			
			System.out.println("Comenzando descarga...");
			boolean descargado = cliente.retrieveFile(archivoRemoto, os);
			os.close();
			if(descargado) {
				System.out.println("Archivo descargado.");
			} else {
				System.out.println("El fichero no se descargó :(");
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
