package sockets01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		//Prepara y conecta el socket
		Socket socket = new Socket("localhost", 5252); //Ip y puerto
		DataInputStream entrada = new DataInputStream(socket.getInputStream());
		System.out.println("El servidor me dice: " + entrada.readUTF());
		DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
		Thread.sleep(5000);
		salida.writeUTF("Soy el cliente!!");
	}

}
