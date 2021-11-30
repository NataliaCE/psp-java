package sockets01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		ServerSocket servSock = new ServerSocket(5252);
		Socket socket = servSock.accept(); //Se queda esperando a que alguien llame
		System.out.println(socket.getInetAddress().toString()); //Indica de donde viene la conexión recibida
	}

}
