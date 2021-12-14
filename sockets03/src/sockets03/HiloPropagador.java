package sockets03;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class HiloPropagador implements Runnable {

	ArrayList<Socket> clientes;
	ColaMensajes colaMensajes;
	
	public HiloPropagador(ArrayList<Socket> clientes, ColaMensajes colaMensajes) {
		super();
		this.clientes = clientes;
		this.colaMensajes = colaMensajes;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (colaMensajes) {
				try {
					colaMensajes.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Mensaje m = colaMensajes.obtenerMensaje(); //obtenerMensaje() ya esta sincronizado.
			DataOutputStream salida = null;
			for (Socket socket : clientes) {
				try {
					salida = new DataOutputStream(socket.getOutputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					salida.writeUTF(m.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
