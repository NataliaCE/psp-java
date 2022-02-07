package ejercicioFTP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Descargar {

	public static void main(String[] args) throws SocketException, IOException {
		FTPClient cliente = new FTPClient();
		
		cliente.connect("localhost");

		try {
			if(cliente.login("uftp", "alumno")) {
				System.out.println("Conectado");
			
			} else {
				System.out.println("Login incorrecto");
			}
			
			//Archivos de carpeta raiz
			FTPFile[] archivos = cliente.listFiles();
			for(FTPFile archivo : archivos) {
				if(archivo.isDirectory()) {
					cliente.cwd(archivo.getName());
					FTPFile[] subArchivos = cliente.listFiles();
					
					if(subArchivos.length == 0) {
						System.out.println("Carpeta vacia");
						
					} else {
						for(FTPFile subArchivo : subArchivos) {
							cliente.setFileType(FTP.BINARY_FILE_TYPE);
							File archivoLocal = new File(subArchivo.getName());
							String archivoRemoto = subArchivo.getName();
							
							OutputStream os = new FileOutputStream(archivoLocal);
							System.out.println("Comenzando descarga...");
							boolean descargado = cliente.retrieveFile(archivoRemoto, os);
							os.close();
							if(descargado) {
								System.out.println("Archivo descargado.");
							} else {
								System.out.println("El fichero no se descargó :(");
							}
						}
					}
					
				} else if(archivo.isFile()) {
					cliente.setFileType(FTP.BINARY_FILE_TYPE);
					File archivoLocal = new File(archivo.getName());
					String archivoRemoto = archivo.getName();
					
					OutputStream os = new FileOutputStream(archivoLocal);
					System.out.println("Comenzando descarga...");
					boolean descargado = cliente.retrieveFile(archivoRemoto, os);
					os.close();
					if(descargado) {
						System.out.println("Archivo descargado.");
					} else {
						System.out.println("El fichero no se descargó :(");
					}
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
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
