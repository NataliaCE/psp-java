package conexionFTP;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Cliente {

	public static void main(String[] args) throws SocketException, IOException {
		FTPClient cliente = new FTPClient();
		
		cliente.connect("localhost");
		
		boolean conectado = cliente.login("uftp", "hola");
		if(conectado) {
			System.out.println("Conexión correcta!");
			FTPFile[] carpetas = cliente.listDirectories();
			
			
			for(FTPFile carpeta : carpetas) {
				System.out.println(carpeta);
				cliente.cwd(carpeta.getName());
				FTPFile[] archivos = cliente.listFiles();
				
				for(FTPFile archivo : archivos) {
					System.out.println(archivo);
				}
			}
			
			
			if(cliente.logout()) {
				System.out.println("Conexión cerrada.");
			} else {
				System.out.println("No se pudo cerrar la conexión");
			}
		} else {
			System.out.println("La conexión fallo :(");
		}
		
	}

}
