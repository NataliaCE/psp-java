package envioMulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ReceptorMulticast {

	public static void main(String[] args) throws IOException {
		int mcPort = 12345;
	    String mcIPStr = "230.1.1.1";  // esta es la dirección "especial"
	    MulticastSocket mcSocket = null;
	    InetAddress mcIPAddress = null;
	    mcIPAddress = InetAddress.getByName(mcIPStr);
	    mcSocket = new MulticastSocket(mcPort); //Socket de recepción
	    System.out.println("Multicast Receiver running at:"
	        + mcSocket.getLocalSocketAddress());
	    mcSocket.joinGroup(mcIPAddress); //El socket se une a un grupo de multicast

	    DatagramPacket packet = new DatagramPacket(new byte[1024], 1024); //En este paquete se almacena lo que se recibe

	    System.out.println("Esperando mensaje multicast en "+mcIPStr+"...");
	    mcSocket.receive(packet); //Empieza a recibir, está a la escucha. Bloqueante
	    String msg = new String(packet.getData(), packet.getOffset(),
	        packet.getLength());
	    System.out.println("[Multicast  Receiver] Recibido:" + msg);

	    mcSocket.leaveGroup(mcIPAddress); //dejando de escuchar
	    mcSocket.close();

	}

}
