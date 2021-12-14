package sockets03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorSimultaneo {

	
	
	public static void main(String[] args) throws IOException {
		ArrayList<Socket> clientes = new ArrayList<Socket>();
		ColaMensajes colaMensajes = new ColaMensajes();
		ServerSocket serverSocket = new ServerSocket(5454);
		//El puerto 5454 está solo ocupado mientras el accept está esperando.
		//Se libera cuando se inicia el hilo y se vuelve a ocupar al hacer el bucleS
		Thread hiloPropagador = new Thread(new HiloPropagador(clientes, colaMensajes));
		while(true) {
			Socket sock = serverSocket.accept(); //Se queda esperendo a una conexión
			//new HiloConexion(sock).start();
			HiloConexion hilo = new HiloConexion(sock);
			clientes.add(sock);
			System.out.println("Cliente conectado: " + hilo.getId());
			hilo.start();
		}

	}

}
