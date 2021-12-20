import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Servidor {
	
	public static final int PUERTO = 5454;

	public static void main(String[] args) throws IOException {
		ServerSocket servSock = new ServerSocket(PUERTO);
		Socket socket = servSock.accept();
		
		//Creo el objeto mensaje
		Mensaje msj = new Mensaje(new Date(), "hola mundo", socket.getLocalAddress());
		
		//Obtengo un canal de salida de objetos
		ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
		//Envio el objeto
		salida.writeObject(msj);
		salida.close();
		socket.close();
	}

}
