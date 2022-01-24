package envioMulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class EmisorMulticastWhile {
	public static void main(String[] args) throws IOException {
		int mcPort = 12345;
	    String mcIPStr = "230.1.1.1";
	    DatagramSocket udpSocket = new DatagramSocket(); //Usa protocolo TCP (protocolo de transporte)

	    InetAddress mcIPAddress = InetAddress.getByName(mcIPStr);
	    String str = "";
	    Scanner teclado = new Scanner(System.in);
	    while(!str.equals("/quit")) {
	    	str = teclado.nextLine();
	    	byte[] msg = str.getBytes(); //El mensaje se envia en bytes
	    	DatagramPacket packet = new DatagramPacket(msg, msg.length); //El paquete que se va a enviar
		    packet.setAddress(mcIPAddress);
		    packet.setPort(mcPort);
		    udpSocket.send(packet);//Se envia
		    
		    System.out.println("Mensaje enviado a "+mcIPStr+".");
	    }
	    
	    System.out.println("Saliendo...");
	    udpSocket.close();
	}
}
