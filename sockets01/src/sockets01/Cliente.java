package sockets01;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//Prepara y conecta el socket
		Socket socket = new Socket("192.168.102.200", 5252); //Ip y puerto
	}

}
