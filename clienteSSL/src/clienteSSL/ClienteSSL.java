package clienteSSL;

import java.io.IOException;
import java.net.Socket;

import javax.net.ssl.SSLSocketFactory;

public class ClienteSSL {

	public static void main(String[] args) throws IOException {

		// Almacen del certificado del servidor
		System.setProperty("javax.net.ssl.keyStore", "/home/alumno/SSL/almacenCliente.p12");

		// Contraseña del almacen del certificado del servidor
		System.setProperty("javax.net.ssl.keyStorePassword", "test321");

		// Almacen de certificados en que confio. En este caso es el mismo que el del
		// servidor
		System.setProperty("javax.net.ssl.trustStore", "/home/alumno/SSL/almacenCliente.p12");

		// Contraseña del almacen de los certificados en que confio
		System.setProperty("javax.net.ssl.keyTrustPassword", "test321");
		
		SSLSocketFactory sslFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		Socket socket = sslFactory.createSocket("192.168.102.10", 5566);
		
		socket.close();

	}

}
